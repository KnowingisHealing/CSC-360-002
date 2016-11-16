//
// Created by Corey Shrader on 10/2/16.
//

#ifndef SHRADERC1_PROJECT2_INTEGER_H
#define SHRADERC1_PROJECT2_INTEGER_H

#include "IComparable.h"

class Integer : public IComparable {
public:
    Integer(int i);
    int getInt();
    void setInt(int i);
    bool isLessThan(IComparable *o);
    bool operator<(Integer &rhs);
private:
    int i;
};


#endif //SHRADERC1_PROJECT2_INTEGER_H