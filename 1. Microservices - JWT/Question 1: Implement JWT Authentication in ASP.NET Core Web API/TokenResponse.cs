namespace JwtAuthDemo.Models
{
    /// <summary>
    /// Shape of the JSON returned to the client after a successful login.
    /// </summary>
    public class TokenResponse
    {
        public string Token { get; set; } = string.Empty;
        public DateTime ExpiresAt { get; set; }
    }
}
