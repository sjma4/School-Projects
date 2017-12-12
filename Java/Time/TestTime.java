/* Author: Sau Ma
 * Student ID: 001205963
 * Assignment 4: TimeType 
 * Description: Class file to run TimeType.java
 *
 * Date: 10/25/17
 */

import java.util.*;
import java.text.*;

public class TestTime
{
  public static void main(String [] args)
  {
    /*
    //Loop counter
    int counter = 0;
    
    //Create object 1 using default constructor
    TimeType time1 = new TimeType();
    
    //Create object 2 using 2nd constructor
    TimeType time2 = new TimeType(23,59,58);
    
    //Create object 3 using 3rd constructor
    TimeType time3 = new TimeType(time2);
    
    //Print each time from each obj.
    System.out.println("Time1 = " + time1.toString());
    System.out.println("Time2 = " + time2.toString());
    System.out.println("Time3 = " + time3.toString());
    /*
    //Attempt to set time to 25hr 0 min 0 sec
    System.out.println("Attempting to set time for time1...");    
    if(!time1.Set(25,0,0))
      System.out.println("Invalid Time");
    
    //Loop to increase time in time2
    System.out.println("Increasing time2 by 10 seconds...");
    while(counter < 10)
    {
     time2.Increase();
     System.out.println(time2.toString());
     counter++;
    }
    
    //Reset counter to 0
    counter = 0;
    
    //Loop to decrease time in time2
    System.out.println(time1.toString());
    System.out.println("Decreasing time2 by 10 seconds...");
    while(counter < 10)
    {
     time1.Decrease();
     System.out.println(time1.toString());      
     counter++;
    }
    */
    /*  Testing TimeAndDate Class  */
    System.out.println("Testing TimeAndDate...");
    int looper = 0;
    TimeAndDate ob = new TimeAndDate();
 
    
    
    //System.out.println(ob.showDateAndTime());
    //ob.decreaseSecond();
    //System.out.println(ob.showDateAndTime());
    //Works when println(ob.showDateAndTime()); is first and then ob.decreaseSecond()
    System.out.println("Testing decreaseSecond from TimeAndDate");
    while(looper < 10)
    {
    //System.out.println(ob.showDateAndTime());
    ob.decreaseSecond();
    System.out.println(ob.showDateAndTime());
    looper++;
    }
    
    looper = 0;
    
    System.out.println("Testing increaseSecond from TimeAndDate");
    while(looper < 10)
    {
    //Increasing Day
    //System.out.println(ob.showDateAndTime());
    ob.increaseSecond();
    System.out.println(ob.showDateAndTime());
    looper++;
    }
    /*
    //Valid Date
    if(ob.setTimeAndDate(10,31,30,10,30,1454))
      System.out.println("True");
    //Invalid date
    if(!ob.setTimeAndDate(25,1,2000,12,30,54))
      System.out.println("False");
      */
  }//End of main
}//End of class