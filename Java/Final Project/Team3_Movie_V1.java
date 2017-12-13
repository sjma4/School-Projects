import java.sql.Date;

public class Team3_Movie_V1 {
	private int id;
	private String name;
	private Date dtAdded;
	private int length;
	private boolean status;

	public Team3_Movie_V1(int id){
		setId(id);
	}
	
	public Team3_Movie_V1(){
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setLength(int length){
		this.length = length;
	}
	
	public int getLength(){
		return length;
	}
	
	public void setStatus(boolean status){
		this.status = status;
	}
	
	public boolean getStatus(){
		return status;
	}
	
	public void setDtAdded(Date dtAdded){
		this.dtAdded = dtAdded;
	}
	
	public Date getDtAdded(){
		return dtAdded;
	}
	
	
}