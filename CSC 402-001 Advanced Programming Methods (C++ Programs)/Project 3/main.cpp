//
// Created by Corey Shrader on 11/16/16.
//

#include <iostream>
#include <vector>
#include <sstream>
#include <queue>
#include "Patient.h"
#include "ERTools.h"
using namespace std;

/* These are the file paths I used for my log file and patients file. I'm allowing the user to input their own.
/Users/EntheoMac/Documents/School&NKU/Fall 2016/CSC 402-001 Advanced Programming Methods/Projects/Project 3/shraderc1-project3/log.txt
/Users/EntheoMac/Documents/School&NKU/Fall 2016/CSC 402-001 Advanced Programming Methods/Projects/Project 3/shraderc1-project3/patients.txt
 */

int main() {

    ERTools hospital = ERTools();
    string response = "";
    string path;

    cout << "Enter a path for the log file. A new file will be created if none exists. (Ex. MyDirectory/log.txt):\n";
    if ( cin.peek() == '\n' )
        cin.ignore();
    getline(cin, path);
    hospital.setLogFilePath(path);

    string options = "1- Add a patient"
    "\n2- Treat a patient"
    "\n3- Print a patient's info"
    "\n4- Print a report of treated patients"
    "\n5- View the next patient to be treated"
    "\n6- Print out a report of all patients in triage"
    "\n7- Treat all patients"
    "\n8- Print out patients by doctor"
    "\n9- Add patients from a file\n";

    cout << "Hello, welcome to the hospital triage system! What would you like to do today:?\n" + options;
    cin >> response;
    int action;
    do {
        if ( ! (istringstream(response) >> action) ) action = 0;

        switch (action) {
            case 1 : {
                Patient p = Patient();
                string val;
                cout << "First name? ";
                cin >> val;
                p.setFirstName(val);
                cout << "Middle name? ";
                cin >> val;
                p.setMiddleName(val);
                cout << "Last name? ";
                cin >> val;
                p.setLastName(val);
                cout << "Suffix? ";
                cin >> val;
                p.setSuffix(val);
                cout << "First ailment?";
                cin >> val;
                while (val != "0") {
                    p.addAilment(val);
                    cout << "Another ailment? 0 to quit.";
                    cin >> val;
                }
                cout << "Doctor?";
                cin >> val;
                p.setDoctor(val);
                cout << "Have they been treated?";
                cin >> val;
                int intVal;
                if (!(istringstream(val) >> intVal)) intVal = 0;
                p.setTreated(intVal);
                cout << "Priority?";
                cin >> val;
                if (!(istringstream(val) >> intVal)) intVal = 0;
                p.setPriority(intVal);
                hospital.addPatient(p);
                break;
            }
            case 2 : {
                hospital.treatPatient();
                break;
            }
            case 3 : {
                string f;
                string l;
                cout << "First name?";
                cin >> f;
                cout << "Last name?";
                cin >> l;
                hospital.printPatient(f, l);
                break;
            }
            case 4 : {
                hospital.printTreated();
                break;
            }
            case 5 : {
                hospital.viewNextPatient();
                break;
            }
            case 6 : {
                hospital.printAll();
                break;
            }
            case 7 : {
                hospital.treatAll();
                break;
            }
            case 8 : {
                hospital.printByDoctor();
                break;
            }
            case 9 : {
                cout << "Enter a file path\n";
                if ( cin.peek() == '\n' )
                    cin.ignore();
                std::getline(cin, path);
                hospital.addFromFile(path);
                break;
            }
            default : {
                cout << "Sorry, invalid option" << endl;
                return 0;
            }
        }
        cout << "What's next? Type 'help' to see your options again. Type 0 to quit.\n";
        cin >> response;
        if (response == "help") {
            cout << options;
            cin >> response;
        }

        if ( ! (istringstream(response) >> action) ) action = 0;
    } while (action != 0);

    return 0;
}