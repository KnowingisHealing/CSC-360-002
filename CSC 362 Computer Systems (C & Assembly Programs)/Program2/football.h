//  Corey Shrader
//  football.h
//  Program2
//
//  Created by Corey Shrader on 9/27/15.
//
//  This is a header file containing constants and prototypes for a program which, given a valid input file with several pairs of football teams and their stats, will compute predictions about which team will win.

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define OFFENSIVE_FACTOR 1.5
#define SPECIAL_TEAMS_FACTOR 1.2
#define HOME_FIELD_ADVANTAGE 1.3
#define OVERALL_FACTOR 1.15
#define OFFENSIVE_WORTH 0.32
#define DEFENSIVE_WORTH 0.28
#define SPECIAL_WORTH 0.15
#define HOME_WORTH 0.1
#define OVERALL_WORTH 0.15

void input(FILE *fp, char HT[], int *HTO, int *HTD, int *HTS, int *HTH, int *HTC, char VT[], int *VTO, int *VTD, int *VTS, int *VTR); // takes input file and stores components of a line into respective team stats

void compute(int HTO, int HTD, int HTS, int HTH, int HTC, int VTO, int VTD, int VTS, int VTR, double *preference1, double *preference2, double *preference3, double *preference4, double *preference5); // computes preferences given team stats

double prediction(double preference1, double preference2, double preference3, double preference4, double preference5); // returns a double value which represents the winning team and the score difference

void output(char winner[], char loser[], int amount); // prints the predicted winning and losing teams, and their score difference

void update(int x, int y, int z, int *predictions, int *homeWins, int *visitWins); // updates the values of running totals after each game is predicted

void summary(int predictions, int homeWins); // prints a summary of the games, including the percentage which favored the home team
