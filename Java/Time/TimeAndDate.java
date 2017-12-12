/* Author: Sau Ma
 * Student ID: 1205963
 * Assignment 6: Inheritance
 * Description: Using Assignment 4(TimeType.java) we create a subclass, TimeAndDate.java, that covers months,days and years
 * Methods to increase/decrease the day, set the date, and print out the date and time in MM/DD/YYYY HH:MM:SS AM/PM format
 * 
 * Assignment 6: Adds two methods, void increaseSecond() & void decreaseSecond()
 * 
 */ 

public class TimeAndDate extends TimeType
{
  private int month;
  private int day;
  private int year;
  //Array to hold day values for each month
  //0=Placeholder, Jan 31, Feb 28, March 31, April 30, May 31, June 30, July 31, Aug 31, Sept 30, Oct  31, Nov 30, Dec 31
  private int[] days_in_month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
  private int array_Indexer = 0;
  
  //Constructor
  public TimeAndDate()
  {
    //Call TimeType class to initiate time to 00:00:00
    super(0,0,0);
    month = 1;
    day = 1;
    year = 1980;
    
  }//constructor
  
  //This method checks if the year is a leapyear
  private boolean leapyear(int y)
  {
    //Check if y is a leap year
    if(y%4 == 0 && y%100 != 0)
      return true;
    else
      return false;
  }//end of leapyear method
  
  public boolean setTimeAndDate(int hrs, int mins, int secs, int mon, int dy, int yr)
  {
    //Check if these values are valid
    if((hrs >= 0 && hrs < 24) && mins >= 0 && mins <= 59 && secs >= 0 && secs <= 59 && mon >= 1 && mon <= 12 && dy >= 1 && dy < days_in_month[month] )
    {
      super.hours = hrs;
      super.minutes = mins;
      super.seconds = secs;
      //super.Set(hrs,mins,secs);
      month = mon;
      day = dy;
      year = yr;
      return true;
    }
    //if not return false
    else
      return false;
  }//end of setTimeAndDate method
  
  public void increaseDay()
  {
    //Call Leap Year method
    if(leapyear(year))
      //If it's a leap year, set Feb to 29 days
      days_in_month[2] = 29;
    else
      days_in_month[2] = 28;

    //Increase the day by one
    day += 1;
    //Check what month we are in and make sure it is not going over
    if(day > days_in_month[month])
    {
      //Reset day to 1
      day = 1;
      //Increment month if we go over
      month += 1;
      
      //Check if we go OVER December
      if(month >= 13)
      {
        System.out.println("in if 2");
        //Set month to January
        month = 1;
        //Increment the year
        year++;
      }
  
    }
  }//end of increaseDay
  
  public void decreaseDay()
  {
     //Call Leap Year method
    if(leapyear(year))
      //If it's a leap year, set Feb to 29 days
      days_in_month[2] = 29;
    else
      days_in_month[2] = 28;
    
    day -= 1;
    //Check what month we are in and make sure it is not going under
    //If day goes less than 1, we have to go back one month
    if(day < 1)
    {
      //Decrement the month
      month -= 1;
      
      //Check to see if we are going to December from january
      if(month <= 0)
      {
        //If this is the case, set the day to December 31st
        day = days_in_month[12];
        //Set Month to December
        month = 12;
        //Decrement year by 1
        year--;
      }
      //Else we are okay and are not going back from january
      else
      {
        //Set day to the last day of previous month
        day = days_in_month[month-1];
      }
    }    
  }//end of decreaseDay
  
  public String showDateAndTime()
  {
    //Print Date in MM/DD/YYYY format
     String date = "";

    //See if hours is <10
    if(month < 10)
      date += "0" + Integer.toString(month) + "/";
    else
      date += Integer.toString(month)+ "/";
    
    //See if minutes is <10
    if(day < 10)
      date += "0" + Integer.toString(day) + "/";
    else
      date += Integer.toString(day)+ "/";
    
      //Print year
      date += Integer.toString(year)+ " ";
    
      String time = super.toString();
    //Call print Time from Super class
    return date + time;  
  }
  
  /* -------------------------Homework 6 Starts Here------------------------ */
  void increaseSecond()
  {
    //call increase second from TimeType
    super.Increase();
    //String variable to hold current time and date from toString
    String s = super.toString();
    
    if(s.equals("12:00:00 AM"))
      increaseDay();
  }
  
  void decreaseSecond()
  {
    //call decrease second from TimeType
    super.Decrease();
    //String variable to hold current time and date from toString
    String s = super.toString();
    if(s.equals("11:59:59 PM"))
      decreaseDay();
  }
}//end of class definition