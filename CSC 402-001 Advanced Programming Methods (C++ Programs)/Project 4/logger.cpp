#include "logger.h"
#include <iostream>
#include <fstream>
#include <ctime>

void Logger::log(const string s, const string filePath) {
    ofstream myfile;
    myfile.open(filePath, ios::app);
    time_t now = time(0);
    string dt = ctime(&now);
    myfile << dt + " " + s + "\n";
    myfile.close();
}

Logger* Logger::getLogger() {
    Logger *logger;
    return logger;
}

Logger::Logger() {

}

Logger::Logger(const Logger &) {

}
