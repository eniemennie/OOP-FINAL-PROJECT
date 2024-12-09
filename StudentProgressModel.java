import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Abstract base class for Academic Work
abstract class AcademicWork {
    private final String title;
    private final double weight;
    private double grade;

    public AcademicWork(String title, double weight) {
        this.title = title;
        this.weight = weight;
        this.grade = 0.0;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public double getWeight() {
        return weight;
    }

    public double getGrade() {
        return grade;
    }

    // Setter for grade with validation
    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return title + " (Grade: " + grade + ", Weight: " + weight + ")";
    }
}

// Specific types of Academic Work
class Assignment extends AcademicWork {
    public Assignment(String title, double weight) {
        super(title, weight);
    }
}

class Project extends AcademicWork {
    public Project(String title, double weight) {
        super(title, weight);
    }
}

// Student Progress Model
class StudentProgressModel {
    private static final Logger LOGGER = Logger.getLogger(StudentProgressModel.class.getName());

    private String name;
    private String studentId;
    private List<AcademicWork> academicWorks;

    public StudentProgressModel(String name, String studentId) {
        validateInput(name, studentId);
        
        this.name = name;
        this.studentId = studentId;
        this.academicWorks = new ArrayList<>();
    }

    public StudentProgressModel() {
    }

    // Input validation method
    private void validateInput(String name, String studentId) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty");
        }
    }

    // Add academic work
    public void addAcademicWork(AcademicWork work) {
        if (work == null) {
            throw new IllegalArgumentException("Academic work cannot be null");
        }
        academicWorks.add(work);
        LOGGER.log(Level.INFO, "Added academic work: {0}", work.getTitle());
    }

    // Calculate weighted overall grade
    public double calculateOverallGrade() {
        if (academicWorks.isEmpty()) {
            return 0.0;
        }

        double totalWeightedGrade = 0.0;
        double totalWeight = 0.0;

        for (AcademicWork work : academicWorks) {
            totalWeightedGrade += work.getGrade() * work.getWeight();
            totalWeight += work.getWeight();
        }

        return totalWeightedGrade / (totalWeight > 0 ? totalWeight : 1);
    }

    // Get highest graded work
    public AcademicWork getHighestGradedWork() {
        return academicWorks.stream()
            .max((w1, w2) -> Double.compare(w1.getGrade(), w2.getGrade()))
            .orElse(null);
    }

    // Get lowest graded work
    public AcademicWork getLowestGradedWork() {
        return academicWorks.stream()
            .min((w1, w2) -> Double.compare(w1.getGrade(), w2.getGrade()))
            .orElse(null);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<AcademicWork> getAcademicWorks() {
        return new ArrayList<>(academicWorks); // Return a copy
    }

    @Override
    public String toString() {
        return "Student: " + name + " (ID: " + studentId + ")";
    }
}

// Student Progress System (Main Application)
class StudentProgressSystem {
    private final List<StudentProgressModel> students;
    private static final Logger LOGGER = Logger.getLogger(StudentProgressSystem.class.getName());

    public StudentProgressSystem() {
        students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(StudentProgressModel student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        
        // Check for duplicate student ID
        boolean exists = students.stream()
            .anyMatch(s -> s.getStudentId().equals(student.getStudentId()));
        
        if (exists) {
            LOGGER.log(Level.WARNING, "Student with ID {0} already exists", student.getStudentId());
            return;
        }
        
        students.add(student);
        LOGGER.log(Level.INFO, "Added student: {0}", student.getName());
    }

    // Find student by ID
    public StudentProgressModel findStudentById(String studentId) {
        return students.stream()
            .filter(s -> s.getStudentId().equals(studentId))
            .findFirst()
            .orElse(null);
    }

    // Get all students
    public List<StudentProgressModel> getAllStudents() {
        return new ArrayList<>(students);
    }

    // Remove student by ID
    public boolean removeStudent(String studentId) {
        return students.removeIf(s -> s.getStudentId().equals(studentId));
    }

    // Example usage method
    public static void main(String[] args) {
        StudentProgressSystem system = new StudentProgressSystem();

        // Create a student
        StudentProgressModel student = new StudentProgressModel("John Doe", "S12345");

        // Add academic works
        Assignment assignment1 = new Assignment("Math Homework", 0.3);
        assignment1.setGrade(85.5);
        
        Project project1 = new Project("Science Project", 0.7);
        project1.setGrade(92.0);

        student.addAcademicWork(assignment1);
        student.addAcademicWork(project1);

        // Add student to system
        system.addStudent(student);

        // Calculate and print overall grade
        System.out.println("Overall Grade: " + student.calculateOverallGrade());
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }
}