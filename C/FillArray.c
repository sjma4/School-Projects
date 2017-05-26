/*
  Lab 8
  Objective:
	-Dynamically Allocate 5000 Rows and Columns for a 2D Array
	-Randomly generate numbers 0-6
	-Print out How many times each number appears

  Author: Sau Ma
*/

#include<stdio.h>
#include<stdlib.h>
#define SIZE 5000

int main(void)
{
  //Array Indexer
  int iArray, jArray;

  //Number Counters
  int zero_Count = 0, one_Count = 0, two_Count = 0, 
      three_Count = 0, four_Count = 0, five_Count= 0, six_Count = 0;

  //Initialize 2D Array
  int *array = malloc (SIZE * SIZE * sizeof(int));

  //RNG Seeder
  srand(time(NULL));

  //Set random values in to the aray
  for(iArray = 0; iArray < SIZE; iArray++)
  {
    for(jArray = 0; jArray < SIZE; jArray++)
    {
    *(array + iArray * SIZE + jArray) = rand () % 7;    
    }
  }// End of Setting Random Values

  //Increment appearance counters
  for(iArray = 0; iArray < SIZE; iArray++)
  {
    for(jArray = 0; jArray < SIZE; jArray++)
    {
      //Check for 0
      if(*(array + iArray * SIZE +jArray) == 0)		
      {
	zero_Count++;	//Counter for 0's
      }
      //Check for 1
      else if(*(array + iArray * SIZE +jArray) == 1)	
      {
        one_Count++;	//Counter for 1's
      }
      //Check for 2
      else if(*(array + iArray * SIZE +jArray) == 2)	
      {
	two_Count++;	//Counter for 2's
      }
      //Check for 3
      else if(*(array + iArray * SIZE +jArray) == 3)
      {
	three_Count++;	//Counter for 3's
      }
      //Check for 4
      else if(*(array + iArray * SIZE +jArray) == 4)
      {
	four_Count++;	//Counter for 4's
      }
      //Check for 5
      else if(*(array + iArray * SIZE +jArray) == 5)
      {
	five_Count++;	//Counter for 5's
      }
      //Check for 6
      else if(*(array + iArray * SIZE +jArray) == 6)
      {
	six_Count++;	//Counter for 6's
      } 
    }//End of jArray Index
  }//End of iArray Index (Incrementation For Loop)

//Print number of times each number appears (0-6)
printf("0 appears: %d times \n", zero_Count);
printf("1 appears: %d times \n", one_Count);
printf("2 appears: %d times \n", two_Count);
printf("3 appears: %d times \n", three_Count);
printf("4 appears: %d times \n", four_Count);
printf("5 appears: %d times \n", five_Count);
printf("6 appears: %d times \n", six_Count);

//Free memory allocated by malloc
free(array);

return(0);

}// End of Main
