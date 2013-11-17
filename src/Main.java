import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	
	
	private static StudentDb students=StudentDb.getStudentDb();
	private static CourseDb courses=CourseDb.getStudentDb();

	
	
	private static void tutorOptions(){
		System.out.println("Please select options: ");
		System.out.println("- Attendance: ");
		System.out.println("    (a) Manual");
		System.out.println("    (b) CSV import");
		System.out.println("Enter q to exit");
		System.out.print("Enter : ");
		
	}
		private static void moretutorOptions(){
		System.out.println("Please select what you want to do next: ");
		System.out.println("- Attendance: ");
		System.out.println("    (a) Manual");
		System.out.println("    (b) CSV import");
		System.out.println("Enter q to exit");
		System.out.print("Enter : ");
		
	}
	
	
	public static void tutorlogin(){
	
	MenuHeader();
	tutorOptions();
	Scanner scanner = new Scanner(System.in);
	String option=scanner.next();
	while(!option.equalsIgnoreCase("q")){
	while(!option.equalsIgnoreCase("a") && !option.equalsIgnoreCase("b") && !option.equalsIgnoreCase("q")){
		System.out.println("!!! Invalid option !!! Please try again.");
		tutorOptions();
		scanner = new Scanner(System.in);
		option=scanner.next();
	}
	LinkedList<String>studentsList=new LinkedList<String>();
	//students with ids 1-10
	for(int i=1;i<11;i++){
		studentsList.addLast(i+"");
	}
	Session s=new LabSession(studentsList);
	Attendance a=s.getAttendanceList();
	if(option.equalsIgnoreCase("a")){
		
	 CustomHeader(" Students in session.");
	System.out.println(a.getStudents());
	System.out.println("Enter 0 to indicate end of adding attendance.");
	 scanner = new Scanner(System.in);
	 CustomHeader(" Type in ID's of students that are present");
	int opt=scanner.nextInt();
	
	while(opt!=0){
		while(opt<0 && opt>10){
			System.out.println("!!! Wrong option !!! Please try again.");
			System.out.println();
			opt=scanner.nextInt();
		}
		a.setPresent(opt+"");
		opt=scanner.nextInt();
	}
	}

	
	else if(option.equalsIgnoreCase("b")){
		System.out.println("Specify which file to import.");
		String file=scanner.next();
		File f=new File(file);
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(f);
			while(fileScanner.hasNextLine()){
				String barcode=fileScanner.nextInt()+"";
				String studentID=students.getIDFromBarcode(barcode);
				a.setPresent(studentID);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not present.");
			System.exit(0);
		}

			
		//create a file scanner
		//for each line of the file
		//a.setresent(filescan.nextln()
		
	}
	for(String student:a.getPresent())
		System.out.printf("Student with id %s is present.\n",student);
	
	System.out.println("");
	
	moretutorOptions();
	option=scanner.next();
	}
	System.out.println("Thank you and goodbye!");
	}



private static void adminOptions(){
	System.out.println(" 1. Export attendance records for a course ");
	System.out.println(" 2. Export student information ");
	System.out.print("Enter (1 or 2):  ");
	System.out.println("Please enter 3 to log out.");
	
}





	public static void adminlogin() {
		MenuHeader();
		adminOptions();
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		System.out.println();
		while (option != 3) {
			while (option != 1 && option != 2 && option != 3) {
				System.out.println("!!! Wrong option !!! Please try again.");
				MenuHeader();
				adminOptions();
				scanner = new Scanner(System.in);
				option = scanner.nextInt();
				System.out.println();
			}
			System.out.println("Please specify the filename to which to export. Make sure it ends with .csv");
			String file=scanner.next();
			Exporter x = null;
			if (option == 1) {

				try {
					x = new Exporter(file,
							"Course,ID number, Coursework, Exam, Total", false);
				} catch (IOException e) {
					System.out.println("Error writing to the specified file");
					System.exit(0);
				}
			
				System.out
						.println("Please enter the name of the course you want to export information about.");
				System.out
						.println("You can select one of the following: PSD3 or JP2.");
				String courseName = scanner.next();
				System.out.println(courseName);
				while (!courseName.equalsIgnoreCase("PSD3")
						&& !courseName.equalsIgnoreCase("JP2")) {
					System.out.println("Please enter either PSD3 or JP2");
					courseName = scanner.next();
				}
				System.out.println("Exporting information about " + courseName);
				LinkedList<CourseStudent> info = courses
						.getCourseRecord(courseName);
				for (CourseStudent cs : info) {
					x.export(cs.toString());
				}

			} else {
				try {
					x = new Exporter(
							file,
							"First Name,Surname, ID number, Assignment: Lab1, Assignment: Lab2",
							false);
				} catch (IOException e) {
					System.out.println("Error writing to the specified file");
					System.exit(0);
				}
				System.out
						.println("Please enter the id of the student you want to export information about.");
				System.out
						.println("You can select one of the following: 1 or 2.");
				String studentID = scanner.next();
				while (!studentID.equalsIgnoreCase("1")
						&& !studentID.equalsIgnoreCase("2")) {
					System.out.println("Please enter either 1 or 2");
					studentID = scanner.next();
				}
				System.out
						.println("Exporting information about student with id "
								+ studentID);
				LinkedList<StudentCourse> info = students
						.getStudentRecord(studentID);
				for (StudentCourse sc : info) {
					x.export(sc.toString());
				}

			}
			System.out.println("File exported.");
			System.out
					.println("Please choose what to do next or enter 3 to log out.");
			option = scanner.nextInt();

		}
		System.out.println("Goodbye and thanks!");

	}



	
