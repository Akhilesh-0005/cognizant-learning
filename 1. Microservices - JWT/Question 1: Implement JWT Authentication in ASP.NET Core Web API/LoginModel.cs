using System.ComponentModel.DataAnnotations;

namespace JwtAuthDemo.Models
{
    /// <summary>
    /// Payload sent by the client when logging in.
    /// </summary>
    public class LoginModel
    {
        [Required]
        public string Username { get; set; } = string.Empty;

        [Required]
        public string Password { get; set; } = string.Empty;
    }
}
