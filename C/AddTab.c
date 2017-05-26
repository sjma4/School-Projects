/*
   This program inserts a tab in between the digits of the number the user inputs.
*/


#include <stdio.h>

int main(void)
{
 //Variable for user's input
 int number;

 //Variables for getting each individual digit (up to 5 digits)
 int a, b, c, d, e;

 puts("Enter a number between 0-99999");
 scanf("%d", &number);

 /*
   Validity Check (In range)
   Algorithm to separate digits
 */
 if(number > 99999 || number < 0)
 {
   puts("Error: The number you entered is out of range. Exiting...");
   return (1);
 }
 else
 {
   a = number/10000 %10;
   b = number/1000 %10;
   c = number/100 %10;
   d = number/10 %10;
   e = number/1 %10;
 }
 printf("The digits are: %d \t %d \t %d \t %d \t %d \t \n", a, b, c,d, e);

// End of Main
}
