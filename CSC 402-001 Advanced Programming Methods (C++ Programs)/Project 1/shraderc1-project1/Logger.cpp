//
// Created by Corey Shrader on 9/13/16.
//
// This is the implementation of the Logger class.

#include "Logger.h"
#include <iostream>
using namespace std;

Logger::Logger() {
}

Logger& Logger::getInstance() {
    static Logger instance;
    return instance;
}

void Logger::log(string output) {
   cout << output << endl;
}