//  Corey Shrader
//  inout.c
//  Program2
//
//  Created by Corey Shrader on 9/27/15.
//
//  This file includes functions used for reading in valid files and outputting game summaries.

#include "football.h"

void input(FILE *fp, char HT[], int *HTO, int *HTD, int *HTS, int *HTH, int *HTC, char VT[], int *VTO, int *VTD, int *VTS, int *VTR) {

    fscanf(fp, "%s %d %d %d %d %d %s %d %d %d %d", HT, HTO, HTD, HTS, HTH, HTC, VT, VTO, VTD, VTS, VTR);
}

void output(char winner[], char loser[], int amount) {
    
    printf("Predicted %s over %s by %d\n", winner, loser, amount);
}

void summary(int predictions, int homeWins){
    
    printf("Out of %d games played, %.2f%% favor the home team.\n", predictions, 100.0 * (double)homeWins/predictions);
}