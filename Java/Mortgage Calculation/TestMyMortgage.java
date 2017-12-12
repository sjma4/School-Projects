/* Author: Sau Ma
 * Student ID: 001205963
 * Course: CSI205 - Object Oriented Programming (T/TH 5:45PM - 6:40PM ES0241)
 * Date: 10/5/17
 * Assignment: Homework 3
 * Description: This program will use MortgageCalcs.java and call its methods to display results
 *       
 */
//Import Scanner package
import java.util.Scanner;

public class TestMyMortgage
{
  public static void main(String [] args)
  {
    //Variable declaration
    double principal = 0;
    double term = 0;
    double interest_Rate = 0;
    //Boolean variable to start/end loops
    boolean looper = true;
    //Create scanner object
    Scanner input = new Scanner(System.in);
    
    //*************************3 While Loops to obtain input until conditions met*****************************
    //Loop to make sure user enters a value until conditions met for Principal
    while(looper == true)
    {
      //Prompt for Principal Amount
      System.out.println("Please enter a principal amount between $1 and $500,000");
      principal = input.nextDouble();
      //Check if principal is in range
      if(principal > 500000 || principal < 1)
      {
        System.out.println("Principal entered is out of range please try again.");
        continue;
      }      
      //Set looper to false to end loop
      looper = false;
    }//End of while for Principal
    
    //Reset looper
    looper = true;
    //Loop to make sure user enters a value until conditions met for term
    while(looper == true)
    {  
      //Prompt for term amount
      System.out.println("Please enter a term between 1 year and 30 years");
      term = input.nextDouble();      
      //Check if term is in range
      if(term > 30 || term < 1)
      {
        System.out.println("Term entered is out of range please try again.");
        continue;
      }      
      looper = false;
    }//End of while for term 
    
    //Reset Looper
    looper = true;
    //Loop to make sure user enters a value until conditions met for Interest rate
    while(looper == true)
    {  
      //Prompt for Interest Rate amount
      System.out.println("Please enter an interest rate between 1% and 15%");
      interest_Rate = input.nextDouble();
      
      //Check if Interet rate is in range
      //Check if term is in range
      if(interest_Rate > 15 || interest_Rate < 1)
      {
        System.out.println("Term entered is out of range please try again.");
        continue;
      }     
      //End Loop
      looper = false;
    }//end of while for interest rate
    
    //Reset Looper
    looper = true;
    
    //Create MortgageCalcs Object
    //This will call constructor and pass the three parameters into the MortgageCalcs constructor
    MortgageCalcs compute = new MortgageCalcs(interest_Rate, term, principal);
    
    //****************************************Print out Results***************************************
    //Print out Principal Amount
    System.out.printf("Principal Amount: %.2f\n", compute.getprincipal());
    //Calculate Future Value + Print Future Value
    System.out.printf("Future Value: %.2f\n", compute.futureValue());
    //Print Term of Loan
    System.out.printf("Term: %.2f\n", compute.getterm());
    //Print Interest Rate
    System.out.printf("Interest Rate: %.2f\n", compute.getinterestRate());
    //Calculate + Print out Interest Charge
    System.out.printf("Interest Charge: %.2f\n", compute.intCharge());
    //Calculate + Print Payment Per Month
    System.out.printf("Payment: %.2f\n", compute.calcPayment());
    
    //***************************************Amortize Method*******************************************
    //Call Amortize
    while(looper = true)
    {
      System.out.println("Please enter the number of months. To exit type -1");
      int months = input.nextInt();
      
      //check if user enters -1, if true, program terminates
      if(months == -1)
      {
        System.out.println("Program terminating...");
        System.exit(0);
      }
      //check boolean value of amortize method, if true, execute
      //then prompt for another # of months
      if(compute.amortize(months))
      {
        continue;
      }
      //Else give error msg and prompt for a new input
      else
      {
        System.out.println("Number of months is too big. Please try again.");
        continue; 
      }
    }
      
  }//End of main
}//End of class definition