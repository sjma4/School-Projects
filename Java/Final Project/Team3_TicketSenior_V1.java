
public class Team3_TicketSenior_V1 extends Team3_Ticket_V1{
	
	public Team3_TicketSenior_V1(int numoftickets) {
		super(numoftickets);
	}

	@Override
	public double getPrice(){
		return super.getPrice()*.75;
	}
	
	@Override
	public String getTicketType(){
		return "Senior";
	}
	
	@Override
	public double getTotal(){
		return getPrice() * super.getNumTickets();
	}
}
