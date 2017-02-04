cmake_minimum_required(VERSION 3.6)
project(shraderc1_project3)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp Patient.cpp Patient.h ERTools.cpp ERTools.h Logger.cpp)
add_executable(shraderc1_project3 ${SOURCE_FILES})