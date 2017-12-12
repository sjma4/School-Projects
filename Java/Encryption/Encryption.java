/*  Author: Sau Ma
 * iAssignment 2 - Encryption
 * -Given Encrypted Algorithm: Add 7 to each digit then mod each digit by 10
 * -Swap first # with 3rd #
 * -Swap 2nd # and 4th #
 * -This class will Encrypt and Decrypt the numbers entered by user
 */

public class Encryption
{
  //This method will add 7 to each of the integers and then modding each number by 10.
  public void encrypt(int num1, int num2, int num3, int num4)
  {
    int encrypted1 = (num1 + 7)%10;
    int encrypted2 = (num2 + 7)%10;
    int encrypted3 = (num3 + 7)%10;
    int encrypted4 = (num4 + 7)%10;
      
    //Swap first digit and third digit
    int new_1 = encrypted3;
    int new_3 = encrypted1;
      
    //Swap second digit and fourth digit
    int new_2 = encrypted4;
    int new_4 = encrypted2;
    
    //Print Result
    System.out.printf("Encrypted Number = %d %d %d %d\n", new_1, new_2, new_3, new_4);    
  }//End of Encrypt Method
  
  //This method will take encypted integers and decrypt them
  public void decrypt(int num1, int num2, int num3, int num4)
  {
    //Reswap first digit and third digit
    int swap3 = num1;
    int swap1 = num3;
    //Reswap second digit and fourth digit
    int swap4 = num2;
    int swap2 = num4;
    
    //Reverse Encrypting Algorithm
    swap1 = ((swap1 - 7) % 10);
    swap2 = ((swap2 - 7) % 10);
    swap3 = ((swap3 - 7) % 10);
    swap4 = ((swap4 - 7) % 10);

    //If Number is - add 10
    if(swap1 < 0)
      swap1 += 10;
    if(swap2 < 0)
      swap2 += 10;
    if(swap3 < 0)
      swap3 += 10;
    if(swap4 < 0)
      swap4 += 10;
            
    System.out.printf("Decrypted Integers: %d %d %d %d\n", swap1, swap2, swap3, swap4);
  }//End of Decrypt Method
}