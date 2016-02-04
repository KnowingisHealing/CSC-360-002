//
//  chutesandladders.h
//  Program3
//
//  Created by Corey Shrader on 10/13/15.
//  Copyright © 2015 Corey Shrader. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <time.h>

void output(char *board, char *p1, char *p2, FILE *fp);

char* movePlayers(char *p1, char *p2, char* board);

char* findHaven(char *p, char *board);

char* chuteLadder(char *p);



