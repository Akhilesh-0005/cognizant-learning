using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using WebApiDemo.Models;

namespace WebApiDemo.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize(Roles = "POC,Admin")]   // step through: [Authorize] -> Roles="POC" -> Roles="POC,Admin"
    public class EmployeeController : ControllerBase
    {
        private static readonly List<Employee> _employees = new()
        {
            new Employee
            {
                Id = 1, Name = "Asha Rao", Salary = 55000, Permanent = true,
                Department = new Department { Id = 1, Name = "Engineering" },
                Skills = new List<Skill> { new Skill { Id = 1, Name = "C#" } },
                DateOfBirth = new DateTime(1992, 4, 12)
            },
            new Employee
            {
                Id = 2, Name = "Vikram Shah", Salary = 48000, Permanent = false,
                Department = new Department { Id = 2, Name = "QA" },
                Skills = new List<Skill> { new Skill { Id = 2, Name = "Selenium" } },
                DateOfBirth = new DateTime(1995, 9, 30)
            }
        };

        // GET api/employee
        [HttpGet]
        [ProducesResponseType(typeof(List<Employee>), 200)]
        [ProducesResponseType(401)]
        public ActionResult<List<Employee>> Get()
        {
            return Ok(_employees);
        }
    }
}
