/* Author: Sau Ma
 * Student ID: 001205963
 * Assignment 4: TimeType 
 * Description: Using Constructor Overloading, and utilizing methods that deal with displaying time in
 * HH:MM:SS AM/PM format
 *
 * Date: 10/25/17
 */
import java.util.*;
import java.text.*;
public class TimeType
{
  protected int hours;
  protected int minutes;
  protected int seconds;
  
  /*--------------------Constructor Overloading------------*/
  //1st Constructor using obj time1
  //Sets all private data to 0
  public TimeType()
  {
    hours = 0;
    minutes = 0;
    seconds = 0;
  }
  //2nd Constructor using obj time2
  //Sets data to specified amount
  public TimeType(int hours, int minutes, int seconds)
  {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }
  //3rd Constructors
  public TimeType(TimeType time)
  {
    hours = time.hours;
    minutes = time.minutes;
    seconds = time.seconds;
  }
  
  /*-----Get Methods-----------*/
  public int getHour()
  {
    return hours;
  }
  
  public int getMinutes()
  {
    return minutes;
  }
  
  public int getSeconds()
  {
    return seconds;
  }
  /*------------------Methods----------------*/
  
  //Return time stored in object in HH:MM:SS AM/PM format
  public String toString()
  {
    String timeString = "";
    //Test for midnight (time1 obj)
    if(hours == 0)
      hours = 12;
    
    //Test for time2 & time 3
    if(hours > 12)
      hours = hours - 12;
    //See if hours is <10
    if(hours < 10)
      timeString += "0" + Integer.toString(hours) + ":";
    else
      timeString += Integer.toString(hours)+ ":";
    
    //See if minutes is <10
    if(minutes < 10)
      timeString += "0" + Integer.toString(minutes) + ":";
    else
      timeString += Integer.toString(minutes)+ ":";
    
    //See if seconds is < 10
    if(seconds < 10)
      timeString += "0" + Integer.toString(seconds) + " ";
    else
      timeString += Integer.toString(seconds)+ " ";
    
  
    //Decides if PM or AM
    if(hours > 12 && hours != 24 || hours < 12)
      timeString += "PM";
    else
      timeString += "AM";
    
    return timeString;
  }//End of toString()
  
  //Set time
  boolean Set(int h, int m, int s)
  {
    //Check if hour/min/sec are valid numbers
    //Hour = 0-24, Min = 0-59, Sec = 0 - 59
    if(h > 24 || h < 0 || m > 59 || m < 0 || s > 59 || s < 0)
    {
      return false;
    }
    //Time set is valid so set private data to these times
    else
    {
      hours = h;
      minutes = m;
      seconds = s;
      return true;
    }
  }//End of Set
  
  //Increase time by one second
  public void Increase()
  {
    //Add one second to the time
    this.seconds += 1;
    
    if(this.hours == 0 && this.minutes == 0 && this.seconds ==0)
      seconds += 1;
    
    //Check if second goes over 59
    if(this.seconds > 59)
    {
      //Set Second to 0 then increment minutes
      this.seconds = 0;
      this.minutes += 1;
    }
    //Check if minutes goes over 59
    if(this.minutes > 59)
    {
        //Set minutes to 0 then increment the hour
        this.minutes = 0;
        this.hours += 1;
    }
    //Check if hours goes over 24
    if(this.hours >= 24)
    {
     //Set hours to 0
     this.hours = 12;
    }        
  }//End of increase()
  
  //Method to decrease seconds by 1
  public void Decrease()
  {
    //Subtract 1 second
    this.seconds -= 1;
    if(hours == 12 || hours == 0 || hours == 24)
      hours = 12;
    //Check if second goes under 0
    if(this.seconds < 0)
    {
      //Set Second to 0 then decrement minutes
      this.seconds = 59;
      this.minutes -= 1;
      //Check if minutes goes under 0
      if(this.minutes < 0)
      {
        //Set minutes to 0 then increment the hour
        this.minutes = 59;
        this.hours -= 1;
        //Check if hours goes under 0
        if(this.hours < 0)
        {
          //Set hours to 0
          this.hours = 12;
        }        
      }
    }
  }//End of decrease()
}//End of Class