//
// Created by Corey Shrader on 11/16/16.
//

#ifndef SHRADERC1_PROJECT3_ERTOOLS_H
#define SHRADERC1_PROJECT3_ERTOOLS_H
#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <sstream>
#include <queue>
#include "Patient.h"
using namespace std;

struct Order {
    bool operator() (Patient const &p1, Patient const &p2) { return p1.getPriority() > p2.getPriority();
    }
};

struct OrderByDoctor {
    bool operator() (Patient const &p1, Patient const &p2) { return p1.getDoctor() < p2.getDoctor();
    }
};

class ERTools {
public:
    ERTools();
    void addPatient(Patient p);
    void treatPatient();
    void printPatient(string f, string l);
    void printTreated();
    void viewNextPatient();
    void printAll();
    void treatAll();
    void printByDoctor();
    void addFromFile(string filePath);

private:
    priority_queue<Patient, vector<Patient>, Order> untreatedPatients;
    vector<Patient> treatedPatients;
    string logFilePath;
public:
    void setLogFilePath(const string &logFilePath);
};


#endif //SHRADERC1_PROJECT3_ERTOOLS_H
