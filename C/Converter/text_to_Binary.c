/*	############################################
	# Author: Sau Ma                           #  
	# *text_to_Binary Function                 #
	# -Converting Text Files into Binary Files #
	############################################
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "prototypes.h"

void text_to_Binary(FILE *f_in, FILE *f_out)
{
	/* Max size of 256 (Includes \0) */
	/* Variables to hold attributes of file */
	unsigned char length1;
	unsigned char first_name[256];
	unsigned char last_name[256];
	unsigned char length2;
	unsigned int id_number;
	float gpa;
	/*  Loop through the file to read */
	while((fscanf(f_in, "%s %s %d %f",first_name, last_name, &id_number, &gpa)) != EOF)
	{	
		length1 = strlen(first_name);				//Get #bytes for first name
		fwrite(&length1, sizeof(unsigned char), 1, f_out);	//Write length to first name to binary
		fwrite(first_name, sizeof(length1), length1, f_out);	//Write first name to binary
		length2 = strlen(last_name);				//Get #bytes of last name
		fwrite(&length2, sizeof(unsigned char), 1, f_out);	//Write length of last name to binary
		fwrite(last_name, sizeof(length2), length2, f_out);	//Write last name to binary
		fwrite(&id_number, sizeof(unsigned int), 1, f_out);	//Write id # to binary
		fwrite(&gpa, sizeof(float), 1, f_out);			//Write gpa # to binary
	}

	/* Close files */
	fclose(f_in);
	fclose(f_out);
}//End of Function

