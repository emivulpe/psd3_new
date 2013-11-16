import java.util.HashMap;
import java.util.LinkedList;


public class StudentDb {
	
	private static StudentDb students=null;
	
	private HashMap<String,LinkedList<StudentCourse>> listOfStudents=new HashMap<String,LinkedList<StudentCourse>>();
	private HashMap<String,String> barcodes=new HashMap<String,String>();
	private StudentDb(){}
		
		public static StudentDb getStudentDb(){
			if(students==null)
				students=new StudentDb();
			return students;
			
		}
		
		public void addRecord(String s,String barcode,LinkedList<StudentCourse> courses){
			listOfStudents.put(s, courses);
			barcodes.put(barcode, s);
			
		}
		//when you get the record you can export it in a .csv file
		//or update it accordingly by adding/removing courses
		public LinkedList<StudentCourse> getStudentRecord(String student){
			return listOfStudents.get(student);
		
		}
		public String getIDFromBarcode(String barcode){
			return barcodes.get(barcode);
			
		}
		
		
		

}
