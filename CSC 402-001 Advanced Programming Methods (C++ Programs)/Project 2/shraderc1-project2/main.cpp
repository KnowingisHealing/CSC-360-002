#include "IComparable.h"
#include "Integer.h"
#include "String.h"
#include <vector>
using namespace std;

vector<IComparable *> sortOO(vector<IComparable *> list) {
    for (int i = 0; i < list.size(); i++) {
        IComparable *o = list[i];
        int j = i - 1;
        while (j >= 0 && o->isLessThan(list[j])) {
            list[j + 1] = list[j];
            j--;
        }
        list[j + 1] = o;
    }

    return list;
}

template <typename Wrapper>
vector<Wrapper *> sortTemplate(vector<Wrapper *> list) {
    for (int i = 0; i < list.size(); i++) {
        Wrapper *o = list[i];
        int j = i - 1;
        while (j >= 0 && *o < *list[j]) {
            list[j + 1] = list[j];
            j--;
        }
        list[j + 1] = o;
    }

    return list;
}

bool verifyOO(vector<IComparable *> list) {
    for (int i = 1; i < list.size(); i++) {
        if (list[i]->isLessThan(list[i-1])) {
            return false;
        }
    }
    return true;
}

template <typename Wrapper>
bool verifyTemplate(vector<Wrapper *> list) {
    for (int i = 1; i < list.size(); i++) {
        if (*list[i] < *list[i-1]) {
            return false;
        }
    }
    return true;
}

string stringGen(int n) {
    string s;
    for (int i = 0; i < n; i++) {
        s += (char)(rand() % 25 + 97);
    }
    return s;
}

int main() {

    srand(time(NULL));

    for (int i = 100; i <= 100000; i = i * 10) {

        clock_t t = clock();
        for (int j = 0; j < 3; j++) {
            vector<IComparable *> intVector;
            for (int k = 0; k < i; k++) {
                intVector.push_back(new Integer(rand() % 1000));
            }
            intVector = sortOO(intVector);
        }
        t = clock() - t;
        cout << "OO sort Integer vector of " << i << " took " << (float)t/CLOCKS_PER_SEC << " seconds" << endl;

        t = clock();
        for (int j = 0; j < 3; j++) {
            vector<IComparable *> stringVector;
            for (int k = 0; k < i; k++) {
                stringVector.push_back(new String(stringGen(rand() % 4 + 1)));
            }
            stringVector = sortOO(stringVector);
        }
        t = clock() - t;
        cout << "OO sort of String vector of " << i << " took " << (float)t/CLOCKS_PER_SEC << " seconds" << endl;

        t = clock();
        for (int j = 0; j < 3; j++) {
            vector<Integer *> intVector;
            for (int k = 0; k < i; k++) {
                intVector.push_back(new Integer(rand() % 1000));
            }
            intVector = sortTemplate(intVector);
        }
        t = clock() - t;
        cout << "Template sort Integer vector of " << i << " took " << (float)t/CLOCKS_PER_SEC << " seconds" << endl;

        t = clock();
        for (int j = 0; j < 3; j++) {
            vector<String *> stringVector;
            for (int k = 0; k < i; k++) {
                stringVector.push_back(new String(stringGen(rand() % 3 + 1)));
            }
            stringVector = sortTemplate(stringVector);
        }
        t = clock() - t;
        cout << "Template sort of String vector of " << i << " took " << (float)t/CLOCKS_PER_SEC << " seconds" << endl;

    }

    return 0;
}