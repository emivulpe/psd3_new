import java.util.ArrayList;
import java.util.LinkedList;


public class LabSession extends Session {

	private int	tutorNum;
	private ArrayList<Tutor> tutors;
	private LinkedList<String> attendance;

	public LabSession(boolean r, boolean c, int t, String l, String crs,
			int bh, int bm, int eh, int em, int[] y,int cap) {
		super(r, c,l, crs, bh, bm, eh, em, y,cap);
		tutorNum=t;
		tutors=new ArrayList<Tutor>();
		attendance=new LinkedList<String>();
	}
	public LabSession(boolean r, boolean c,String l, String crs,
			int bh, int bm, int eh, int em, int[] y,int cap) {
		super(r, c,l, crs, bh, bm, eh, em, y,cap);
		tutorNum=0;
		tutors=new ArrayList<Tutor>();
	}
	public LabSession(boolean r, boolean c, int t, String l, String crs,
			String b, String e, int[] y,int cap) {
		super(r, c,l, crs, b,e, y,cap);
		tutorNum=t;
		tutors=new ArrayList<Tutor>();
	}
	public LabSession(boolean r, boolean c,String l, String crs,
			String b, String e, int[] y,int cap) {
		super(r, c,l, crs, b,e, y,cap);
		tutorNum=0;
		tutors=new ArrayList<Tutor>();
	}

	public ArrayList<Tutor> getTutors() {
		return tutors;
	}
	public void setTutorsNeeded(int n){
		tutorNum=n;
	}
	
	public void moreTutors(int n){
		tutorNum+=n;
	}
	public void addTutor(Tutor t) {
		if(tutors.size()<=tutorNum)
			System.out.println("Can't add anymore tutors to session");
		else{
		tutors.add(t);}
	}
	
	public void setStudentAttended(String student){
		attendance.add(student);
	}
	


}
