//
// Created by Corey Shrader on 9/13/16.
//
// This is a program which tests a Student class using a singleton to log the tests.

#include "Student.h"
#include <iostream>
using namespace std;

int main() {

    Student harambe("Harambe", vector<int> {70, 80, 90});
    Student shamu("Shamu", vector<int> {-8, 88 , 99, 102});

    //Test #1- tests the getters of the students:
    cout << "\nTest 1\n" << endl;

    harambe.getId();
    harambe.getName();
    harambe.getMarks();
    shamu.getId();
    shamu.getName();
    shamu.getMarks();

    //Test #2- tests the grade calculations of each student:
    cout << "\nTest 2\n" << endl;

    harambe.calculateGrade();
    harambe.calculateLetterGrade();
    shamu.calculateGrade();
    shamu.calculateLetterGrade();

    //Test #3- tests the report printer for each student:
    cout << "\nTest 3\n" << endl;

    harambe.printReport();
    shamu.printReport();

    //Test #4- tests the operator overload:
    cout << "\nTest 4\n" << endl;

    shamu = harambe; // shamu should now have all of harambe's data
    shamu.printReport(); // makes sure shamu's report has harambe's data

    //Test #5- tests the copy constructor:
    cout << "\nTest 5\n" << endl;

    Student cecil(harambe);
    cecil.printReport(); // makes sure Cecil has the same data

    // Test #6- tests setters
    cout << "\nTest 6\n" << endl;

    cecil.setName("Cecil the Lion");
    cecil.setMarks(vector<int> {55, 98, 67});

    return 0;
}