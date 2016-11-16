//
// Created by Corey Shrader on 9/13/16.
//
// This is the implementation of the Student class.

#include "Student.h"
#include "Logger.h"

int Student::idCount = 0; // used to auto-generate unique student ID's

Student::Student() : id( ++idCount ){
}

Student::Student( string n, vector<int> m) : id( ++idCount ), name( n ), marks( m ){
    for (int i = 0; i < marks.size(); i++) {
        if (marks[i] < 0)
            marks[i] = 0;
        if (marks[i] > 100)
            marks[i] = 100;
    }
}

Student::~Student() {
}

Student::Student(const Student& rhs) : id(rhs.id), name(rhs.name), marks(rhs.marks){
}

const Student& Student::operator=(const Student &rhs) {
    if (this != &rhs ) {   // standard alias test
        id = rhs.id;
        name = rhs.name;
        marks = rhs.marks;
    }
    return *this;
}

int Student::calculateGrade() { // calculates average grade

    int sum = 0;

    for (int i = 0; i < marks.size(); i++) {
        sum += marks[i];
    }

    Logger::getInstance().log( to_string(sum / marks.size()) );
    return (int) (sum / marks.size());
}

string Student::calculateLetterGrade() { // uses standard ranges to calculate letter grade

    int grade = calculateGrade();
    string letterGrade;

    if (grade < 60)
        letterGrade = "F";
    else if (grade < 67)
        letterGrade = "D";
    else if (grade < 70)
        letterGrade = "D+";
    else if (grade < 73)
        letterGrade = "C-";
    else if (grade < 77)
        letterGrade = "C";
    else if (grade < 80)
        letterGrade = "C+";
    else if (grade < 83)
        letterGrade = "B-";
    else if (grade < 87)
        letterGrade = "B";
    else if (grade < 90)
        letterGrade = "B+";
    else if (grade < 93)
        letterGrade = "A-";
    else
        letterGrade = "A";

    Logger::getInstance().log(letterGrade);
    return letterGrade;
}

string Student::printReport() { // reports grades, average grade, and letter grade

    string report = "Your grades are: ";
    for (int i = 0; i < marks.size(); i++)
        report += to_string(marks[i]) + ", ";
    report += "\nYour average grade is: " + to_string(calculateGrade());
    report += "\nYour letter grade is: " + calculateLetterGrade();

    Logger::getInstance().log(report);
    return report;

}

int Student::getId() const {
    Logger::getInstance().log(to_string(id));
    return id;
}

string Student::getName() const {
    Logger::getInstance().log(name);
    return name;
}

void Student::setName(string name) {
    Logger::getInstance().log(name);
    Student::name = name;
}

vector<int> Student::getMarks() const {
    for (int i = 0; i < marks.size(); i++) {
        Logger::getInstance().log(to_string(marks[i]) + ", ");
    }
    return marks;
}

void Student::setMarks(vector<int> marks) {
    for (int i = 0; i < marks.size(); i++) {
        Logger::getInstance().log(to_string(marks[i]) + ", ");
    }
    Student::marks = marks;
}