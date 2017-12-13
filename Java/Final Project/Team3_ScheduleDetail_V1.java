import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Team3_ScheduleDetail_V1 {
	private int id;
	private int scheduleId;
	private int day;
	private Time startTime;
	private Time endTime;
	
	public Team3_ScheduleDetail_V1(){
		
	}
	
	public void setScheduleId(int scheduleId){
		this.scheduleId = scheduleId;
	}
	
	public int getScheduleId(){
		return scheduleId;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	
	public int getDay(){
		return day;
	}
	
	public void setStartTime(Time startTime){
		this.startTime = startTime;
	}
	
	
	public String getStartTimeFormatted(){
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		return dateFormat.format(startTime).toString();
	}
	
	public Time getStartTime(){
		return startTime;
	}
	
	public void setEndTime(Time endTime){
		this.endTime = endTime;
	}
	
	
	public Time getEndTime(){
		return endTime;
	}
	

}
