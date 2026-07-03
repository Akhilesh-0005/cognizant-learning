using Confluent.Kafka;

class ChatConsumer
{
    static void Main(string[] args)
    {
        var config = new ConsumerConfig
        {
            BootstrapServers = "localhost:9092",
            GroupId = "chat-console-group",
            AutoOffsetReset = AutoOffsetReset.Earliest
        };

        using var consumer = new ConsumerBuilder<Null, string>(config).Build();
        consumer.Subscribe("chat-messages");

        Console.WriteLine("Listening for chat messages... (Ctrl+C to stop)");
        while (true)
        {
            var result = consumer.Consume();
            Console.WriteLine($"[{result.Message.Timestamp.UtcDateTime:T}] {result.Message.Value}");
        }
    }
}
