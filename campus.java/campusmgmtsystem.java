import java.util.*;

class Student {
    private String rollNo;
    private String name;
    private String department;

    public Student(String rollNo, String name, String department) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

class Faculty {
    private String facultyId;
    private String name;
    private String department;

    public Faculty(String facultyId, String name, String department) {
        this.facultyId = facultyId;
        this.name = name;
        this.department = department;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

class Course {
    private String courseId;
    private String courseName;
    private String facultyId;

    public Course(String courseId, String courseName, String facultyId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.facultyId = facultyId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getFacultyId() {
        return facultyId;
    }
}
    class CampusManagementSystem {
    private static Map<String, Student> students = new HashMap<>();
    private static Map<String, Faculty> faculties = new HashMap<>();
    private static Map<String, Course> courses = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Faculty");
            System.out.println("3. Add Course");
            System.out.println("4. Display Students");
            System.out.println("5. Display Faculties");
            System.out.println("6. Display Courses");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addFaculty();
                    break;
                case 3:
                    addCourse();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    displayFaculties();
                    break;
                case 6:
                    displayCourses();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter roll no: ");
        String rollNo = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        students.put(rollNo, new Student(rollNo, name, department));
        System.out.println("Student added successfully");
    }

    private static void addFaculty() {
        System.out.print("Enter faculty id: ");
        String facultyId = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        faculties.put(facultyId, new Faculty(facultyId, name, department));
        System.out.println("Faculty added successfully");
    }

    private static void addCourse() {
        System.out.print("Enter course id: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter faculty id: ");
        String facultyId = scanner.nextLine();
        if (faculties.containsKey(facultyId)) {
            courses.put(courseId, new Course(courseId, courseName, facultyId));
            System.out.println("Course added successfully");
        } else {
            System.out.println("Faculty not found");
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Student student : students.values()) {
                System.out.println("Roll No: " + student.getRollNo());
                System.out.println("Name: " + student.getName());
                System.out.println("Department: " + student.getDepartment());
                System.out.println();
            }
        }
    }

    private static void displayFaculties() {
        if (faculties.isEmpty()) {
            System.out.println("No faculties found");
        } else {
            for (Faculty faculty : faculties.values()) {
                System.out.println("Faculty Id: " + faculty.getFacultyId());
                System.out.println("Name: " + faculty.getName());
                System.out.println("Department: " + faculty.getDepartment());
                System.out.println();
            }
        }
    }

    private static void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found");
        } else {
            for (Course course : courses.values()) {
                System.out.println("Course Id: " + course.getCourseId());
                System.out.println("Course Name: " + course.getCourseName());
                System.out.println("Faculty Id: " + course.getFacultyId());
                System.out.println();
            }
        }
    }
}
