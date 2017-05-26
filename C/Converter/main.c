/*  #################################################
 	#	Author: Sau Ma                              #
 	#	CSI402: Systems Programming                 #
 	# Assignment 1: File Conversion                 #
 	# -Convert a Binary File to Text                #
 	# -Convert Text File io Binary                  #
 	# -Compute stats of binary file if flag is -s   #
 	#################################################
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "constants.h"
#include "prototypes.h"

int main( int argc, char *argv[])
{
	

    /* Check for correct command line argument input */
	if( argc < 3 || argc > 4)
	{
		puts("Incorrect number of arguments. Must be 3 or 4 arguments.");
		fflush(stdout);
		exit(1);
	}

	/* -t Flag = Convert Text to Binary */
	if( strcmp(argv[1], "-t") == 0 )
	{
		/* Error Check - Opening input and output file */
		if( (input_File = fopen(argv[2],"r")) == NULL)
		{
			fprintf(stderr, "Could not open input file: %s \n", argv[2]);
			fflush(stderr);
			exit(1);
		}
		if((output_File = fopen(argv[3],"wb")) == NULL)
		{
			fprintf(stderr, "Could not open output file: %s \n", argv[3]);
			fflush(stderr);
			exit(1);
		}
		/* Begin text -> Binary Conversion */
		else
		{
			fprintf(stderr, "-t Flag detected. \n Converting Text -> Binary.\n");
			fflush(stderr);
			text_to_Binary(input_File, output_File);
		}
	}//End of -t Flag If

	/* -b Flag = Convert Binary to Text*/
	else if( strcmp (argv[1], "-b") == 0)
	{
		/* Error Check - Opening input and output file */
		if( (input_File = fopen(argv[2],"rb")) == NULL)
		{
			fprintf(stderr, "Could not open input file: %s \n", argv[2]);
			fflush(stderr);
			exit(1);
		}
		if((output_File = fopen(argv[3],"wt")) == NULL)
		{
			fprintf(stderr, "Could not open output file: %s \n", argv[3]);
			fflush(stderr);
			exit(1);
		}
		else
		{
			/* Begin Binary to Text Conversion */
			fprintf(stderr, "-b Flag detected. \n Converting Binary -> Text. \n");
			fflush(stderr);
			binary_to_Text(input_File, output_File);
		}
	}// End of -b flag If

	/* On incorrect flag type */
	else
	{
		puts("Invalid flag type. Flag must be '-t', '-b' or '-s'.");
		fflush(stdout);
	}

	//Close input/output files
	fclose(input_File);
	fclose(output_File);
}//End of Main
