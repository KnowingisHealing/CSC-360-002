cmake_minimum_required(VERSION 3.6)
project(shraderc1_project2)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp IComparable.h Integer.cpp Integer.h String.cpp String.h)
add_executable(shraderc1_project2 ${SOURCE_FILES})