/**  
* Team3_ITicket_V1.java - This interface is to implemented by all tickets classes to ensure the same functionality  
* @author  Alexander Saint-Hilaire
* @version 1.0 
*/ 
public interface Team3_ITicket_V1 {
	/**
	 * @return the price of the ticket
	 */
	public double getPrice();
	/**
	 * @return the type of ticket
	 */
	public String getTicketType();
	/**
	 * @return number of tickets
	 */
	public int getNumTickets();
	/**
	 * @return total price numtickets * price
	 */
	public double getTotal();

}
