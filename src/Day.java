import java.util.ArrayList;


public class Day {
	// Don't need "timeslots" just sessions in a day
	private ArrayList<Session> slots;

	public Day(){	
		slots=new ArrayList<Session>();
		//this should be done in TimeSlot class (remember cohesion? )
		// changed to sessions instead of timeslots
		// shouldn't need to add sessions/timeslots. only add them if they exist
/*		for(int i=0;i<9;i++){
			slots.add(new Session(new Time(i+9,00),new Time(i+10,00)));
		}*/
	}

	
	
	//this method needs to return a boolean istead of printing "Session booked/not booked"
	//if it stays this way we must comare strings to check, otherwise compare
	//booleans which is much better
	
	// this will need to be changed for session instead of timeslot
	public void checkBook(Time b,Time e,Session s){
		int diff=b.getHour()-e.getHour();
		boolean c=false;
		if (diff>1){
			for(int i=0;i<=diff;i++){
				if(slots.get(b.getHour()-9+i).isAvailable()){
					c=true;
				}
			}
			if (c){
				for(int i=0;i<=diff;i++){
					slots.get(b.getHour()-9+i).book(s);
					}
				System.out.println("Session booked");
				}
			else{
				System.out.println("Unable to book session.");}
			}
		else{
			if(slots.get(b.getHour()-9).isAvailable()){
				slots.get(b.getHour()-9).book(s);
				c=true;
				System.out.println("Session booked");
			}
			else{
				System.out.println("Unable to book session.");}
			
		}
	}

	public ArrayList<Session> getSlots() {
		return slots;
	}

	public void setSlots(ArrayList<Session> slots) {
		this.slots = slots;
	}

	public void addSession(Session s){
		slots.add(s);
	}
	
	//return boolean as well
	public void unbook(Session s){
		if(!slots.get(s.getBegin().getHour()-9).isAvailable()){
			slots.get(s.getBegin().getHour()-9).unbook();
			System.out.println("Session freed.");}
		else
			System.out.println("Session is already free.");
	}
}