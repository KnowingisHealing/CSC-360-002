#ifndef PATIENT_H
#define PATIENT_H

#include <string>
#include <vector>
using namespace std;

class Patient {

public:

    Patient();

    Patient(string f, string m, string l, string s, vector<string> a, string d, bool t, int p) : firstName(f), middleName(m), lastName(l), suffix(s), ailments(a), doctor(d), treated(t), priority(p) {};

    virtual ~Patient();

    string toString();

    const string &getFirstName() const;

    void setFirstName(const string &firstName);

    const string &getMiddleName() const;

    void setMiddleName(const string &middleName);

    const string &getLastName() const;

    void setLastName(const string &lastName);

    const string &getSuffix() const;

    void setSuffix(const string &suffix);

    const vector<string> &getAilments() const;

    void setAilments(const vector<string> &ailments);

    void addAilment(const string &ailment);

    const string &getDoctor() const;

    void setDoctor(const string &doctor);

    bool isTreated() const;

    void setTreated(bool treated);

    int getPriority() const;

    void setPriority(int priority);

private:
    string firstName;
    string middleName;
    string lastName;
    string suffix;
    vector<string> ailments;
    string doctor;
    bool treated;
    int priority;
};

#endif // PATIENT_H
