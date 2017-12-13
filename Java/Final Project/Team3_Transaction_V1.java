import java.sql.Time;
import java.util.ArrayList;
import java.util.UUID;
/**  
* Team3_Transaction_V1.java - This class is used to keep track of the transaction  
* @author  Alexander Saint-Hilaire
* @version 1.0 
*/ 
public class Team3_Transaction_V1 {
	private Team3_MovieRoom_V1 movieRoom;
	private Time movieTime;
	private ArrayList<Team3_ITicket_V1>  ticket = new ArrayList<Team3_ITicket_V1>();
	private UUID uuid = UUID.randomUUID();
	private String paymentType;
	
	public Team3_Transaction_V1(Team3_MovieRoom_V1 movieRoom, Time time){
		setMovieTime(time);
		setMovieRoom(movieRoom);
	}
	
	public Double getTotal(){
		Double total = 0.00;
		if(ticket == null) return total;
		else {
			for(int i = 0; i<ticket.size(); i++){
				total += ticket.get(i).getPrice()*ticket.get(i).getNumTickets();
			}
			return total;
		}
	}
	
	public void setMovieRoom(Team3_MovieRoom_V1 movieRoom){
		this.movieRoom = movieRoom;
	}
	
	public void setMovieTime(Time time){
		this.movieTime = time;
	}
	
	public Team3_MovieRoom_V1 getMovieRoom(){
		return movieRoom;
	}
	
	public Time getMovieTime(){
		return movieTime;
	}
	
	public void addTicket(Team3_ITicket_V1 ticket){
		this.ticket.add(ticket);
	}
	
	public Team3_ITicket_V1 getTicketByIndex(int index){
		return ticket.get(index);
	}
	
	public int getNumOfTickets(){
		return ticket.size();
	}
	
	public UUID getGuid(){
		return uuid;
	}
	
	public void setPaymentType(String paymentType){
		if(paymentType.toUpperCase().equals("CREDIT CARD")){
			this.paymentType = paymentType;
		}
		else if (paymentType.toUpperCase().equals("CASH")){
			this.paymentType = paymentType;
		}
		else{
			throw new IllegalArgumentException("payment type can only be cash and credit card.");
		}
	}
	
	public String getPaymentType(){
		return paymentType;
	}
	
	@Override
	public String toString(){
		return(String.format("<html>Confirmation:%s<br>Payment Type:%s<br>Total:%.2f</html>", getGuid().toString(),getPaymentType(),getTotal()));
	}

}
