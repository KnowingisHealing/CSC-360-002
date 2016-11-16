//
//  ViewController.swift
//  CSC416Assignment4
//
//  Created by James Slone on 10/19/16.
//  Copyright © 2016 James Slone. All rights reserved.
//

import UIKit
import SwiftyJSON

struct FakeLocation {
  let latitude:Double
  let longitude:Double
  init(lat: Double, lon: Double) {
    latitude = lat
    longitude = lon
  }
}

struct City { // struct that stores information about a given bike share
  let cityName:String
  let latitude:Double
  let longitude:Double
  let companyName:String
  let distanceTo:Optional<Double>
  init(city: String, lat: Double, long: Double, company: String, distance: Optional<Double>) {
    cityName = city
    latitude = lat
    longitude = long
    companyName = company
    distanceTo = distance
  }
}

class ViewController: UIViewController {
  
  @IBOutlet weak var setInput: UITextField!
  @IBOutlet weak var setButton: UIButton!
  @IBOutlet weak var sortName: UIButton!
  @IBOutlet weak var sortLocation: UIButton!
  @IBOutlet weak var cityList: UITextView!
  
  var bikeShares = [City]() // stores bike shares as an array of cities
  var user = FakeLocation(lat: 39.10138, lon: -84.51217)
  let utility = Utilities() // needed for access to Haversine function
  
  override func viewDidLoad() {
    super.viewDidLoad()
    
    let urlString = "https://api.citybik.es/v2/networks/" // pull JSON data from URL
    if let url = NSURL(string: urlString) {
      if let data = NSData(contentsOfURL: url) {
        let json = JSON(data: data)
        parse(json)
      }
    }
    
    bikeShares = bikeShares.sort({$0.cityName < $1.cityName})
    displayShares()
  }
  
  func parse(json: JSON) { // grab the required values from the JSON data
    for network in json["networks"].arrayValue {
      let city = network["location"]["city"].stringValue
      let lat = network["location"]["latitude"].doubleValue
      let long = network["location"]["longitude"].doubleValue
      let company = network["name"].stringValue
      let distance = utility.haversine(lat, lon1: long, lat2: user.latitude, lon2: user.longitude)
      let share = City(city: city, lat: lat, long: long, company: company, distance: distance)
      bikeShares.append(share)
    }
  }
  
  func displayShares() { // re-displays the list of bike shares, usually after a button is pressed
    var text = ""
    var numDisplay = bikeShares.count
    if setInput.text != "" && Int(setInput.text!) != nil {
      numDisplay = Int(setInput.text!)!
    }
    if numDisplay > 0 {
      for i in 0...numDisplay-1 {
        if i < bikeShares.count {
          text += "Company: \(bikeShares[i].companyName)\nCity: \(bikeShares[i].cityName)\n\n"
        }
      }
    }
    cityList.text = text
  }
  
  override func didReceiveMemoryWarning() {
    super.didReceiveMemoryWarning()
    // Dispose of any resources that can be recreated.
  }
  
  @IBAction func sortNamePressed(sender: AnyObject) { // sorts by name
    bikeShares = bikeShares.sort({$0.cityName < $1.cityName})
    displayShares()
  }
  
  @IBAction func sortLocationPressed(sender: AnyObject) { // sorts by location
    bikeShares = bikeShares.sort({$0.distanceTo < $1.distanceTo})
    displayShares()
  }
  
  @IBAction func setElementsPressed(sender: AnyObject) {
    displayShares()
  }
  
}


