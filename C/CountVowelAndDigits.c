/*
   Objective:
   - Calculate # of Vowels and Digits user inputs
   - Accept MAX. 50 Characters
*/

#include <stdio.h>
#define SIZE 100

int main(void)
{ 
  //Array for holding 50 characters
  int char_Array[SIZE];
  
  //Variables for user input, i for loop, counter for # of chars
  int input, i, counter = 0;

  //Array Indexer
  int iArray = 0; 

  //Variables to count vowels and digits
  int a_Count = 0;
  int e_Count = 0;
  int i_Count = 0;
  int o_Count = 0;
  int u_Count = 0;
  int digit = 0;

  //Initialize Array elements to 0
  for(i = 0; i <= SIZE; ++i)
  {
    char_Array[i] = 0;
  }
   

  //Prompt user/instructions
  puts("Enter up to 50 characters");
  puts("When finished press Ctrl D.");
  
     //Loop that goes through user's input until EOF is typed
     while(counter < 50 && (input = getchar()) != EOF)
     {			
	//Store input into array elements
	char_Array[iArray++] = input;
        
	   switch(input)
       	   {
	    case 'A':	//Check for A (uppercase or lowercase)
	    case 'a':
	    ++a_Count;	//Increment A vowel counter
            break;	//Exit Switch

	    case 'E':	//Check for E (uppercase or lowercase)
	    case 'e':
	    ++e_Count;	//Increment E vowel counter
	    break;	//Exit Switch

	    case 'I':	//Check for I (uppercase or lowercase)
	    case 'i':
	    ++i_Count;	//Increment I vowel counter
	    break;	//Exit Switch

	    case 'O':	//Check for O (uppercase or lowercase)
	    case 'o':
	    ++o_Count;	//Increment O vowel counter
	    break;	//Exit switch

	    case 'U':	//Check for A (uppercase or lowercase)
	    case 'u':
	    ++u_Count;	//Increment U vowel counter
	    break;	//Exit Switch

	    case '0':	//Check for digits
	    case '1':	
	    case '2':
	    case '3':
	    case '4':
	    case '5':
	    case '6':
	    case '7':
	    case '8':
	    case '9':
	    ++digit;	//Increment digit counter
	    break;	//Exit Switch

	    case '\n':	//Ignore New line
	    case '\t':	//Ignore Tab
	    case ' ':	//Ignore Spaces
	    break;	//Exit Switch
		
	  }
	 ++counter;
	  
	}
  	  	
   
    //Tabular Format Header
    printf("%s \t %s \n", "Number of Times", "Vowels/Digits");
	  
  	  

    //Printing Numbers/Vowels
    printf("\t %d \t \t   %s \n", a_Count, "A");
    printf("\t %d \t \t   %s \n", e_Count, "E");
    printf("\t %d \t \t   %s \n", i_Count, "I");
    printf("\t %d \t \t   %s \n", o_Count, "O");
    printf("\t %d \t \t   %s \n", u_Count, "U");
    printf("\t %d \t \t   %s \n", digit, "#");

    
}
