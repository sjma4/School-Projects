import java.util.ArrayList;

public class Team3_MovieRoom_V1 {
	
	private int id;
	private Team3_Movie_V1 movie;
	private int capacity;
	private int prepMin;
	private String roomLabel;
	private ArrayList<Team3_ScheduleDetail_V1>  scheduleDetail;
	
	public Team3_MovieRoom_V1(){
		
	}
	
	public Team3_MovieRoom_V1(ArrayList<Team3_ScheduleDetail_V1> schedule){
		scheduleDetail=schedule;
	}
	
	public void setMovie(Team3_Movie_V1 movie){
		this.movie = movie;
	}
	
	public Team3_Movie_V1 getMovie(){
		return movie;
	}
	
	public void addSchedule(Team3_ScheduleDetail_V1 schedule){
		this.scheduleDetail.add(schedule);
	}
	
	public Team3_ScheduleDetail_V1 getScheduleByIndex(int index){
		return scheduleDetail.get(index);
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public int getPrepMin(){
		return prepMin;
	}
	
	public void setPrepMin(int prepMin){
		this.prepMin = prepMin;
	}
	
	public void setRoomLabel(String label){
		roomLabel = label;
	}
	
	public String getRoomLabel(){
		return roomLabel;
	}
	
	public int getNumOfSchedules(){
		return scheduleDetail.size();
	}

}
