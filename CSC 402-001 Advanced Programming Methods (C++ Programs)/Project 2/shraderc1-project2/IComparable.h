//
// Created by Corey Shrader on 10/2/16.
//

#ifndef SHRADERC1_PROJECT2_ICOMPARABLE_H
#define SHRADERC1_PROJECT2_ICOMPARABLE_H


class IComparable {
public:
    virtual bool isLessThan(IComparable *o) = 0;

};

#endif //SHRADERC1_PROJECT2_ICOMPARABLE_H