/*  #####################################
	# Author: Sau Ma                    #
	# *binary_to_Text Function          #
	# -Converting Binary Files to Text  #
	#####################################
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stddef.h>
#include "prototypes.h"

void binary_to_Text(FILE *f_in, FILE *f_out)
{
	//* Max size of 256 (Includes \0) */
	/* Variables to hold attributes of file */
	unsigned char first_name[256];
	unsigned char firstName_length = strlen(first_name);
	unsigned char last_name[256];
	unsigned char lastName_length = strlen(last_name);
	unsigned int id_number;
	float gpa;


	/* Loop through the file until EOF */
	while(1)
	{
		/* Read each element */
		fread(&firstName_length, sizeof(unsigned char),1, f_in);
		fread(first_name, firstName_length, 1, f_in);
		fread(&lastName_length, sizeof(unsigned char),1, f_in);
		fread(last_name, lastName_length, 1, f_in);
		fread(&id_number, sizeof(unsigned int), 1, f_in);
		fread(&gpa, sizeof(float), 1, f_in);	

		if( feof(f_in) )
		{
			break;
		}

		//Append Null Terminating Character to the End
		first_name[firstName_length] = '\0';
		last_name[lastName_length] = '\0';
		
		/* Write data to Text File */	      
		fprintf(f_out, "%s %s %u %.1f \n", first_name, last_name, id_number, gpa);
	}

	/* Close files */
	fclose(f_in);
	fclose(f_out);

}//End of Function
