/*
  Author: Sau Ma
  Homework 2 Due Thursday Sept. 24
  Objective: 
   -Read in user's inputted fraction
   -Reduce the fraction into simplest terms
*/

#include <stdio.h>

int main (void)
{
  //Variables for numerator and denominator of fraction
  int num, den;

  //Variables for the for loop and GCD of numerator and denominator
  int i, GCD;
  
  //Prompt user for fraction value
  puts("Enter a fraction (including the /)"); 
  
  //Read in value inputted by user
  scanf("%d / %d", &num, &den);

  /*
    Fraction validity test
    Testing for 0 in denominator
    Testing for 0 in numerator
    Testing for +/- (num = den) Fraction is = +/- 1
    Negating double negative (When den & num are both negative)
    Testing for negativity (when den || num are neg)
  */

  if(den == 0)
   {
    puts("Error: Fraction is undefined. Exiting Program.");
    return (1);
   }

  else if(num == 0)
   {
    puts("The fraction you entered is 0");
    return (1);
   }

  else if(num < 0 && den < 0)
   {
    den = den * (-1);
    num = num * (-1);
    printf("The fraction you entered is: %d/%d \n", num, den);
   }

  else if(num < 0 || den < 0)
   {
    printf("The fraction you entered is a negative: %d/%d \n", num, den);
   }

  else if( num == den && num < 0 && den < 0)
   {
    num = 1;
    den = 1;
    printf("The fraction you entered is: %d/%d \n", num, den);
   }

  else 
   {
    printf("The fraction you entered is: %d/%d \n", num, den);
   }

  //Finding GCD of the fraction
  for( i = 1; i <= num || i <= den; i++)
	{
	  if(num % i == 0 && den % i == 0)
	  GCD = i;
	}

  //Reducing numerator and denominator by GCD
  num = num/GCD;
  den = den/GCD;
  
  //Printing the inputted fraction in lowest terms
  printf("The fraction in simplest form is: %d/%d \n", num, den);
  
  //End of Main	     	  
}
