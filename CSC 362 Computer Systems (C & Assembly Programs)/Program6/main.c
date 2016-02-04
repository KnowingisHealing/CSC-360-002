//  Corey Shrader
//  Dr. Fox / CSC 362-001
//  Program 6
//  12/3/15
//
//  This program uses a "first fit" strategy to place a collection of various weighted items into a group of bins of equal capacity.
//  We pick an item, start with the first bin, and look through each consecutive bin until we find one that can hold the item.
//  Items are placed inside the bins in alphabetical order by name.
//  The strategy is implemented using "bin" structs, each with its own linked list of "node" structs for the items.

#include <stdio.h>
#include <stdlib.h>

// struct declarations

struct node {
    char *name; // name of item
    double size; // weight of item
    struct node *next; // next item in bin
};

struct bin {
    double cap; // capacity of bin
    struct node *nodes; // front of linked list of items in bin
};

// prototypes for functions

struct bin *insert(struct bin*, struct node*); // inserts a new node into a bin in alphabetical order
void print(struct bin*); // prints the bin's capacity and its items/weights
void destroy(struct bin*); // deallocates all the nodes of a bin

void main() {
    
    // names of various items to be placed in bins
    
    char *items[8] = {"Vase", "Bowling-ball", "Book", "Umbrella", "Gold-medal", "Speaker-1", "Walkman", "Speaker-2"};
    //char *items[20] = {"Small-dog", "Moose-skull", "Squirrel", "Mouse", "Goldfish", "Snake", "Human-finger", "Pig-head", "Eagle-feather", "Shark-teeth", "Camel-hump", "Crocodile", "Elephant-tusk", "Cat", "Horse-manure", "Monkey-hand", "Octopus-eye", "Sheep-coat", "Bat", "Chicken-wing"};
    //char *items[18] = {"Operating-Systems", "Computer-Graphics", "The-History-of-the-Universe", "Discrete-Mathematics", "Statistics", "English-for-Dummies", "American-History 2000-", "Computer-Architecture", "C-Programming", "Hitchhiker’s-Guide", "English-Minbari-Dictionary", "Zen-and-the-Art-of-Programming", "The-Joy-of-Cooking", "Cincinnati-Yellow-Pages", "Artificia-Intelligence", "Business-Programming:-Why?", "Heart-of-Darkness", "The-History-of-the-Ohio-State-Buckeyes"};
    
    // weights corresponding to each item to be placed in bins
    
    double weights[8] = {.5, .9, .3, .4, .7, .4, .2, .4};
    //double weights[20] = {.63, .25, .41, .15, .06, .52, .09, .39, .02, .11, .24, .94, .63, .28, .04, .21, .05, .33, .42, .12};
    //double weights[18] = {.75, .62, .27, .78, .41, .55, .20, .90, .21, .23, .42, .33, .56, .98, .32, .12, .21, .82};
    
    struct bin *bins[20]; // array of bins
    struct node *node; // used to place an item into a bin
    int i = 0, b = 0, count = 0; // for iterating through objects, bins, and # of bins used
    
    // initialize all bins' capacities to 1.0 and lists of nodes to NULL
    for (b = 0; b < 20; b++) {
        bins[b]= (struct bin *)malloc(sizeof(struct bin));
        bins[b]->cap = 1.0;
        bins[b]->nodes = NULL;
    }
    
    // for each item, i, to be placed in a bin
    for (i = 0; i < 8; i++) {
        
        // while item is not placed in a bin, iterate through each bin
        b = 0;
        while (bins[b]->cap - weights[i] < 0) // look for a bin that can hold the current item
            b++;
        
        // then create a node for the item, filling in its name and size
        node = (struct node *)malloc(sizeof(struct node));
        node->name = items[i];
        node->size = weights[i];
        
        // insert this node into bin (in sorted order)
        bins[b] = insert(bins[b],node);
        
        //and modify the bin's capacity
        bins[b]->cap -= weights[i];
        
    }
    
    for (b = 0; b < 20; b++) { // iterate through used bins to print data for each
        if (bins[b]->nodes != NULL) {
            printf("Bin %d ", b+1);
            print(bins[b]);
            count++; // keeps track of number of bins used
        }
    }
    
    
    printf("%d bins were used.\n", count); // print number of bins used
    
}

struct bin *insert(struct bin *bin, struct node *node) { // inserts an item into a bin in alphabetical order
    
    struct node *temp, *current, *previous; // used for iterating through node list
    int i; // used for comparing each character of an item's name
    
    if (bin->nodes == NULL) // if there's no item in bin already, just place it there
        bin->nodes = node;
    else if (bin->nodes->name[0] >= node->name[0]) { // if the item to be placed has a name that goes before the current first item, just place it in front
        if (bin->nodes->name[0] == node->name[0]) { // if both first letters are the same, compare consecutive letters
            i = 0;
            while (bin->nodes->name[i] == node->name[i])
                i++;
            if (bin->nodes->name[i] > node->name[i]) { // if our item does indeed go first, make the insert
                node->next = bin->nodes;;
                bin->nodes = node;
            }
        }
        else { // used if priority is found on first letter
            //temp = bin->nodes;
            node->next = bin->nodes;;
            bin->nodes = node;
            
        }
    }
    else {  // otherwise, move through items until we find the proper place
        current = bin->nodes;
        // move until reaching name that goes before ours or end of list
        while (current != NULL && current->name[0] <= node->name[0]) {
            // if first letters are equal, check consecutive letters
            if (current->name[0] == node->name[0]) {
                i = 0;
                while (current->name[i] == node->name[i])
                    i++;
                if (current->name[i] > node->name[i]) // leave loop if our item should go before the current
                    break;
            }
            previous = current;
            current = current->next;
        }
        previous->next = node; // previous is the node that should go before ours
        node->next = current; // current is the node that should go after ours
    }
    
    return bin;
}

void print(struct bin *bin) { // prints current capacity and list of items in bin
    
    printf("(%.2f left): ", bin->cap);
    while (bin->nodes != NULL) {
        printf("%s (%.2f)  ", bin->nodes->name, bin->nodes->size);
        bin->nodes = bin->nodes->next;
    }
    printf("\n");
    
}

void destroy(struct bin *bin) { // deallocates memory for each item in a bin
    
    struct node *temp; // points to current node to be deallocated
    
    while (bin->nodes != NULL) { // move until end of list
        temp = bin->nodes; // temporarily point to current node
        bin->nodes = bin->nodes->next; // move "current" node to next node
        free(temp); // delete current node
    }
    
}


