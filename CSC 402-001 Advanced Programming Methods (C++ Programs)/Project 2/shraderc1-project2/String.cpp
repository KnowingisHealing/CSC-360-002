//
// Created by Corey Shrader on 10/2/16.
//

#include "String.h"

String::String(string s) {
    String::s = s;
}

string String::getString() {
    return String::s;
}

void String::setString(string s) {
    String::s = s;
}

bool String::isLessThan(IComparable *s) {

    return String::s < dynamic_cast<String*>(s)->getString();
}

bool String::operator<(String &rhs) {
    return String::s < rhs.getString();
}