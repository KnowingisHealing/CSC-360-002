//
// Created by Corey Shrader on 9/13/16.
//
// This is the definition of the Student class.

#ifndef SHRADERC1_PROJECT1_STUDENT_H
#define SHRADERC1_PROJECT1_STUDENT_H

#include <string>
#include <vector>
using namespace std;

class Student {
public:
    Student();
    Student( string n, vector<int> m);
    ~Student();
    Student(const Student& rhs);
    const Student& operator=(const Student& rhs);
    int calculateGrade();
    string calculateLetterGrade();
    string printReport();
    int getId() const;
    string getName() const;
    void setName(string name);
    vector<int> getMarks() const;
    void setMarks(vector<int> marks);
private:
    int id;
    static int idCount;
    string name;
    vector<int> marks;
};

#endif //SHRADERC1_PROJECT1_STUDENT_H