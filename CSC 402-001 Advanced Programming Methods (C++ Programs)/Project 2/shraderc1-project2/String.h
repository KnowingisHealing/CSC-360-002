//
// Created by Corey Shrader on 10/2/16.
//

#ifndef SHRADERC1_PROJECT2_STRING_H
#define SHRADERC1_PROJECT2_STRING_H
#include <iostream>
using namespace std;

#include "IComparable.h"

class String : public IComparable {
public:
    String(string s);
    string getString();
    void setString(string s);
    bool isLessThan(IComparable *s);
    bool operator<(String &rhs);
private:
    string s;
};


#endif //SHRADERC1_PROJECT2_STRING_H