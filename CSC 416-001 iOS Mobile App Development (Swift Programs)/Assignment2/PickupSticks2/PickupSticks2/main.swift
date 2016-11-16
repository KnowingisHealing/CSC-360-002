//
//  main.swift
//  PickupSticks2
//
//  Created by Corey Shrader on 9/26/16.
//  Copyright © 2016 Corey Shrader. All rights reserved.
//
//  This program emulates a game of pick-up sticks, where a player and CPU take turns
//  grabbing 1-3 sticks from a table until the person who takes the last stick loses.

import Foundation

// function that sets the number of sticks on the table and plays the game, looping over each person's turn until there are no sticks left
public func play(withSticks: Int?, var playbook: Dictionary<Int, Array<Int>>) -> Dictionary<Int, Array<Int>>
{
    
    var table = withSticks // number of sticks on table
    
    var max = 3 // most sticks a person can take at once
    var currentPlays = Array<Array<Int>>() // contains the set of moves taken by the CPU this game
    
    // play until all sticks are gone
    while table > 0 {
        
        switch table! { // control how many sticks can be taken when there are only 1 or 2 left
        case 1:
            max = 1
        case 2:
            max = 2
        default:
            max = 3
        }
        
        print("How many sticks do you take (1-\(max))? ")
        
        var take = Int(readLine()!) // read move from player
        
        while take < 1 || take > max { // player must enter number in range or quit game
            print("Please enter a number from 1 to \(max). ")
            take = Int(readLine()!)
        }
        
        table = table! - take! // update sticks on table after move
        
        if table == 0 {
            print("You lose.")
            for play in currentPlays { // update the CPU's playbook so it learns from its success
                playbook[play[0]]?.append(play[1])
            }
            return playbook
        } else {
            print("There are \(table!) sticks on the board.")
        }
        
        let index = Int(arc4random_uniform(UInt32(playbook[table!]!.count))) // choose a random index to select from the CPU's playbook entry
        take = playbook[table!]![index] // for the current sticks on the board, play the CPU's random move
        
        print("CPU takes \(take!) sticks")
        
        currentPlays.append([table!, take!]) // add CPU's choice to current set of moves
        table = table! - take! // update sticks on table after move
        
        if table == 0 {
            print("You win!")
            for play in currentPlays { // update the CPU's playbook so it learns from its failure
                if playbook[play[0]]!.filter({item in return item == play[1]}).count > 1 {
                    for i in 0...playbook[play[0]]!.count {
                        if playbook[play[0]]![i] == play[1] {
                            playbook[play[0]]?.removeAtIndex(i)
                            break
                        }
                    }
                }
                
            }
        } else {
            print("There are \(table!) sticks on the board.")
        }
    }
    return playbook
}

var replay = true
var playbook = [Int : Array<Int>]()
playbook[1] = [1]
playbook[2] = [1, 2]
for sticks in 3...100 {
    playbook[sticks] = [1, 2, 3]
}

while replay {
    
    print("Welcome to the game of sticks! How many sticks are there on the table initially (10-100)? ")
    
    var table = Int(readLine()!)
    
    while table < 10 || table > 100 { // no exceptions- user must pick a number within the correct range or stop the game
        print("Please enter a number between 10 and 100. ")
        table = Int(readLine()!)
    }
    
    playbook = play(table!, playbook: playbook)
    
    print("Would you like to play again? (Y/N)")
    if !readLine()!.uppercaseString.containsString("Y") { // quit unless user inputs a "Y"
        replay = false
    }
    
}