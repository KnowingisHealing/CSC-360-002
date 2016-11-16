//
// Created by Corey Shrader on 10/2/16.
//

#include "Integer.h"

Integer::Integer(int i) {
    Integer::i = i;
}

int Integer::getInt() {
    return i;
}

void Integer::setInt(int i) {
    Integer::i = i;
}

bool Integer::isLessThan(IComparable *i) {

    return Integer::i < dynamic_cast<Integer* >(i)->getInt();
}

bool Integer::operator<(Integer &rhs) {
    return Integer::i < rhs.getInt();
}