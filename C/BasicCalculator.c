/*#############################################
  #Author: Sau Ma							  #
  #Class: CSI410 - Introduction to Databases  #
  #Date: 1/27/17							  #
  #Assignment 0: Simple Calculator		      #
  #      -Designing a simple calculator       #
  #		 -to Add,Sub,Divide,Multiply,Mod      #
  #############################################
*/

#include<stdio.h>
#include<stdlib.h>

/*********Function Prototypes*************/

//Add Function
int add(int num1, int num2);

//Sub
int sub(int num1, int num2);

//Mult
int mult(int num1, int num2);

//Div
int divide_num(int num1, int num2);

//Mod
int mod(int num1, int num2);



int main()
{
	/* Variables to store 2 integers for operation and 1 for action */
	int num1, num2;
	int result = 0;
	int operation;
	
	/* Prompt user for actions */
	puts("*****Welcome to Simple Calculator!***** \n");
	printf("Input the number corresponding to the operation you want to perform. \n");
	printf("MAIN MENU \n");
	printf("0) Exit \n"
			"1) Addition \n"
			"2) Subtraction \n"
			"3) Multiplication \n"
			"4) Division \n"
			"5) Mod \n");
	//Scan for operation action
	scanf("%d", &operation);
	/*
	// Check if user input is valid 
	
	  if(operation < 0 || operation > 5)
	  {
		  puts("Invalid command please try again");
	  }
	  
	  // Exit Program 
	  if(operation == 0)
	  {
		  printf("Result of your calculations is: %d \n", result);
		  puts("Exiting Calculator...");
		  exit(0);
	  }
*/
	
	//Scan 1st number
	puts("Please type your first number");
	scanf("%d", &num1);
	  
	//Scan 2nd number
	puts("Please enter your second number.");
	scanf("%d", &num2);	
	
	/* Loop to constantly perform operation until user exits */
	while(operation != 0)
	{	  
	  
	  /* Check if user input is valid */
	  if(operation < 0 || operation > 5)
	  {
		  puts("Invalid command please try again.");
		  puts("Choose another operation.");
		  scanf("%d", &operation);	  
	  }
	  
	  
	  /* Add Numbers */
	  if(operation == 1)
	  {
		  puts("You chose addition.");
		  result = num1 + num2;
		  num1 = result;
		  printf("Add Result = %d \n", result);
		  puts("Choose new operation");
		  scanf("%d", &operation);
		  
		  //Continue
		  if(operation != 0)
		  {
			  puts("Choose another number for computation.");
			  scanf("%d", &num2);
		  }
	  }
	  
	  /* Subtract Numbers */
	  if(operation == 2)
	  {
		  puts("You chose subtraction.");
		  result = num1 - num2;
		  num1 = result;
		  printf("Sub Result = %d \n", result);
		  puts("Choose new operation");
		  scanf("%d", &operation);
		  
		  //Continue
		  if(operation != 0)
		  {
			  puts("Choose another number for computation.");
			  scanf("%d", &num2);
		  }
	  }
	  
	  /* Multiply Numbers */
	  if(operation == 3)
	  {
		  puts("You chose multiplication.");
		  result = num1 * num2;
		  num1 = result;
		  printf("Mult Result = %d \n", result);
		  puts("Choose new operation");
		  scanf("%d", &operation);
		  
		  //Continue
		  if(operation != 0)
		  {
			  puts("Choose another number for computation.");
			  scanf("%d", &num2);
		  }
	  }
	  
	  /* Divide Numbers */
	  if(operation == 4)
	  {
		  puts("You chose division.");
		  result = num1/num2;
		  num1 = result;
		  printf("Division Result = %d \n", result);
		  puts("Choose new operation");
		  scanf("%d", &operation);
		  
		  //Continue
		  if(operation != 0)
		  {
			  puts("Choose another number for computation.");
			  scanf("%d", &num2);
		  }
	  }
	  
	  /* Mod Numbers */
	  if(operation == 5)
	  {
		  puts("You chose mod.");
		  result = num1%num2;
		  num1 = result;
		  printf("Mod Result = %d \n", result);
		  puts("Choose new operation");
		  scanf("%d", &operation);
		  
		  //Continue
		  if(operation != 0)
		  {
			  puts("Choose another number for computation.");
			  scanf("%d", &num2);
		  }
	  }
	}//End of While Loop
	
	/* Exit Program */
	if(operation == 0)
	{
		printf("Result of your calculations is: %d \n", result);
		puts("Exiting Calculator...");
		exit(0);
	}
    
}//End of Main