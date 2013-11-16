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
	public void checkBook(Session s){
		boolean c=false;
		if (slots.isEmpty()){slots.add(s);
		System.out.println("( Session successfully booked)");}
		else{
			for(int j=0;j<slots.size();j++){
				if(slots.get(j).getEnd().getHour()<=s.getBegin().getHour() ||slots.get(j).getBegin().getHour()>=s.getEnd().getHour()){
					c=true;
				}
				else if(slots.get(j).getBegin().getHour()<s.getBegin().getHour() && slots.get(j).getEnd().getHour()>=s.getEnd().getHour()){
					c=false;
				}
				else if(slots.get(j).getBegin().getHour()<s.getBegin().getHour() && slots.get(j).getEnd().getHour()>s.getBegin().getHour() && slots.get(j).getEnd().getHour()<=s.getEnd().getHour()){
					c=false;
				}
				else if(slots.get(j).getBegin().getHour()==s.getBegin().getHour() || slots.get(j).getEnd().getHour()==s.getEnd().getHour())
					c=false;
				else{c=false;}
			}
			if(c){slots.add(s);
			System.out.println("( Session successfully booked)");}
			else{
			System.out.println("(Unable to book session.)");}
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
		for(int i=0;i<slots.size();i++){
			if (slots.get(i).getBegin().getHour()==s.getBegin().getHour() && slots.get(i).getEnd().getHour()==s.getEnd().getHour()){
				slots.remove(i);
				System.out.println("Session freed.");
			}
		}
		System.out.println("Session is already free.");
	}
}