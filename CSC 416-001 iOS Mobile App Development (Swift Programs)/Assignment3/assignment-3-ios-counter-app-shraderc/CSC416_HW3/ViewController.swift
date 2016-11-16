//
//  ViewController.swift
//  CSC416_HW3
//
//  Created by Brian Konzman on 9/22/16.
//  Copyright © 2016 Northern Kentucky University. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var bottomButton: UIButton!
    @IBOutlet weak var topButton: UIButton!
    @IBOutlet weak var pressedLabel: UILabel!
    var top = 0
    var bottom = 0
    
  override func viewDidLoad() {
    super.viewDidLoad()
    // Do any additional setup after loading the view, typically from a nib.
  }

  override func didReceiveMemoryWarning() {
    super.didReceiveMemoryWarning()
    // Dispose of any resources that can be recreated.
  }

    @IBAction func buttonPressed(sender: AnyObject) {
    
        if topButton.touchInside {
            top = top + 1
        }
        if bottomButton.touchInside {
            bottom = bottom + 1
        }
        pressedLabel.text = "Top button pressed \(top) times.\nBottom button pressed \(bottom) times."
    
    }

}

