using Confluent.Kafka;

class ChatProducer
{
    static async Task Main(string[] args)
    {
        var config = new ProducerConfig { BootstrapServers = "localhost:9092" };

        using var producer = new ProducerBuilder<Null, string>(config).Build();

        Console.WriteLine("Type a message and press Enter to send. Type 'exit' to quit.");
        string? input;
        while ((input = Console.ReadLine()) != "exit")
        {
            if (string.IsNullOrEmpty(input)) continue;

            var result = await producer.ProduceAsync(
                "chat-messages",
                new Message<Null, string> { Value = input });

            Console.WriteLine($"Sent to partition {result.Partition}, offset {result.Offset}");
        }
    }
}
