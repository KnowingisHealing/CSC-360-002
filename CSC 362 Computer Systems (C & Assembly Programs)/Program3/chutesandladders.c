//
//  chutesandladders.c
//  Program3
//
//  Created by Corey Shrader on 10/13/15.
//  Copyright © 2015 Corey Shrader. All rights reserved.
//

#include "chutesandladders.h"

void output(char *board, char *p1, char *p2, FILE *fp){
    
    char* current; // used for iterating through board
    
    for (current=board; *current!='\0'; current++) {
        if (current==p1)
            putc('1',fp);
        else if (current==p2)
            putc('2',fp);
        else
            putc(*current,fp);
    }
    
    fputs("\n",fp);
}

char* movePlayers(char *p1, char*p2, char *board){
    
    char tempVal, *tempPos; // used in some conditions to store and output player's initial value
    int roll; // stores number rolled on die
    
    roll = (rand()%6)+1; // start by rolling player one's die, storing the value for output
    p1 += roll; // move player amount of spaces rolled by die
    
    if (p1 < board + 100) { // ensure that player is still on board
        
        tempVal = *p1; // store player's current value for output
        tempPos = p1; // store player's current position for comparison at end
        
        if (p1 == p2) { // first, check for a collision
            p1--;
            printf("rolled %d  collision! ... moving back one square ... now at %d\n", roll, (int)(p1 - board));
        }
        
        else { // if there's no collision, check current space and take appropriate next step
            
            if (*p1 == 'B' || *p1 == 'F') { // check for moving back or forward to a haven
                
                p1 = findHaven(p1, board); // call function to move player to nearest haven
                
                if (tempVal == 'B') // check player's initial position and output appropriate message
                    printf("rolled %d  moving backward to haven... now at %d\n", roll, (int)(p1 - board));
                if (tempVal == 'F')
                    printf("rolled %d  moving forward to haven... now at %d\n", roll, (int)(p1 - board));
            }
            
            else if (*p1 >= 'a' && *p1 <= 'z') { // check for a chute or ladder
                
                if (*p1 != 'n')  // treat 'n' as a regular space by skipping the rest of this conditional
                    p1 = chuteLadder(p1); // call this function to move player to correct position
                
                if (tempVal >= 'a' && tempVal <= 'm') // check player's initial position and output appropriate message
                    printf("rolled %d  landed on a chute...moving %d... now at %d\n", roll, (int)(tempVal-110), (int)(p1 - board));
                if (tempVal >= 'o' && tempVal <= 'z')
                    printf("rolled %d  landed on a ladder...moving %d... now at %d\n", roll, (int)(tempVal-110), (int)(p1 - board));
                *tempPos = '*';
            }
            
            if (p1 == p2) { // check to see if one of the moves above caused a collison
                if (p1 != board) {// if player was sent backward to other player and both are at first space: stay.
                    p1--;
                    printf("collison from last move! ... moving back one square ... now at %d\n", (int)(p1 - board));
                }
            }
            
            else if (p1 == tempPos) { // finally, print roll and position if nothing special happened
                printf("rolled %d  now at %d\n", roll, (int)(p1 - board));
            }
        }
    }
    
    else {
        printf("rolled %d  ... and won the game!\n", roll);
    }
    //printf("%c \n", *p1);
    //printf("%d \n", p1 < board + 100);
    return p1;
    
}

char* findHaven(char *p, char *board){
    
    char *temp = p; // temporary pointer to player's initial position
    char *h = p; // a "haven finder"- starts at player's position and moves until finding haven
    
    while (*h != 'H' && h != board && *h != '\0') { // look for haven
        if (*temp == 'B') // go backward until haven or beginning of board is found
            h--;
        if (*temp == 'F') // go forward until haven or end of board is found
            h++;
    }
    
    // remove the haven since it has been used
    
    if (*h == '\0') // player stays if next haven is end of board
        return p;
    else { // otherwise, player moves to nearest haven or beginning of board
        if (*h=='H')
            *h='_';
        return h;
    }
}

char* chuteLadder(char *p){
    
    p += (int)(*p-110); // move player appropriate distance
    
    return p;
}
*/