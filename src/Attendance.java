import java.util.ArrayList;
import java.util.HashMap;

public class Attendance{
	public enum Absence {ABSENT, PRESENT, ABSENTFORGOOD };
	
	private HashMap<String,Absence> attendance;
	private ArrayList<String> present;

	
	// Initially assumed to be absent
	public Attendance(Session s){
		present=new ArrayList<String>();
		attendance = new HashMap<String, Absence>();
		for(String student:s.getListStudents()){
			attendance.put(student,Absence.ABSENT);
		}
	}
	
	public HashMap<String,Absence> getAttendance(){
		return attendance;
	}
	
	public ArrayList<String> getPresent(){
		return present;
	}
	
	
	public void setPresent(String s){
		present.add(s);
		attendance.put(s,Absence.PRESENT);
	}
	
	
	public void setAbsentForGoodReason(String s){
		attendance.put(s, Absence.ABSENTFORGOOD);
	}
	
	public void setAbsent(String s){
		attendance.put(s, Absence.ABSENT);
	}
	
	public String getStudents(){
		String students="";
		for (String student:attendance.keySet()){
			students+=student+"\n";
			
		}
		return students;
			
	}

	public void changeAttendance(Student stud, String next) {
		// TODO Auto-generated method stub
		
	}
	
	
}