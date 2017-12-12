/* Author: Sau Ma
 * Student ID: 001205963
 * Course: CSI205 - Object Oriented Programming (T/TH 5:45PM - 6:40PM ES0241)
 * Date: 9/19/17
 * Assignment: Homework 2
 * Description: Same as Homework 1, but No Main Method. Creating Each compuation as a separate method
 * 
 */

//Import Scanner
import java.util.Scanner;

public class MortgageCalcs
{
  //values that require input
  private double interestRate;
  private double term;
  private double principal;
  //Values that are computed
  private double payment;
  private double future_value;
  private double interest_charge;
  //Temp variable declaration for computation
  private double r;
  private double x;
  private double y;
  private double temp;
  
  //Constructor Method
  public MortgageCalcs(double interestRate, double term, double principal)
  {
    //Set interst rate, term and principal
    this.interestRate = interestRate;
    this.term = term;
    this.principal = principal;
    //Calculate temp variables
    //Calculate in Constructor so temp value calculation isn't redundant in other methods
    r = interestRate/100.0;
    x = 1.0+r/12.0;
    y = term * 12.0;
    temp = (1.0/Math.pow(x,y));
  }//End of Constructor
  
  /*------------------ Get Methods -----------*/
  //Interest Rate
  public double getinterestRate()
  {
    return interestRate;
  }//End of getinterestRate
  
  //Term
  public double getterm()
  {
    return term;
  }//End of get term
  
  //Principal
  public double getprincipal()
  {
    return principal;
  }//End of getprincipal
  
  /*---------Calculation Methods------------------ */
  //Method to calculate and return Monthly Payment
  public double calcPayment()
  {
   payment =(principal*r/12.0)/(1-temp);
   return payment;
  }//End of calcPayment
  
  //Method to calculate and return the Future Value
  public double futureValue()
  {
   payment =(principal*r/12.0)/(1-temp);
   future_value = payment * term * 12;  
   return future_value;
  }//End of futureValue
  
  //Method to calculate and return the Interest Charge
  public double intCharge()
  {
   payment =(principal*r/12.0)/(1-temp);
   future_value = payment * term * 12;
   interest_charge = future_value - principal;    
   return interest_charge;
  }//End of intCharge
  
  /* Create Amortize Table */
  public boolean amortize(int months)
  {
    //Check if the entered months matches the term
    if(months > (term * 12))
    {
      return false;
    }
    //Else entered months is true
    else
    {
      /*Here we calculate the payment in case user runs amortization method without calling calcPayment()
        If this statement is not here, when user calls amortization method without calling calcPayment(),
        the payment amount field will be 0; thus displaying incorrect values
      */
      payment =(principal*r/12.0)/(1-temp);
      //Variable declaration for Amortize Calculation
      double current_balance = principal;   //Loan Amount
      double pay_per_month = payment;      //Payment Per Month (This value stays the same)
      double int_per_month = 0;           //Interest Charge Per Month
      double princ_per_month = 0;        //Cost that actually reduces loan amount
      
      //Format Table Header
      System.out.format("%12s%18s%12s%13s%14s\n", "Month", "Payment Amount", "Interest", "Principal", "Balance");
      System.out.format("%10s%15s%15s%15s%15.2f\n", "", "", "", "", principal);
      for(int month_indexer = 1; month_indexer <= months; month_indexer++)
      {  
        //Calculate Interest Cost
        int_per_month = ((interestRate/12)/100) * current_balance;
        //Calculate Principal/Payment
        princ_per_month = pay_per_month - int_per_month;
        //Update New Balance
        current_balance -= princ_per_month;
        //Print table contents
        System.out.format("%10d%15.2f%15.2f%15.2f%15.2f\n", month_indexer, pay_per_month, int_per_month, princ_per_month, current_balance);
      }
      return true;
    }
  }//End of Amortize
  
}//End of MortgageCalcs class