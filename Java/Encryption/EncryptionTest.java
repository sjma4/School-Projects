/* Author: Sau Ma
 * iAssignment 2 - Encryption
 * This file contains the main method to run the program.
 */

import java.util.*;
import java.math.*;

public class EncryptionTest
{
  //Main Method
  public static void main(String[] args)
  {
    
    //Variable Declaration
    int num1 = 0;
    int num2 = 0;
    int num3 = 0;
    int num4 = 0;
    String change;
    //Create scannner object & Encryption object
    Scanner input = new Scanner(System.in);
    Encryption code = new Encryption();
    
    System.out.println("Would you like to Encrypt or Decrypt integers? Press E/D?");
    change = input.nextLine();
    
    switch(change)
    {
      /*----------------------------------------Encryption--------------------------------------------------- */
      case "E":       
      case "e":
           //Prompt for Integer input & scan input
        System.out.println("Please enter 4 integers separated by a space to be encrypted.");
        num1 = input.nextInt();
        num2 = input.nextInt();
        num3 = input.nextInt();
        num4 = input.nextInt();
        //Encrypt
        code.encrypt(num1,num2,num3,num4);
        break;
      /*--------------------------------------Decryption------------------------------------------------------- */
      case "D":        
      case "d":
        //Prompt for Integer input & scan input
        System.out.println("Please enter 4 integers separated by a space to be decrypted.");
        num1 = input.nextInt();
        num2 = input.nextInt();
        num3 = input.nextInt();
        num4 = input.nextInt();
        //Encrypt
        code.decrypt(num1,num2,num3,num4);
        break;
      /*-----------------------------------------Incorrect Input---------------------------------------------- */
      default:
        System.out.println("Incorrect Choice. Exiting...");
        System.exit(0);
        
    }
  }
}
