//  Corey Shrader
//  computations.c
//  Program2
//
//  Created by Corey Shrader on 9/27/15.
//
//  This file contains functions which compute values used for making predictions about the winning and losing teams.

#include "football.h"

void compute(int HTO, int HTD, int HTS, int HTH, int HTC, int VTO, int VTD, int VTS, int VTR, double *preference1, double *preference2, double *preference3, double *preference4, double *preference5) {
    
    *preference1 = HTO * OFFENSIVE_FACTOR - VTD;
    *preference2 = HTD + 2 - VTO * OFFENSIVE_FACTOR;
    *preference3 = HTS * SPECIAL_TEAMS_FACTOR - VTS;
    *preference4 = HTH + HTC * HOME_FIELD_ADVANTAGE - VTS;
    *preference5 = HTO * HTD * HTH * OVERALL_FACTOR - VTO * VTD * VTR;
    
}

double prediction(double preference1, double preference2, double preference3, double preference4, double preference5) {

    return preference1 * OFFENSIVE_WORTH + preference2 * DEFENSIVE_WORTH + preference3 * SPECIAL_WORTH + preference4 * HOME_WORTH + preference5 * OVERALL_WORTH;
}

void update(int x, int y, int z, int *predictions, int *homeWins, int *visitWins) {

    *predictions += x;
    *homeWins += y;
    *visitWins += z;
    
}