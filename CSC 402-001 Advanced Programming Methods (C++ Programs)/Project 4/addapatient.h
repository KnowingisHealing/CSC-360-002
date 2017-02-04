#ifndef ADDAPATIENT_H
#define ADDAPATIENT_H

#include <QDialog>
#include <vector>
#include <string>
#include "globals.h"
using namespace std;

namespace Ui {
class addapatient;
}

class addapatient : public QDialog
{
    Q_OBJECT

public:
    explicit addapatient(QWidget *parent = 0);
    ~addapatient();

private slots:
    void on_buttonBox_accepted();

    void on_pushButton_clicked();

private:
    Ui::addapatient *ui;
    vector<string> ailments;
};

#endif // ADDAPATIENT_H
