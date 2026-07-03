using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using WebApiDemo.Filters;
using WebApiDemo.Models;

namespace WebApiDemo.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [CustomAuthFilter]   // intercepts every request to this controller for an Authorization: Bearer header
    public class EmployeeController : ControllerBase
    {
        private readonly List<Employee> _employees;

        public EmployeeController()
        {
            _employees = GetStandardEmployeeList();
        }

        private List<Employee> GetStandardEmployeeList()
        {
            return new List<Employee>
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
        }

        // GET api/employee
        [HttpGet]
        [AllowAnonymous]   // publicly accessible even though the controller requires Auth
        [ProducesResponseType(typeof(List<Employee>), 200)]
        public ActionResult<List<Employee>> GetStandrad()
        {
            return Ok(GetStandardEmployeeList());
        }

        // GET api/employee/boom  -> used to trigger and test the exception filter
        [HttpGet("boom")]
        [AllowAnonymous]
        [ProducesResponseType(500)]
        public IActionResult TriggerError()
        {
            throw new InvalidOperationException("Simulated failure for exception filter test");
        }

        // POST api/employee
        [HttpPost]
        public IActionResult Post([FromBody] Employee employee)
        {
            _employees.Add(employee);
            return CreatedAtAction(nameof(GetStandrad), employee);
        }

        // PUT api/employee/5
        [HttpPut("{id}")]
        public IActionResult Put(int id, [FromBody] Employee employee)
        {
            var existing = _employees.FirstOrDefault(e => e.Id == id);
            if (existing == null) return NotFound();

            existing.Name = employee.Name;
            existing.Salary = employee.Salary;
            return Ok(existing);
        }
    }
}
