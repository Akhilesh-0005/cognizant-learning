using Microsoft.AspNetCore.Mvc;
using WebApiDemo.Models;

namespace WebApiDemo.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeeController : ControllerBase
    {
        private static readonly List<Employee> _employees = GetStandardEmployeeList();

        private static List<Employee> GetStandardEmployeeList()
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
        [ProducesResponseType(typeof(List<Employee>), 200)]
        public ActionResult<List<Employee>> Get()
        {
            return Ok(_employees);
        }

        // PUT api/employee/5
        [HttpPut("{id}")]
        [ProducesResponseType(typeof(Employee), 200)]
        [ProducesResponseType(400)]
        public ActionResult<Employee> Put(int id, [FromBody] Employee updatedEmployee)
        {
            // 1. Validate the id itself
            if (id <= 0)
            {
                return BadRequest("Invalid employee id");
            }

            // 2. Validate that the id exists in the hardcoded list
            var existingEmployee = _employees.FirstOrDefault(e => e.Id == id);
            if (existingEmployee == null)
            {
                return BadRequest("Invalid employee id");
            }

            // 3. Apply the update from the request body
            existingEmployee.Name = updatedEmployee.Name;
            existingEmployee.Salary = updatedEmployee.Salary;
            existingEmployee.Permanent = updatedEmployee.Permanent;
            existingEmployee.Department = updatedEmployee.Department;
            existingEmployee.Skills = updatedEmployee.Skills;
            existingEmployee.DateOfBirth = updatedEmployee.DateOfBirth;

            // 4. Return the updated employee, filtered from the list for the given id
            var result = _employees.FirstOrDefault(e => e.Id == id);
            return Ok(result);
        }

        // DELETE api/employee/5
        [HttpDelete("{id}")]
        [ProducesResponseType(200)]
        [ProducesResponseType(400)]
        public IActionResult Delete(int id)
        {
            if (id <= 0)
                return BadRequest("Invalid employee id");

            var existingEmployee = _employees.FirstOrDefault(e => e.Id == id);
            if (existingEmployee == null)
                return BadRequest("Invalid employee id");

            _employees.Remove(existingEmployee);
            return Ok($"Employee with id {id} deleted successfully");
        }
    }
}
