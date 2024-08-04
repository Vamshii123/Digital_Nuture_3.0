// File: MVCPatternExample.java

public class MVCPatternExample {

    public static void main(String[] args) {
        // Create the model
        Student student = new Student("John Doe", 1, "A");

        // Create the view
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }

    // Model Class
    static class Student {
        private String name;
        private int id;
        private String grade;

        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getGrade() {
            return grade;
        }

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // View Class
    static class StudentView {
        public void displayStudentDetails(Student student) {
            System.out.println("Student Details:");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Grade: " + student.getGrade());
        }
    }

    // Controller Class
    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(model);
        }
    }
}