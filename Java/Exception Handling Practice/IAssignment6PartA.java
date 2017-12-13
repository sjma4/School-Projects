//This program will catch division by zero expressions using exception handling
import java.util.InputMismatchException;
import java.util.Scanner;

public class IAssignment6PartA
{
  //Method to divide
  public static int divide(int numerator, int denominator)
    throws ArithmeticException
  {
    return numerator/denominator;
  }
  
  //Main Method
  public static void main(String[] args)
  {
    //Create scanner object
    Scanner input = new Scanner(System.in);
    boolean cont = true;
    
    do
    {
      try
      {
        System.out.print("Enter integer numerator");
        int num = input.nextInt();
        System.out.print("Enter denominator");
        int den = input.nextInt();
        
        int result = divide(num,den);
        System.out.printf("%nResult: %d / %d = %d%n ",num,den,result);
        cont = false;
        
      }
      catch(InputMismatchException mismatch)
      {
        System.err.printf("%nException: %s%n", mismatch);
        input.nextLine(); //discard input
        System.out.printf("Only enter integers. Try again\n");
      }
      catch(ArithmeticException arithmetic)
      {
        System.err.printf("%nException: %s%n", arithmetic);
        System.out.printf("Cannot use 0 as denominator. Try again\n");
      }
    }while(cont);
    }
  }
