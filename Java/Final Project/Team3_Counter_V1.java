/**  
* Team3_Counter_V1.java - This class is used to keep track of a counter  
* @author  Alexander Saint-Hilaire
* @version 1.0 
*/ 
public class Team3_Counter_V1 {
	
	public int counter;//variable to hold the data for the counter it should be greater than 0
	
	public Team3_Counter_V1(){
	}
	
	//sets the value of class variable counter
	private void setCounter(int newCounter){
		if(newCounter >= 0){
			counter = newCounter;
		}
		else throw new IllegalArgumentException("counter must be >= 0");
		
	}
	
	/**  
	* @return the current value of the counter
	*/ 
	//returns the value stored in class variable counter
	public int getCounter(){
		return counter;
	}
	
	/**  
	* reduces the value of the counter by 1
	*/ 
	//reduces one from the counter
	public void decrement(){
		if (counter> 0)
		{
			setCounter(--counter);
		}
	}
	
	/**  
	* increases the value of the counter by 1
	*/ 
	//increment adds one to the counter
	public void increment(){
			setCounter(++counter);
	}
	
	/**  
	* resets the counter back to 0
	*/ 
	//resets the counter to 0
	public void reset(){
		setCounter(0);
	}

}
