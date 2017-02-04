#ifndef LOGGER_H
#define LOGGER_H

#include <string>
#include <iostream>

using namespace std;

class Logger {

public:

    void log(const string s, const string filePath);
    static Logger* getLogger();

private:
    Logger();
    Logger(const Logger& l);
    static Logger *logger;
};


#endif //LOGGER_H
