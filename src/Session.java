import java.util.*;

public abstract class Session {
	private boolean repeated;
	private boolean compulsory;
	private String	location;
	private String	course;
	private String	name;
	private Time begin;
	private Time end;
	private ArrayList<Integer> years;
	private LinkedList<String> listStudents;
	private int capacity;
	private int studentNum;
	private Attendance attendanceList;
	
	/*
	 * Constructor to initialise every class member with integer times
	 */	
	public Session(boolean r,boolean c,String l, String crs, int bh, int bm, int eh, int em, int[] y, int cap){
		repeated=r;
		compulsory=c;
		capacity=cap;
		studentNum=0;
		location=l;
		course=crs;
		listStudents=new LinkedList<String>();
		begin=new Time(bh,bm);
		begin=new Time(eh,em);
		years=new ArrayList<Integer>();
		for(int i=0;i<y.length;i++){
			years.add(y[i]);
		}
		attendanceList = new Attendance(this);
	}
	
	
	/*
	 * Constructor to initialise every class member with string times
	 */	
	public Session(boolean r,boolean c,String l, String crs, String b,String e, int[] y,int cap){
		repeated=r;
		compulsory=c;
		location=l;
		course=crs;
		studentNum=0;
		listStudents=new LinkedList<String>();
		capacity=cap;
		begin=new Time(b);
		begin=new Time(e);
		years=new ArrayList<Integer>();
		for(int i=0;i<y.length;i++){
			years.add(y[i]);
		}
		attendanceList = new Attendance(this);
	}
	
	public Session (LinkedList<String> l){
		listStudents=l;
		attendanceList=new Attendance(this);
	}
	
	public void addStudent(String studentID) throws CapacityException{
		listStudents.add(studentID);
		studentNum++;
	}
	
	public LinkedList<String> getListStudents() {
		return listStudents;
	}
	
	public void setListStudents(LinkedList<String> listStudents) {
		this.listStudents = listStudents;
		studentNum=listStudents.size();
	}

	public int getCapacity() {
		return capacity;
	}
	
	public boolean isRepeated() {
		return repeated;
	}

	public void setRepeated(boolean repeated) {
		this.repeated = repeated;
	}

	public boolean isCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.compulsory = compulsory;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getBegin() {
		return begin;
	}

	public void setBegin(Time begin) {
		this.begin = begin;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	public ArrayList<Integer> getStudentClasses() {
		return years;
	}

	public void setStudentClasses(ArrayList<Integer> studentClasses) {
		this.years = studentClasses;
	}
	
	public int getNumStudent(){
		return studentNum;
	}
	
	public Attendance getAttendanceList(){
		return attendanceList;
	}
	
	public void setAttendance(Attendance a){
		attendanceList=a;
	}


	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}


	public void book(Session s) {
		// TODO Auto-generated method stub
		
	}


	public void unbook() {
		// TODO Auto-generated method stub
		
	}
}
