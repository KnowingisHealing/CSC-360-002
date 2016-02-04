/*  A program that will scan an input text file and count the number of lines, words and chars.
    I make the assumption that after every word you will have either 1 space, 1 tab or 1 return
    character (probably not a good assumption). */

#include <stdio.h>

void main()
{
	int lines=0, words=0, chars=0;		// counter variables
	FILE *fp;				// file pointer
	char filename[30], current;		// filename and the current character input from the file

	printf("Enter the filename to be scanned:  ");	// ask user for filename
	scanf("%s", filename);

	fp = fopen(filename, "r");		// open the file as read-only

	while((current = getc(fp)) != EOF)	// get the next char and as long as it is not the EOF, continue
	{
		chars++;			// add 1 to char counter since we have input a new char
		if(current==' '|| current == '\t' || current == '\n')	// if char is blank, tab or new line, thats the
			words++;		// end of one word, so add 1 to words
		if(current=='\n') lines++;	// if new line, then thats the end of a line, add 1 to lines
	}
	fclose(fp);				// close file and output report
	printf("\n\nThe file %s has %d characters, %d words and %d lines\n\n", filename, chars, words, lines);
}