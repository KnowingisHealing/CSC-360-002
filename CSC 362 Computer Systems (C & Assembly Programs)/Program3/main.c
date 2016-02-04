//  Corey Shrader
//  main.c
//  Program3
//
//  Created on 9/29/15.
//

/* This program simulates a game of Chutes and Ladders. Players move through an array of characters representing board spaces of different types, winning once they move beyond the final space in the array.
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void output(char *board, char *p1, char *p2, FILE *fp){ // function used to output the current status of the board to a line in a file
    
    char* current; // used for iterating through board
    
    for (current = board; current < board + 99; current++) { // iterates until reaching one space beyond the last (which is at index 98)
        if (current == p1) // outputs a 1 if p1 is on current space
            putc('1',fp);
        else if (current == p2)
            putc('2',fp); // outputs a 2 if p2 is on current space
        else
            putc(*current,fp); // otherwise, print the current space
    }
    
    fputs("\n",fp); // new line for next time function is called
}

char* chuteLadder(char *p){ // used when player lands on a chute or ladder, calculating where to move and sending player there
    
    p += (int)(*p-110); // move player appropriate distance
    
    return p;
}

char* findHaven(char *p, char *board){ // used in player lands on 'B' or 'F', sending player back or forward to nearest haven
    
    char *h = p; // a "haven finder"- starts at player's position and moves until finding haven
    
    while (*h != 'H' && h != board && h != board + 98) { // look for haven
        if (*p == 'B') // go backward until haven or beginning of board is found
            h--;
        if (*p == 'F') // go forward until haven or end of board is found
            h++;
    }
    
    if (h == board + 98) // player stays if next haven is end of board
        return p;
    else { // otherwise, player moves to nearest haven or beginning of board
        if (*h=='H')
            *h='_'; // remove haven after it has been used
        return h;
    }
}

char* movePlayers(char *p1, char*p2, char *board){ // used to roll a die and move a player to its appropriate position
    
    char tempVal, *tempPos; // use to store and, in some conditions, output player's initial value and/or position
    int roll; // stores number rolled on die
    
    roll = (rand()%6)+1; // start by rolling player one's die, storing the value for output
    p1 += roll; // move player amount of spaces rolled by die
    
    if (p1 < board + 99) { // ensure that player is still on board
        
        tempVal = *p1; // store player's current value for later output
        tempPos = p1; // store player's current position for comparison at end
        
        if (p1 == p2) { // first, check for a collision, moving player back one if necessary
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
                
                if (*p1 != 'n') {  // treat 'n' as a regular space by skipping the rest of this conditional
                    p1 = chuteLadder(p1); // call this function to move player to correct position
                    *tempPos = '*';
                }
                
                if (tempVal >= 'a' && tempVal <= 'm') // check player's initial position and output appropriate message
                    printf("rolled %d  landed on a chute...moving %d... now at %d\n", roll, (int)(tempVal-110), (int)(p1 - board));
                if (tempVal >= 'o' && tempVal <= 'z')
                    printf("rolled %d  landed on a ladder...moving %d... now at %d\n", roll, (int)(tempVal-110), (int)(p1 - board));
               
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
    
    else { // player wins if landed beyond last space on board
        printf("rolled %d  ... and won the game!\n", roll);
    }

    return p1;
    
}

void main() { // declares player, file, and board variables, and calls functions to move players and output statuses until one wins
    FILE *fp; // file used for output
    char *p1, *p2; // pointers for players
    char board[100]="  mHk nH l B He Flq p H  hByHlho H B  jr HFB ir j H  F ku gd  H pjB mH x  BF i H  m oB HlHFBhoH BB "; // board array
    
    srand(time(NULL)); // seed random number generator
    
    fp = fopen("/Users/EntheoMac/Documents/School:NKU/Fall 2015/CSC 362-001 Computer Systems/Program3/Program3/board-out.txt", "wb"); // open file as write only
    
    p1 = board; // start players at beginning of board, index 0 of array
    p2 = board;
    
    while (p1 < board + 99 && p2 < board + 99) { // keep playing until one of the players lands beyond last board space, which is index 98
        printf("%-5s", "You:"); // p1 is "You"
        p1 = movePlayers(p1, p2, board); // call function to roll die, move player, and print appropriate output
        if (p1 < board + 99) { // re-check condition in middle of loop in case p1 won
            printf("%-5s", "Me:"); // p2 is "Me"
            p2 = movePlayers(p2, p1, board);
            output(board, p1, p2, fp); // outputs the current board to a file
        }
    }
    
    // print the final winner of the game
    if (p1 >= board + 99)
        printf("You win!\n"); 
    if (p2 >= board + 99)
        printf ("I win!\n");
    
    fclose(fp);
    
}
