//  main.c
//  Shrader_Corey_CSC362_Program1
//
//  Created by Corey Shrader on 9/7/15.

#include <stdio.h>

void main() {
    int inputCounter=0,outputCounter=0,codeCounter=0,digit=0;		// counter variables
    FILE *fp1, *fp2;				// file pointers
    char current='0';     // current character input from the file
    double percent = 1.0;     // percent decrease
    
    fp1 = fopen("/Users/EntheoMac/Documents/School:NKU/Fall 2015/CSC 362-001 Computer Systems/Assignments/Program 1/Program1/Program1/p1-in3.txt", "r");		// open input file as read-only
    fp2 = fopen("/Users/EntheoMac/Documents/School:NKU/Fall 2015/CSC 362-001 Computer Systems/Assignments/Program 1/Program1/Program1/output3.txt", "w");     // open output file as write-only
    
    while((current = getc(fp1)) != EOF)	{   // get the next char and as long as it is not the EOF, continue
        inputCounter++;
    
        if ((current=='q' || current=='Q')) {   // conditional for 'q' code character
            if (isdigit(current=getc(fp1))) {   // make sure the 'q' has a digit after
                codeCounter++;                  // we then know that it's a code sequence
                inputCounter++;                 // increment input counter when "current" is changed
                digit = (int) current - 48;     // calculate digit for number of dummy characters
                for (digit=digit;digit>0;digit-- ) {    // skip "digit" number of dummy characters
                    inputCounter++;
                    current = getc(fp1);
                }
            }
            continue;   // used to skip bottom code, which would write the current char to output
        }
        
        if (current=='x' || current=='X' || current=='z' || current=='Z') {    // conditional for 'x' or 'z'
            if (ispunct(current = getc(fp1))) {     // make sure it has punctuation after
                inputCounter++;
                if (isdigit(current = getc(fp1))) {     // make sure punctuation has digit after
                    codeCounter++;     // now we can be sure it's a code sequence
                    inputCounter++;
                    digit = (int) current - 48;     // calculate digit for dummy characters
                    for (digit=digit;digit>0;digit--) {     // skip dummy characters
                        inputCounter++;
                        current = getc(fp1);
                        
                    }
                }
            }
            continue;
        }
            fputc(current, fp2);
            outputCounter++;
    }
    fclose(fp1);				// close files and output report
    fclose(fp2);
    percent = 100.0 * (((double)inputCounter-(double)outputCounter)/(double)inputCounter);//percent decrease
    printf("%-20s%.2f%%\n%-20s%d", "Percent decrease:", percent, "Number of codes:", codeCounter);
}
