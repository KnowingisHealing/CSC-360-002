//
//  main.c
//  Program2
//
//  Created by Corey Shrader on 9/24/15.
//
//

#include "football.h"

public void main() {
    char[30] HT, VT;
    int HTO, HTD, HTS, HTH, HTC, VTO, VTD, VTS, VTR, predictions, homeWins, visitWins, amount;
    double preference1, preference2, preference3, preference4, preference5, sum;
    FILE *fp;
    
    fp = fopen("/Users/EntheoMac/Documents/School:NKU/Fall 2015/CSC 362-001 Computer Systems/Program2/Program2/football1.txt", "r");
    
    while (!feof(fp)) {
        
        input(fp, HT, &HTO, &HTD, &HTS, &HTH, &HTC, VT, &VTO, &VTD, &VTS, &VTR)
        
        compute(HTO, HTD, HTS, HTH, HTC, VTO, VTD, VTS, VTR, &preference1, &preference2, &preference3, &preference4, &preference5);
        
        sum = prediction(preference1, preference2, preference3, preference4, preference5);
        
        amount = (int)(abs(sum));
        
        if (sum < 0) {
            update(1, 0, 1, &predictions, &homeWins, &visitWins);
            output(VT, HT, amount);
        }
        else {
            update(1, 1, 0, &predictions, &homeWins, &visitWinds);
            output(HT, VT, amount);
        }
        
    }
    
    summary(predictions, homeWins);
    
    fclose(fp);
}