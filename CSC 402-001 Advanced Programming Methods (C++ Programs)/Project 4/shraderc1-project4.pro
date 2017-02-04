#-------------------------------------------------
#
# Project created by QtCreator 2016-12-14T16:15:46
#
#-------------------------------------------------

QT       += core gui

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = shraderc1-project4
TEMPLATE = app

# The following define makes your compiler emit warnings if you use
# any feature of Qt which as been marked as deprecated (the exact warnings
# depend on your compiler). Please consult the documentation of the
# deprecated API in order to know how to port your code away from it.
DEFINES += QT_DEPRECATED_WARNINGS

# You can also make your code fail to compile if you use deprecated APIs.
# In order to do so, uncomment the following line.
# You can also select to disable deprecated APIs only up to a certain version of Qt.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0


SOURCES += main.cpp\
        mainwindow.cpp \
    ertools.cpp \
    logger.cpp \
    patient.cpp \
    addapatient.cpp \
    display.cpp \
    entry.cpp \
    inform.cpp \
    globals.cpp \
    patientsearch.cpp

HEADERS  += mainwindow.h \
    ../../Project 3/shraderc1-project3/ERTools.h \
    ../../Project 3/shraderc1-project3/Logger.h \
    ../../Project 3/shraderc1-project3/Patient.h \
    ertools.h \
    logger.h \
    patient.h \
    addapatient.h \
    display.h \
    entry.h \
    inform.h \
    globals.h \
    patientsearch.h

FORMS    += mainwindow.ui \
    addapatient.ui \
    display.ui \
    entry.ui \
    inform.ui \
    patientsearch.ui
