using Confluent.Kafka;

namespace KafkaChatDemo.WinFormsApp
{
    public partial class ChatWinFormsClient : Form
    {
        private readonly CancellationTokenSource _cts = new();

        public ChatWinFormsClient()
        {
            InitializeComponent();
            StartListening();
        }

        private void StartListening()
        {
            Task.Run(() =>
            {
                var config = new ConsumerConfig
                {
                    BootstrapServers = "localhost:9092",
                    GroupId = $"chat-winforms-{Guid.NewGuid()}",   // unique per client instance
                    AutoOffsetReset = AutoOffsetReset.Latest
                };

                using var consumer = new ConsumerBuilder<Null, string>(config).Build();
                consumer.Subscribe("chat-messages");

                try
                {
                    while (!_cts.IsCancellationRequested)
                    {
                        var result = consumer.Consume(_cts.Token);
                        this.Invoke((Action)(() => chatListBox.Items.Add(result.Message.Value)));
                    }
                }
                catch (OperationCanceledException)
                {
                    // expected on shutdown
                }
            });
        }

        private async void SendButton_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(messageTextBox.Text)) return;

            var config = new ProducerConfig { BootstrapServers = "localhost:9092" };
            using var producer = new ProducerBuilder<Null, string>(config).Build();

            await producer.ProduceAsync("chat-messages",
                new Message<Null, string> { Value = messageTextBox.Text });

            messageTextBox.Clear();
        }

        protected override void OnFormClosing(FormClosingEventArgs e)
        {
            _cts.Cancel();
            base.OnFormClosing(e);
        }
    }
}
