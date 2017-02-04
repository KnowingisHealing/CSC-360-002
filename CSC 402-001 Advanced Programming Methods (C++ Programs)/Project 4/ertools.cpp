#include "ertools.h"
#include <algorithm>
#include "Logger.h"
#include <chrono>
#include <thread>

using namespace std;

ERTools::ERTools() {}

void ERTools::addPatient(Patient p) {

    p.isTreated() ? treatedPatients.push_back(p) : untreatedPatients.push(p);
    Logger::getLogger()->log("Patient added\n", logFilePath);
}

void ERTools::treatPatient() {

    if (!untreatedPatients.empty()) {

        Patient p = untreatedPatients.top();
        untreatedPatients.pop();
        p.setTreated(1);
        treatedPatients.push_back(p);
    }

    Logger::getLogger()->log("Patient treated\n", logFilePath);
    int x = rand() % 3 + 1;
    std::this_thread::sleep_for(std::chrono::milliseconds(x));
}

string ERTools::printPatient(string f, string l) { // prints all a patient's info given a first and last name

    priority_queue<Patient, vector<Patient>, Order> untreatedCopy = priority_queue<Patient, vector<Patient>, Order>(untreatedPatients);

    Patient p;
    string s = "";

    while (!untreatedCopy.empty()){
        p = untreatedCopy.top();
        if (p.getFirstName() == f && p.getLastName() == l) {
            s += p.toString();
        }
        untreatedCopy.pop();
    }

    vector<Patient>::iterator iter;
    for (iter = treatedPatients.begin(); iter != treatedPatients.end(); ++iter) {
        p = *iter;
        if (p.getFirstName() == f && p.getLastName() == l)
            s += p.toString();
    }

    Logger::getLogger()->log("Printed a patient's report.\n", logFilePath);
    return s;
}

string ERTools::printTreated() {

    Patient p;
    string s = "";
    vector<Patient>::iterator iter;
    for (iter = treatedPatients.begin(); iter != treatedPatients.end(); ++iter) {
        p = *iter;
        s += p.toString();
    }

    Logger::getLogger()->log("Printed a list of treated patients.\n", logFilePath);
    return s;
}

string ERTools::viewNextPatient() {

    string s = "";

    if (!untreatedPatients.empty()) {
    Patient p = untreatedPatients.top();
    s += p.toString();
    }
    else {
        s = "All patients have been treated!";
    }

    Logger::getLogger()->log("Printed next patient to be treated\n", logFilePath);
    return s;
}

string ERTools::printAll() {
    priority_queue<Patient, vector<Patient>, Order> untreatedCopy = priority_queue<Patient, vector<Patient>, Order>(
            untreatedPatients);

    Patient p;
    string s = "";

    while (!untreatedCopy.empty()) {
        p = untreatedCopy.top();
        s += p.toString();
        untreatedCopy.pop();
    }

    vector<Patient>::iterator iter;
    for (iter = treatedPatients.begin(); iter != treatedPatients.end(); ++iter) {
        p = *iter;
        s += p.toString();
    }

    Logger::getLogger()->log("Printed all patients. \n", logFilePath);

    return s;
}

void ERTools::treatAll() {
    while (!untreatedPatients.empty()){
        Patient p = untreatedPatients.top();
        untreatedPatients.pop();
        p.setTreated(1);
        treatedPatients.push_back(p);
    }

    Logger::getLogger()->log("All patients treated. \n", logFilePath);
    int x = rand() % 3 + 1;
    std::this_thread::sleep_for(std::chrono::milliseconds(x));
}

string ERTools::printByDoctor() {

    vector<Patient> allPatients;
    priority_queue<Patient, vector<Patient>, Order> untreatedCopy = priority_queue<Patient, vector<Patient>, Order>(untreatedPatients);
    Patient p;
    string s = "";

    while (!untreatedCopy.empty()) {
        allPatients.push_back(untreatedCopy.top());
        untreatedCopy.pop();
    }

    vector<Patient>::iterator iter;
    for (iter = treatedPatients.begin(); iter != treatedPatients.end(); ++iter) {
        p = *iter;
        allPatients.push_back(p);
    }

    sort(allPatients.begin(), allPatients.end(), OrderByDoctor());

    for (iter = allPatients.begin(); iter != allPatients.end(); ++iter) {
        p = *iter;
        s += p.toString();
    }

    Logger::getLogger()->log("Printed patients by doctor. \n", logFilePath);
    return s;
}

void ERTools::addFromFile(string filePath) { // adds patients to system given a properly formatted file

    ifstream file(filePath);

    if (file.is_open()) {

        string line;
        Patient p;

        while (getline(file, line)) {

            if (line == "") {
                if (p.isTreated())
                    treatedPatients.push_back(p);
                else {
                    untreatedPatients.push(p);
                }
                p = Patient();
            }

            istringstream str(line);
            string token;
            string key;
            int i = 0;

            while (getline(str, token, ':')) {
                if (i == 0) {
                    key = token;
                } else {
                    if (key == "firstName")
                        p.setFirstName(token);
                    else if (key == "middleName")
                        p.setMiddleName(token);
                    else if (key == "lastName")
                        p.setLastName(token);
                    else if (key == "suffix")
                        p.setSuffix(token);
                    else if (key == "ailment")
                        p.addAilment(token);
                    else if (key == "doctor")
                        p.setDoctor(token);
                    else if (key == "treated")
                        p.setTreated(stoi(token));
                    else if (key == "priority")
                        p.setPriority(stoi(token));
                }
                i++;
            }
        }
        file.close();
        (p.isTreated()) ? treatedPatients.push_back(p) : untreatedPatients.push(p);
    }
    else
        cout << "Unable to open file" << endl;

    Logger::getLogger()->log("Added patients from file\n", logFilePath);
}

void ERTools::setLogFilePath(const string &logFilePath) {
    ERTools::logFilePath = logFilePath;
}
