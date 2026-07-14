using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using JwtAuthDemo.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;

namespace JwtAuthDemo.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class AuthController : ControllerBase
    {
        private readonly IConfiguration _configuration;

        public AuthController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        /// <summary>
        /// Authenticates a user and returns a signed JWT on success.
        /// POST api/auth/login
        /// </summary>
        [HttpPost("login")]
        public IActionResult Login([FromBody] LoginModel model)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (!IsValidUser(model))
            {
                return Unauthorized(new { message = "Invalid username or password" });
            }

            var (token, expiresAt) = GenerateJwtToken(model.Username);

            return Ok(new TokenResponse
            {
                Token = token,
                ExpiresAt = expiresAt
            });
        }

        /// <summary>
        /// Placeholder credential check.
        /// Replace with a real lookup against a database and a hashed
        /// password comparison (e.g. BCrypt.Verify) in a production app.
        /// </summary>
        private bool IsValidUser(LoginModel model)
        {
            return model.Username == "admin" && model.Password == "password123";
        }

        private (string Token, DateTime ExpiresAt) GenerateJwtToken(string username)
        {
            var claims = new[]
            {
                new Claim(ClaimTypes.Name, username),
                new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString())
            };

            var key = new SymmetricSecurityKey(
                Encoding.UTF8.GetBytes(_configuration["Jwt:Key"]!));
            var creds = new SigningCredentials(key, SecurityAlgorithms.HmacSha256);

            var durationInMinutes = double.Parse(_configuration["Jwt:DurationInMinutes"]!);
            var expiresAt = DateTime.UtcNow.AddMinutes(durationInMinutes);

            var token = new JwtSecurityToken(
                issuer: _configuration["Jwt:Issuer"],
                audience: _configuration["Jwt:Audience"],
                claims: claims,
                expires: expiresAt,
                signingCredentials: creds);

            var tokenString = new JwtSecurityTokenHandler().WriteToken(token);
            return (tokenString, expiresAt);
        }
    }
}
