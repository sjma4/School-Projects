/*
    This programs counts the number of characters, words and average word length
    of a sentence that is inputted by the user.
*/

 
#include<stdio.h>
#define SIZE 100

int main( void )
{
  
  int c;
  int sentence[SIZE];
  int i = 0;
  int charCount = 0, wordCount = 1;
  float average = 0;
  int counter;


  printf("Enter a sentence: ");
  
  //Get each character from sentence
  while(wordCount <= SIZE && (c = getchar()) != '\n')
  {   
    sentence[i++] = c;       

   	if(c != ' ')
   	{
     	  ++charCount;    
   	}
   
   	else if(c == ' ')
   	{
          ++wordCount;
   	}   
  } 
  
  sentence[i] = '\0';
  
  //Printing array of user input
  printf("The line entered was: ");

  for(counter = 0; counter < i; ++counter)
  {
   putchar(sentence[counter]);
  }
  
  printf("\n");

  //Print # of characters inputted
  printf("The character count for the sentence is: %d \n", charCount);

  //Print # of word count
  printf("The word count for that sentence is: %d \n", wordCount);
 
  //Compute the average number of words
  average = (float) (charCount/wordCount);

  printf("The average number of words is: %.2f \n", average);

}

