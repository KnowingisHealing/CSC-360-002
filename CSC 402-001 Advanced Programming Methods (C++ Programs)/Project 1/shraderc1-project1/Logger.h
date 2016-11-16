//
// Created by Corey Shrader on 9/13/16.
//
// This is the definition of the Logger class, a Singleton.

#ifndef SHRADERC1_PROJECT1_LOGGER_H
#define SHRADERC1_PROJECT1_LOGGER_H

#include <string>
using namespace std;

class Logger {
private:
    Logger();
    Logger(Logger const& copy);
    Logger& operator=(Logger const& copy);
public:
    static Logger& getInstance();
    void log(string output);
};

#endif //SHRADERC1_PROJECT1_LOGGER_H