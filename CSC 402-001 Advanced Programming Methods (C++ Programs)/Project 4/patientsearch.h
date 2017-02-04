#ifndef PATIENTSEARCH_H
#define PATIENTSEARCH_H

#include <QDialog>
#include "display.h"
#include "globals.h"

namespace Ui {
class patientSearch;
}

class patientSearch : public QDialog
{
    Q_OBJECT

public:
    explicit patientSearch(QWidget *parent = 0);
    ~patientSearch();

private slots:
    void on_buttonBox_accepted();

private:
    Ui::patientSearch *ui;
    display d;
};

#endif // PATIENTSEARCH_H
