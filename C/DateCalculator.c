/*
   Lab 9 
   Objective:
	-Read date from command line. Output Structure: November 15, 2015
	-Allow user to enter the date as 11-15-15 or 11/15/15
	-No spaces
	-Error Check to make sure the date input is correct

   Author: Sau Ma
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
//Month Array
char *month[]={"January","February","March","April","May","June","July",
"August","September","October","November","December"};

//Variables for Month, Day, Year
int m,d,y;

char c,b;

//Prompt User
puts("Enter a date. (Format must be 10-15-2015 or 10/15/2015).");

//Read input
scanf("%d%c%d%c%d",&m,&c,&d,&b,&y);
//Convert from string to integer
  
//Error Checking for Date Input
if(m <= 12)				//Check Month
{
  if((b =='/')||(b =='-'))		//Check Format
  {
     if(d <= 32)			//Check Day
     {
        if((c =='/')||(c =='-'))	//Check Format
        {
           if(y <= 9999)		//Check Year
           {
           printf("Your Date: is %d%c%d%c%d\n",m,c,d,c,y); 
           puts(" ");
           printf("Result: %s %d, %d\n",month[m-1],d,y); 
     }
     else
          puts("Invalid year.");
     }
     else 
          puts("Invalid input.");
     }
     else
          puts("Invalid day.");
     }
     else
          puts("Invalid input.");
     } 
     else
          puts("Invalid month. ");

return 0;
}// End of Main



