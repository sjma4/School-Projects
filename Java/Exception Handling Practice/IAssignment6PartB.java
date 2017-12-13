//This program will catch if user enters a String/Char in the amount field.
import java.util.InputMismatchException;
import java.util.Scanner;

public class IAssignment6PartB
{
  
  //Main method
  public static void main(String[] args)
  {
    //Create scanner object
    Scanner input = new Scanner(System.in);
    boolean cont = true;
    
    //Loop to get user input and check mismatch
     do
    {
      try
      {
        System.out.print("Enter your name");
        String name = input.nextLine();
        System.out.print("Enter transfer amount");
        int den = input.nextInt();
        
        System.out.printf("%nName: %s", name);
        System.out.printf("%nTransfer amount: %d",den);
        cont = false;
        
      }
      catch(InputMismatchException mismatch)
      {
        System.err.printf("%nException: %s%n", mismatch);
        input.nextLine(); //discard input
        System.out.printf("Only enter integers for transfer amount. Try again\n");
      }
     }while(cont);
    
      
  }
}