public static void header(){
	System.out.println("::::::::::::::::::::::::::::::");
for(int i=0;i<3;i++){
	System.out.println("::                          ::");
}
	System.out.println("::::    Group Exercise    ::::");
	for(int i=0;i<3;i++){
		System.out.println("::                          ::");
	}
	System.out.println("::::::::::::::::::::::::::::::");

}




public static void loginHeader(){
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	System.out.println(">           Log In           >");
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	System.out.println("");
}



public static void MenuHeader(){
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	System.out.println("<            Menu            <");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
}



public static void CustomHeader(String msg){
	System.out.println("------------------------------");
	System.out.println("-  "+msg);
	System.out.println("------------------------------");
	System.out.println("");
}
	



public static void main(String args[]) throws IOException {
		header();
		loginHeader();
		mockCourseDb();
		mockStudentDb();
		
		System.out.println("Welcome. Please enter your log in details below.");
		System.out.println("");
		System.out.print("Username: ");
		Scanner scanner = new Scanner(System.in);
		String username=scanner.next();
		System.out.println("");
		System.out.print("Password: ");
		String password=scanner.next();
		System.out.println("");
		System.out.println(">>> Entered:"+username+" "+ password+" <<<");

//		Lecturer user= new Lecturer(username, "Harry", "Potter");
		while (username.compareTo(password)!=0){
				System.out.println("invalid login");
				System.out.print("Username: ");
				scanner = new Scanner(System.in);
				username=scanner.next();
				System.out.println("");
				System.out.print("Password: ");
				password=scanner.next();
				System.out.println("");
		}
		System.out.println("                                 (authentication successful)");
		if(username.compareTo("tutor")==0){tutorlogin();}
		else if (username.compareTo("lecturer")==0){System.out.println("Coming soon");}
		else if(username.compareTo("admin")==0){adminlogin();}
		else if(username.compareTo("student")==0){ System.out.println("Coming soon");}
		else {System.out.println("invalid login"); System.exit(0);}
	
	

		
	}



	private static void mockCourseDb(){

		Course course=new Course("PSD3");
		CourseStudent cs1=new CourseStudent("Terry","T","1234545",12,13);
		CourseStudent cs2=new CourseStudent("Merry","M","1234545",12,13);
		course.addStudent(cs1);
		course.addStudent(cs2);
		courses.addRecord(course.name, course.getStudents());
		course=new Course("JP2");
		cs1=new CourseStudent("Jerry","L","123",15,17);
		cs2=new CourseStudent("Kerry","N","123",16,10);
		course.addStudent(cs1);
		course.addStudent(cs2);
		courses.addRecord(course.name, course.getStudents());
		
	}
	
	
	
	
	private static void mockStudentDb(){
		Student s=new Student("456","1", "john", "smith");
		StudentCourse sc1=new StudentCourse("PSD3", "1", 19, 70, 89);
		StudentCourse sc2=new StudentCourse("ADS3", "2", 19, 70, 89);
		StudentCourse sc3=new StudentCourse("PS3", "3", 19, 70, 89);
//		Course c1=new Course("PSD3", "1");
//		Course c2=new Course("ADS3", "2");
//		Course c3=new Course("PS3", "3");
		s.getCourseMarks().add(sc1);
		s.getCourseMarks().add(sc2);
		s.getCourseMarks().add(sc3);
//		s.addCourseRecord(c1);
//		s.addCourseRecord(c2);
//		s.addCourseRecord(c3);
		students.addRecord("1",s.getBarcode(), s.getCourseMarks());
		
		s=new Student("123","2", "jane", "sean");
		sc1=new StudentCourse("Alg3", "3", 20, 60, 98);
		sc2=new StudentCourse("PL3", "4", 13, 40, 65);
		sc3=new StudentCourse("JP2", "5", 15, 56, 35);
//		c1=new Course("PSD3", "1");
//		c2=new Course("ADS3", "2");
//		c3=new Course("PS3", "3");
		s.getCourseMarks().add(sc1);
		s.getCourseMarks().add(sc2);
		s.getCourseMarks().add(sc3);
//		s.addCourseRecord(c1);
//		s.addCourseRecord(c2);
//		s.addCourseRecord(c3);
		students.addRecord("2",s.getBarcode(), s.getCourseMarks());
		
	}
}

