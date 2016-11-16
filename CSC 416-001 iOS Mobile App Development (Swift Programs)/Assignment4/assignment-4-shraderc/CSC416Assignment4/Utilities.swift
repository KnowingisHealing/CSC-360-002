//
//  Utilities.swift
//  CSC416Assignment4
//
//  Created by James Slone on 10/19/16.
//  Copyright © 2016 James Slone. All rights reserved.
//

import Foundation

class Utilities {
    /**
     * Description: Finds the distance between 2 locations on a curved surface and returns the distance
     * Parameters: lat1 & lon1 -> is latitude & longitude for a city
     *             lat2 & lon2 -> is the same but for a different city
     */
    func haversine(lat1:Double, lon1:Double, lat2:Double, lon2:Double) -> Double {
        let lat1rad = lat1 * M_PI/180
        let lon1rad = lon1 * M_PI/180
        let lat2rad = lat2 * M_PI/180
        let lon2rad = lon2 * M_PI/180
        
        let dLat = lat2rad - lat1rad
        let dLon = lon2rad - lon1rad
        
        var a = sin(dLat/2) * sin(dLat/2)
        a = a + sin(dLon/2) * sin(dLon/2) * cos(lat1rad) * cos(lat2rad)
        
        let c = 2 * asin(sqrt(a))
        let R = 6372.8
        
        return R * c
    }
}