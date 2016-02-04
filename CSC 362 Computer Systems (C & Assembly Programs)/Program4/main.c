//
//  main.c
//  Program4
//
//  Created by Corey Shrader on 11/5/15.
//  Copyright © 2015 Corey Shrader. All rights reserved.
//

#include <stdio.h>
void main( ) {
    // declare your variables in C and initialize them (if you need to)
    
    int sum, x, y, denom, pair;
    
    sum = 6;
    
    while (sum <= 100) {
        
        pair = 0;
        x = 3;
        
        while (x < sum && pair == 0) {
            
            y = sum - x;
            denom = 2;
            
            while (x % denom != 0 && denom < x)
                denom += 1;
            if (x != denom) {
                x += 2;
            }
            else {
                denom = 2;
                while (y % denom != 0 && denom < y)
                    denom += 1;
                if (y == denom) {
                    printf("%d = %d + %d\n", sum, x, y);
                    pair = 1;
                }
                else {
                    x += 2;
                }
            }
        }
        if (x >= sum) {
            printf("No solution found.");
            return;
        }
        sum += 2;
    }
    
    /*asm ( // enter assembly code, from here on, code is assembled, not compiled
     // assembly code here to iterate for sum = 6 to 100
     " "
     // get the first x (3) and generate the first y (sum – x)
     " "
     // have a loop to determine if x is prime by dividing some denominator
     " "
     // into x (starting at denominator = 2) until either you find one that
     " "
     // divides into x (x is not prime) or denominator reaches x (x is prime)
     " "
     // if x is not prime, get next x/y pair (add 2 to x, compute y = sum – x)
     " "
     // otherwise determine if y is prime
     " "
     // if you find a prime x/y pair, exit assembly code to output this, as in
     // 8 = 3 + 5, return to assembly, increment sum by 2, repeat for loop
     " "
     // otherwise if you increment x and it reaches sum, then no x/y pair is
     " "
     // found, exit assembly, output no solution found and exit program
     " "
     );*/
    
}
