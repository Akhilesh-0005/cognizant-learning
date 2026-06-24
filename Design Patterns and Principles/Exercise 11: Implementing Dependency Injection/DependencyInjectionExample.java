import java.util.HashMap;
import java.util.Map;

// ── Model ──
class Customer {
    private final int    id;
    private final String name;
    private final String email;

    public Customer(int id, String name, String email) {
        this.id    = id;
        this.name  = name;
        this.email = email;
    }

    public int    getId()    { return id; }
    public String getName()  { return name; }
    public String getEmail() { return email; }
}

// ── Repository Interface ──
interface CustomerRepository {
    Customer findCustomerById(int id);
}

// ── Concrete Repository ──
class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<Integer, Customer> db = new HashMap<>();

    public CustomerRepositoryImpl() {
        db.put(1, new Customer(1, "Akhilesh Kumar", "akhilesh@example.com"));
        db.put(2, new Customer(2, "Rahul Sharma",   "rahul@example.com"));
        db.put(3, new Customer(3, "Priya Singh",    "priya@example.com"));
    }

    public Customer findCustomerById(int id) {
        return db.getOrDefault(id, null);
    }
}

// ── Service Class (Constructor Injection) ──
class CustomerService {
    private final CustomerRepository repository;

    // Dependency injected via constructor
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerDetails(int id) {
        Customer c = repository.findCustomerById(id);
        if (c != null) {
            System.out.println("Customer Found:");
            System.out.println("  ID    : " + c.getId());
            System.out.println("  Name  : " + c.getName());
            System.out.println("  Email : " + c.getEmail());
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
    }
}

// ── Main / Test Class ──
public class DependencyInjectionExample {
    public static void main(String[] args) {
        System.out.println("=== Dependency Injection — Customer Management ===\n");

        // Inject repository into service
        CustomerRepository repo    = new CustomerRepositoryImpl();
        CustomerService    service = new CustomerService(repo);

        service.getCustomerDetails(1);
        System.out.println();
        service.getCustomerDetails(2);
        System.out.println();
        service.getCustomerDetails(99);   // not found

        System.out.println("\nDependency Injection implemented successfully.");
    }
}
