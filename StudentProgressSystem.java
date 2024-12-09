import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class StudentProgressSystem extends JFrame {

    private final JTextField nameField;
    private final JTextField idField;
    private final JTextField titleField;
    private final JTextField maxPointsField;
    private final JTextField weightField;
    private final JTextField assignmentGradeField;
    private final JTextField projectGradeField;
    private final JTextArea displayArea;
    private Student student;

    public StudentProgressSystem() {
        setTitle("Student Progress System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 900); // Increased window size
        setLayout(new GridBagLayout());
        setResizable(true); // Allow resizing
    
        // Set modern theme
        UIManager.put("Button.background", new Color(100, 149, 237)); // Cornflower blue
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("TextField.foreground", Color.BLACK);
        getContentPane().setBackground(new Color(240, 240, 240)); // Light gray background
    
        // Initialize components with larger text fields
        nameField = new JTextField(20); // Increased size
        idField = new JTextField(20);
        titleField = new JTextField(20);
        maxPointsField = new JTextField(20);
        weightField = new JTextField(20);
        assignmentGradeField = new JTextField(20);
        projectGradeField = new JTextField(20);
        
        displayArea = new JTextArea(10, 40); // Increased size
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Slightly larger font
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
    
        JScrollPane displayScrollPane = new JScrollPane(displayArea);
        
        // Create buttons with larger font
        JButton createStudentButton = createStyledButton("Create Student");
        JButton addAssignmentButton = createStyledButton("Add Assignment");
        JButton addProjectButton = createStyledButton("Add Project");
        JButton showProgressButton = createStyledButton("Show Progress");
        JButton setAssignmentGradeButton = createStyledButton("Set Assignment Grade");
        JButton setProjectGradeButton = createStyledButton("Set Project Grade");
    
        // Event listeners remain the same
        createStudentButton.addActionListener(e -> createStudent());
        addAssignmentButton.addActionListener(e -> addAssignment());
        addProjectButton.addActionListener(e -> addProject());
        showProgressButton.addActionListener(e -> showProgress());
        setAssignmentGradeButton.addActionListener(e -> setAssignmentGrade());
        setProjectGradeButton.addActionListener(e -> setProjectGrade());
    
        // Layout configuration
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Increased padding
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.2;
    
        // Student Panel
        JPanel studentPanel = createSectionPanel("Student Information");
        gbc.gridx = 0;
        gbc.gridy = 0;
        studentPanel.add(new JLabel("Name:", SwingConstants.RIGHT), gbc);
        gbc.gridx = 1;
        studentPanel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        studentPanel.add(new JLabel("Student ID:", SwingConstants.RIGHT), gbc);
        gbc.gridx = 1;
        studentPanel.add(idField, gbc);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        studentPanel.add(createStudentButton, gbc);
    
        // Academic Panel
        JPanel academicPanel = createSectionPanel("Academic Work");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        academicPanel.add(new JLabel("Title:", SwingConstants.RIGHT), gbc);
        gbc.gridx = 1;
        academicPanel.add(titleField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        academicPanel.add(new JLabel("Max Points:", SwingConstants.RIGHT), gbc);
        gbc.gridx = 1;
        academicPanel.add(maxPointsField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        academicPanel.add(new JLabel("Weight:", SwingConstants.RIGHT), gbc);
        gbc.gridx = 1;
        academicPanel.add(weightField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        academicPanel.add(addAssignmentButton, gbc);
        gbc.gridx = 1;
        academicPanel.add(addProjectButton, gbc);
    
        // Grades Panel
        JPanel gradesPanel = createSectionPanel("Grades");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gradesPanel.add(new JLabel("Assignment Grade:", SwingConstants.RIGHT), gbc);
        gbc.gridx = 1;
        gradesPanel.add(assignmentGradeField, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gradesPanel.add(new JLabel("Project Grade:", SwingConstants.RIGHT), gbc);
        gbc.gridx = 1;
        gradesPanel.add(projectGradeField, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gradesPanel.add(setAssignmentGradeButton, gbc);
        gbc.gridx = 1;
        gradesPanel.add(setProjectGradeButton, gbc);
    
        // Display Panel
        JPanel displayPanel = createSectionPanel("Progress");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        displayPanel.add(showProgressButton, gbc);
        gbc.gridy = 1;
        displayPanel.add(displayScrollPane, gbc);
    
        // Add panels to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(studentPanel, gbc);
    
        gbc.gridy++;
        add(academicPanel, gbc);
    
        gbc.gridy++;
        add(gradesPanel, gbc);
    
        gbc.gridy++;
        gbc.weighty = 0.5; // Allocate more space to display panel
        add(displayPanel, gbc);
    }
    
    private JPanel createSectionPanel(String title) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(100, 149, 237)), title));
        panel.setBackground(new Color(250, 250, 250)); // Light background
        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBackground(new Color(100, 149, 237)); // Cornflower blue
        button.setForeground(Color.WHITE);
        return button;
    }

    private void createStudent() {
        String name = nameField.getText().trim();
        String id = idField.getText().trim();
        if (name.isEmpty() || id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        student = new Student(name, id);
        displayArea.setText("Student " + name + " created.\n");
    }

    private void addAssignment() {
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Create a student first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String title = titleField.getText().trim();
            double maxPoints = parseDoubleField(maxPointsField, "Max Points");
            Assignment assignment = new Assignment(title, maxPoints);
            student.addAcademicWork(assignment);
            displayArea.append("Assignment added: " + title + "\n");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addProject() {
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Create a student first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String title = titleField.getText().trim();
            double weight = parseDoubleField(weightField, "Weight");
            Project project = new Project(title, weight);
            student.addAcademicWork(project);
            displayArea.append("Project added: " + title + "\n");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showProgress() {
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Create a student first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        displayArea.append("Overall Grade: " + student.calculateOverallGrade() + "%\n");
    }

    private void setAssignmentGrade() {
        if (student == null || student.getWorks().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Create a student and add work first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            double grade = parseDoubleField(assignmentGradeField, "Assignment Grade");
            AcademicWork lastWork = student.getWorks().get(student.getWorks().size() - 1);
            if (lastWork instanceof Assignment) {
                lastWork.setGrade(grade);
                displayArea.append("Grade set for Assignment: " + lastWork.getTitle() + " - " + grade + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Last work is not an Assignment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setProjectGrade() {
        if (student == null || student.getWorks().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Create a student and add work first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            double grade = parseDoubleField(projectGradeField, "Project Grade");
            AcademicWork lastWork = student.getWorks().get(student.getWorks().size() - 1);
            if (lastWork instanceof Project) {
                lastWork.setGrade(grade);
                displayArea.append("Grade set for Project: " + lastWork.getTitle() + " - " + grade + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Last work is not a Project.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double parseDoubleField(JTextField field, String fieldName) {
        String text = field.getText().trim();
        if (text.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        try {
            double value = Double.parseDouble(text);
            if (value < 0) throw new IllegalArgumentException(fieldName + " must be positive.");
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.setVisible(true);
        });
    }
}

class LoginWindow extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;

    public LoginWindow() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200); // Set size of the login window
        setLocationRelativeTo(null); // Center the window
        
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginButton.setFocusPainted(false);
        loginButton.setBackground(new Color(100, 149, 237)); // Cornflower blue
        loginButton.setForeground(Color.WHITE);

        loginButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            
            if (username.equals("admin") && password.equals("password")) {
                // Successful login, launch the main system
                dispose();  // Close the login window
                StudentProgressSystem studentProgressSystem = new StudentProgressSystem();
                studentProgressSystem.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(LoginWindow.this, "Invalid credentials", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
    }
}

class Student {
    private final String name;
    private final String id;
    private final List<AcademicWork> works;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.works = new ArrayList<>();
    }

    public void addAcademicWork(AcademicWork work) {
        works.add(work);
    }

    public List<AcademicWork> getWorks() {
        return works;
    }

    public double calculateOverallGrade() {
        double totalPoints = 0;
        double totalWeight = 0;
        for (AcademicWork work : works) {
            totalPoints += work.getGrade() * work.getWeight();
            totalWeight += work.getWeight();
        }
        return totalWeight > 0 ? totalPoints / totalWeight : 0;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

abstract class AcademicWork {
    private final String title;
    private final double weight;
    private double grade;

    public AcademicWork(String title, double weight) {
        this.title = title;
        this.weight = weight;
        this.grade = 0;
    }

    public String getTitle() {
        return title;
    }

    public double getWeight() {
        return weight;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

class Assignment extends AcademicWork {
    public Assignment(String title, double maxPoints) {
        super(title, maxPoints);
    }
}

class Project extends AcademicWork {
    public Project(String title, double weight) {
        super(title, weight);
    }
}