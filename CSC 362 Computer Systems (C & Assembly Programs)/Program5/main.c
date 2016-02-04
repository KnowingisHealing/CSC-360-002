//
//  main.c
//  Program5
//
//  Created by Corey Shrader on 11/5/15.
//  Copyright © 2015 Corey Shrader. All rights reserved.
//

#include <stdio.h>

void main() {
    int min, minposition, j, i, n=14;
    
    int a[14] = {8, -1, 7, -8, 6, 3, -4, 4, 1, -2, 9, -5, 0, 2};
    
    /*asm (         "mov  eax, t"
                  "add  eax, 1"
                  "mov  t, eax"
                 );
    
    printf("%d", t);*/
    
    for(i=0;i<n-1;i++)
    {
        min = a[i];
        minposition = i;
        for(j=i+1;j<n;j++)
            if(a[j] < min)
            {
                min = a[j];
                minposition = j;
            }
        //swap a[i] and a[minposition]
        a[minposition] = a[i];
        a[i] = min;
    }
    
    //asm (""
   // );
    
    for (i=0;i<n;i++)
        printf("%d, ",a[i]);
}
