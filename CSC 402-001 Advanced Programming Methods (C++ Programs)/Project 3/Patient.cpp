//
// Created by Corey Shrader on 11/14/16.
//

#include "Patient.h"

string Patient::toString() {
    string ps = "First Name: " + firstName +
            "\nMiddle name: " + middleName +
            "\nLast Name: " + lastName +
            "\nSuffix: " + suffix +
           "\nAilments: ";
    vector<string>::iterator iter;
    for (iter = ailments.begin(); iter != ailments.end(); ++iter) {
       ps += *iter + ", ";
    }
    ps += "\nDoctor: " + doctor +
          "\nTreated: " + ((treated) ? "yes" : "no") +
            "\nPriority: " + to_string(priority) + "\n";

    return ps;
}

const string &Patient::getFirstName() const {
    return firstName;
}

void Patient::setFirstName(const string &firstName) {
    Patient::firstName = firstName;
}

const string &Patient::getMiddleName() const {
    return middleName;
}

void Patient::setMiddleName(const string &middleName) {
    Patient::middleName = middleName;
}

const string &Patient::getLastName() const {
    return lastName;
}

void Patient::setLastName(const string &lastName) {
    Patient::lastName = lastName;
}

const string &Patient::getSuffix() const {
    return suffix;
}

void Patient::setSuffix(const string &suffix) {
    Patient::suffix = suffix;
}

const vector<string> &Patient::getAilments() const {
    return ailments;
}

void Patient::setAilments(const vector<string> &ailments) {
    Patient::ailments = ailments;
}

void Patient::addAilment(const string &ailment) {
    Patient::ailments.push_back(ailment);
}


const string &Patient::getDoctor() const {
    return doctor;
}

void Patient::setDoctor(const string &doctor) {
    Patient::doctor = doctor;
}

bool Patient::isTreated() const {
    return treated;
}

void Patient::setTreated(bool treated) {
    Patient::treated = treated;
}

int Patient::getPriority() const {
    return priority;
}

void Patient::setPriority(int priority) {
    Patient::priority = priority;
}

Patient::~Patient() {

}

Patient::Patient() {}

