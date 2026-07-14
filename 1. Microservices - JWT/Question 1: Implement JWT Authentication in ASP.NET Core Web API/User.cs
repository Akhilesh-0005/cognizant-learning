namespace JwtAuthDemo.Models
{
    /// <summary>
    /// Represents an application user.
    /// In a real project this would be backed by a database table
    /// (e.g. via EF Core) instead of an in-memory list.
    /// </summary>
    public class User
    {
        public int Id { get; set; }
        public string Username { get; set; } = string.Empty;
        public string PasswordHash { get; set; } = string.Empty;
        public string Role { get; set; } = "User";
    }
}
