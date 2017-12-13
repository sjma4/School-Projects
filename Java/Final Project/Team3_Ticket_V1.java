
public class Team3_Ticket_V1 implements Team3_ITicket_V1{
	private int numOfTickets;
	private final double price = 13.99;
	
	public Team3_Ticket_V1(int numoftickets){
		setNumTickets(numoftickets);
	}
	
	public double getPrice(){
		return price;
	}
	
	public String getTicketType(){
		return "General";
	}
	
	public void setNumTickets(int num){
		numOfTickets = num;
	}
	
	public int getNumTickets(){
		return numOfTickets;
	}
	
	public double getTotal(){
		return price * numOfTickets;
	}
}
