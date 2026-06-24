// ── Model ──
class Student {
    private String name;
    private int    id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name  = name;
        this.id    = id;
        this.grade = grade;
    }

    public String getName()  { return name; }
    public int    getId()    { return id; }
    public String getGrade() { return grade; }

    public void setName(String name)   { this.name  = name; }
    public void setGrade(String grade) { this.grade = grade; }
}

// ── View ──
class StudentView {
    public void displayStudentDetails(String name, int id, String grade) {
        System.out.println("+--------------------------+");
        System.out.println("  Student Details");
        System.out.println("+--------------------------+");
        System.out.println("  Name  : " + name);
        System.out.println("  ID    : " + id);
        System.out.println("  Grade : " + grade);
        System.out.println("+--------------------------+");
    }
}

// ── Controller ──
class StudentController {
    private final Student     model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view  = view;
    }

    public void updateStudentName(String name)   { model.setName(name); }
    public void updateStudentGrade(String grade) { model.setGrade(grade); }

    public void displayStudentDetails() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// ── Main / Test Class ──
public class MVCPatternExample {
    public static void main(String[] args) {
        System.out.println("=== MVC Pattern — Student Records ===\n");

        Student     model      = new Student("Akhilesh Kumar", 1001, "A");
        StudentView view       = new StudentView();
        StudentController ctrl = new StudentController(model, view);

        System.out.println("-- Initial Details --");
        ctrl.displayStudentDetails();

        ctrl.updateStudentName("Akhilesh K.");
        ctrl.updateStudentGrade("A+");

        System.out.println("\n-- Updated Details --");
        ctrl.displayStudentDetails();

        System.out.println("\nMVC Pattern implemented successfully.");
    }
}
