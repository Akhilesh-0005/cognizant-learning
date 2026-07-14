using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace JwtAuthDemo.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class SecureController : ControllerBase
    {
        /// <summary>
        /// Only reachable with a valid JWT in the Authorization header:
        /// Authorization: Bearer {token}
        /// GET api/secure/data
        /// </summary>
        [Authorize]
        [HttpGet("data")]
        public IActionResult GetSecureData()
        {
            var username = User.Identity?.Name ?? "unknown";
            return Ok(new
            {
                message = $"Hello {username}, this is protected data.",
                timestamp = DateTime.UtcNow
            });
        }
    }
}
