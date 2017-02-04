#ifndef ERTOOLS_H
#define ERTOOLS_H
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

class ERTools
{
public:
    ERTools();
    void addPatient(Patient p);
    void treatPatient();
    string printPatient(string f, string l);
    string printTreated();
    string viewNextPatient();
    string printAll();
    void treatAll();
    string printByDoctor();
    void addFromFile(string filePath);

private:
    priority_queue<Patient, vector<Patient>, Order> untreatedPatients;
    vector<Patient> treatedPatients;
    string logFilePath;
public:
    void setLogFilePath(const string &logFilePath);
};

#endif // ERTOOLS_H
