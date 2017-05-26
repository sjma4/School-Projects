/*
Objective:
-Rock/Paper/Scissors  Game
-Prompt user for replay
-Count wins/loss/ties and total games played
*/
 
#include <stdio.h>
#include <time.h>
 
//Trial Checker
int trial = 0, isRetrying = 1, isDigit = 1;
int user_Choice = 0, pc_Choice = 0;
 
int playing = 1;
 
// Wins/Losses
int win = 0, lose = 0, tie = 0;
 
int main(void)
{
    //Total games played counter
    int games = 0;
 
    //Value for Rock Paper Scissor
    int done = 0;
    int rock = 1;
    int paper = 2;
    int scissors = 3;
 
    /*while (playing)
    {*/
        //Prompt user for input + read input
        fseek(stdin, 0, SEEK_END);
        printf("Choose: 1 for Rock, 2 for Paper, 3 for Scissors (4 to Stop): ");
        scanf("%d", &user_Choice);
        checkInput();
 
        randChar();
        displayComputer();
        displayUser();
        compareResults();
         
    //Print Total Results
    /*
    puts("Trial Results");
    printf("Wins: %d \n", win);
    printf("Losses: %d \n", lose);
    printf("Ties: %d \n", tie);
 
    games = win + lose + tie;
    printf("Total Games Played: %d", games);
    */
 
}
 
displayComputer()
{
    //Display Computer's Choice
    switch (pc_Choice)
    {
    case 1: puts("\nComputer chose Rock.");
        playing = 0; //Stop while otherwise will be infinite
        break;
 
    case 2: puts("\nComputer chose Paper.");
        playing = 0; //Stop while otherwise will be infinite
        break;
 
 
    case 3: puts("\nComputer chose Scissor.");
        playing = 0; //Stop while otherwise will be infinite
        break;
 
    }
}
 
displayUser()
{
    //Display User's Choice
    switch (user_Choice)
    {
 
    case 1: puts("You chose Rock.");
        break;
 
 
    case 2: puts("You chose Paper.");
        break;
 
 
    case 3: puts("You chose Scissor.");
        break;
 
    case 4: puts("You have forfeited the match. COMPUTER WINS!");
        break;
 
        //default: puts("Error number is out of range. Try again.");
        //  continue;
 
    }
}
 
checkInput()        // Function to check for valid guess limit
{
    while (isDigit) // Run while checking for digit
    {
        if (user_Choice == 0)               // If the guess limit is 0, ask user to enter valid number
        {
            fseek(stdin, 0, SEEK_END);      // Clear the input buffer
 
            printf("\nYou did not select a valid choice, please re-select.\n");
            printf("\nChoose: 1 for Rock, 2 for Paper, 3 for Scissors (4 to Stop): ");
            scanf("%d", &user_Choice);
        }
 
        else if (user_Choice < 0 || user_Choice > 3)
        {
            fseek(stdin, 0, SEEK_END);      // Clear the input buffer
 
            printf("\nYou did not select a valid choice, please re-select.\n");
            printf("\nChoose: 1 for Rock, 2 for Paper, 3 for Scissors (4 to Stop): ");
            scanf("%d", &user_Choice);
        }
 
        else        // Anything else would be a valid number
        {
            isDigit = 0;                    // Confirmed it is a digit, does not need to check anymore
            break;                          // Done with checkLimit function
        }
    }
}
 
randChar()
{
    //RNG Seeder
    srand(time(NULL));
 
    //Set PC Choice
    pc_Choice = (rand() % 3) + 1;
}
 
playAgain()
{
    while (isRetrying)
    {
        fseek(stdin, 0, SEEK_END);
        printf("\nEnter 1 for Yes, 2 for No: ");
        scanf("%d", &trial);
 
        if (trial == 1)
        {
            isRetrying = 1;
            main();
        }
 
        else if (trial == 2)
        {
 
            isRetrying = 0;
            break;
        }
 
        else if (trial > 2 || trial < 1)
        {
            fseek(stdin, 0, SEEK_END);
            printf("\nInvalid number. Try again: ");
            scanf("%d", &trial);
            continue;
        }
    }
}
 
compareResults()
{
    while (1)
    {
        if ((user_Choice + 1) % 3 == pc_Choice)
        {
            //Print Loss Result
            puts("\nYOU LOSE!");
            ++lose;     //Counter for losing
            break;
        }
 
        else if (user_Choice == 2 && pc_Choice == 3)
        {
            puts("\nYOU LOSE!");
            ++lose;     //Counter for losing
            break;
        }
 
        //If statement for TIE Result
        else if (user_Choice == pc_Choice)
        {
            puts("\nYou tied!");
            ++tie;      //Counter for tieing
            break;
        }
 
        //Statement for WINNING
        else
        {
            puts("\nYou won.");
            ++win;      //Counter for winning
            break;
        }
    }
    puts("\nTry again?");
    playAgain();
}
