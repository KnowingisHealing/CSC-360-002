//
//  main.swift
//  PickupSticks
//
//  Created by Corey Shrader on 9/11/16.
//  Copyright © 2016 Corey Shrader. All rights reserved.
//
//  This program emulates a game of pick-up sticks, where two players take turns
//  grabbing 1-3 sticks from a table until the person who takes the last stick loses.

import Foundation

// function that sets the number of sticks on the table and plays the game, looping over each person's turn until there are no sticks left
public func play(withSticks: Int?) {
    
    var table = withSticks // number of sticks on table
    
    var max = 3 // most sticks a person can take at once
    
    // play until all sticks are gone
    while table > 0 {
        
        for i in 1...2 {
            
            if table > 0 {
                
                switch table! { // control how many sticks can be taken when there are only 1 or 2 left
                case 1:
                    max = 1
                case 2:
                    max = 2
                default:
                    max = 3
                }
                
                print("Player \(i): How many sticks do you take (1-\(max))? ")
                
                var take = Int(readLine()!)
                
                while take < 1 || take > max {
                    print("Please enter a number from 1 to \(max). ")
                    take = Int(readLine()!)
                }
                
                table = table! - take! // update sticks on table
                
                if table == 0 {
                    print("Player \(i), you lose.")
                } else {
                    print("There are \(table!) sticks on the board.")
                }
            }
        }
    }
}

print("Welcome to the game of sticks! How many sticks are there on the table initially (10-100)? ")

var table = Int(readLine()!)

while table < 10 || table > 100 { // no exceptions- user must pick a number within the correct range or stop the game
    print("Please enter a number between 10 and 100. ")
    table = Int(readLine()!)
}

play(table!)
