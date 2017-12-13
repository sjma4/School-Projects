
public class Team3_TicketChild_V1 extends Team3_Ticket_V1 {
	
	public Team3_TicketChild_V1(int numoftickets) {
		super(numoftickets);
	}

	@Override
	public double getPrice(){
		return super.getPrice()*.50;
	}
	
	@Override
	public String getTicketType(){
		return "Child";
	}
	
	@Override
	public double getTotal(){
		return getPrice() * super.getNumTickets();
	}
}
