using Microsoft.AspNetCore.Mvc;

namespace WebApiDemo.Controllers
{
    public class Employee
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Salary { get; set; }
    }

    [Route("api/[controller]")]   // change "[controller]" to "Emp" to test the renamed route
    [ApiController]
    public class EmployeeController : ControllerBase
    {
        private static readonly List<Employee> _employees = new()
        {
            new Employee { Id = 1, Name = "Asha Rao", Salary = 55000 },
            new Employee { Id = 2, Name = "Vikram Shah", Salary = 48000 }
        };

        // GET api/employee
        [HttpGet(Name = "GetAllEmployees")]
        [ProducesResponseType(typeof(IEnumerable<Employee>), 200)]
        public ActionResult<IEnumerable<Employee>> Get()
        {
            return Ok(_employees);
        }

        // GET api/employee/standard  -> exposed as action name "GetStandard"
        [HttpGet("standard")]
        [ActionName("GetStandard")]
        public ActionResult<IEnumerable<Employee>> GetStandardEmployeeList()
        {
            return Ok(_employees);
        }

        // GET api/employee/premium  -> exposed as action name "GetPremium"
        [HttpGet("premium")]
        [ActionName("GetPremium")]
        public ActionResult<IEnumerable<Employee>> GetPremiumEmployeeList()
        {
            return Ok(_employees.Where(e => e.Salary > 50000));
        }

        // POST api/employee
        [HttpPost]
        public IActionResult Post([FromBody] Employee employee)
        {
            _employees.Add(employee);
            return CreatedAtRoute("GetAllEmployees", null, employee);
        }
    }
}
