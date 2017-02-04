#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "addapatient.h"
#include "display.h"
#include "entry.h"
#include "inform.h"
#include "ertools.h"
#include "patientsearch.h"
#include "globals.h"

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private slots:
    void on_addPatient_clicked();

    void on_viewNext_clicked();

    void on_printAll_clicked();

    void on_printPatient_clicked();

    void on_printByDoctor_clicked();

    void on_printTreated_clicked();

    void on_addPatients_clicked();

    void on_treatPatient_clicked();

    void on_treatAll_clicked();

    void on_setLogFile_clicked();

private:
    Ui::MainWindow *ui;
    addapatient a;
    display d;
    entry e;
    inform i;
    patientSearch p;
};

#endif // MAINWINDOW_H
