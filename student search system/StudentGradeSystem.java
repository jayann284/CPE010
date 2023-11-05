import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int studentId;
    private String studentName;
    private String studentProgram;

    public Student(int studentId, String studentName, String studentProgram) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentProgram = studentProgram;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentProgram() {
        return studentProgram;
    }
}

class Grade {
    private int gradeId;
    private int studentId;
    private int studentGrade;

    public Grade(int gradeId, int studentId, int studentGrade) {
        this.gradeId = gradeId;
        this.studentId = studentId;
        this.studentGrade = studentGrade;
    }

    public int getGradeId() {
        return gradeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getStudentGrade() {
        return studentGrade;
    }
}

public class StudentGradeSystem {
    private List<Student> students = new ArrayList<>();
    private List<Grade> grades = new ArrayList();

    public void addStudent(int studentId, String studentName, String studentProgram) {
        students.add(new Student(studentId, studentName, studentProgram));
    }

    public void addGrade(int gradeId, int studentId, int studentGrade) {
        grades.add(new Grade(gradeId, studentId, studentGrade));
    }

    public Student searchStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public Student searchStudentByName(String studentName) {
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                return student;
            }
        }
        return null;
    }

    public void viewGrade(int studentId) {
        for (Grade grade : grades) {
            if (grade.getStudentId() == studentId) {
                Student student = searchStudent(studentId);
                System.out.println("Student Name: " + student.getStudentName());
                System.out.println("Student Program: " + student.getStudentProgram());
                System.out.println("Grade: " + grade.getStudentGrade());
            }
        }
    }

    public static void main(String[] args) {
        StudentGradeSystem system = new StudentGradeSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                int studentId = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                System.out.print("Enter Student Name: ");
                String studentName = scanner.nextLine();
                System.out.print("Enter Student Program: ");
                String studentProgram = scanner.nextLine();
                system.addStudent(studentId, studentName, studentProgram);
                System.out.println("Student added successfully!");
            } else if (choice == 2) {
                System.out.print("Enter Student ID to search: ");
                int searchId = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                Student student = system.searchStudent(searchId);
                if (student != null) {
                    System.out.println("Student found:");
                    System.out.println("Student ID: " + student.getStudentId());
                    System.out.println("Student Name: " + student.getStudentName());
                    System.out.println("Student Program: " + student.getStudentProgram());
                    system.viewGrade(student.getStudentId());
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter Student Name to search: ");
                String searchName = scanner.nextLine();
                Student student = system.searchStudentByName(searchName);
                if (student != null) {
                    System.out.println("Student found:");
                    System.out.println("Student ID: " + student.getStudentId());
                    System.out.println("Student Name: " + student.getStudentName());
                    System.out.println("Student Program: " + student.getStudentProgram());
                    system.viewGrade(student.getStudentId());
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 4) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
