# EduTrack: Student Progress System
Object-Oriented Programming Final Project
![work! (1)](https://github.com/user-attachments/assets/f8167a1f-5fd3-4724-b2e9-d6381bf122f7)
# I. Project Overview
The EduTrack: Student Progress System is a Java-based application designed to help students track their academic progress. It provides functionalities to create student profiles, add assignments and projects, set grades, and calculate overall performance. The system features a user-friendly graphical interface built using Java Swing, allowing for easy interaction with the program. The application emphasizes a modern aesthetic and provides feedback through a display area, enhancing the user experience.

# II. Explanation of how OOP principles were applied
# 1. Encapsulation
Encapsulation is the bundling of data (attributes) and methods (functions) that operate on the data into a single unit, typically a class. It restricts direct access to some of the object's components, which is a means of preventing unintended interference and misuse.

Implementation:
The Student, AcademicWork, Assignment, and Project classes encapsulate their attributes (like name, studentId, title, weight, and grade) and provide public methods (getters and setters) to access and modify these attributes. For example, the Student class has methods like addAcademicWork() and calculateOverallGrade() that operate on its internal data without exposing the data directly.

# 2. Inheritance
Inheritance allows a class to inherit properties and methods from another class, promoting code reusability and establishing a hierarchical relationship between classes.

Implementation:
The Assignment and Project classes inherit from the AcademicWork abstract class. This means they can use the methods and attributes defined in AcademicWork, such as getTitle(), getWeight(), and setGrade(), while also allowing for specific implementations or additional features unique to assignments and projects.

# 3. Polymorphism
Polymorphism enables objects to be treated as instances of their parent class, allowing for methods to be defined in a way that they can operate on objects of different classes.

Implementation:
The calculateGrade() method in the AcademicWork class is abstract, meaning that subclasses (Assignment and Project) must provide their own implementation of this method. This allows the Student class to call calculateGrade() on any AcademicWork object without needing to know the specific type of work, thus achieving polymorphism.

# 4. Abstraction
Abstraction is the concept of hiding the complex implementation details and showing only the essential features of the object. It helps in reducing programming complexity and increasing efficiency.

Implementation:
The AcademicWork class is an abstract class that defines the essential characteristics of academic work without providing a complete implementation. The details of how grades are calculated or how specific types of academic work behave are left to the subclasses (Assignment and Project). This allows users of the AcademicWork class to interact with it without needing to understand the underlying complexities.

# III. Details of the chosen SDG and its integration into the project
The project aligns with the Sustainable Development Goal (SDG) 4: Quality Education. It promotes inclusive and equitable quality education and enhances lifelong learning opportunities for all. The application facilitates better academic tracking and support for students, helping educators provide personalized assistance. By allowing students to monitor their progress and understand their academic performance, the system contributes to improved educational outcomes and encourages self-directed learning.

# IV. Instructions for running the program
Java Development Kit (JDK): Ensure that you have the JDK installed on your machine. You can download it from the Oracle website or use an open-source version like OpenJDK.
Integrated Development Environment (IDE): While you can run the program from the command line, using an IDE like IntelliJ IDEA, Eclipse, or NetBeans can simplify the process. Make sure you have one of these installed.

# Steps to Run the Program
Ensure you have Java Development Kit (JDK) installed on your computer.

Compile the Java files:
- Compile all Java files in the project directory
- Key files: StudentProgressSystem.java, LoginWindow.java, StudentProgressModel.java, etc.
Run the program:

The main entry point is the LoginWindow
Default login credentials:
- Username: admin
- Password: password

After logging in, you'll see the Student Progress System interface with several sections:
- Student Information (create a student)
- Academic Work (add assignments/projects)
- Grades (set grades for assignments/projects)
- Progress display area

Basic workflow:
- First, create a student by entering name and ID
- Add assignments or projects
- Set grades for the academic works
- Use "Show Progress" to calculate overall grade

Error handling:
- The system provides error messages if you skip steps or enter invalid data
- Ensure all fields are filled correctly before proceeding
