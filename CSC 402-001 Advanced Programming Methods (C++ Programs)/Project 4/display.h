#ifndef DISPLAY_H
#define DISPLAY_H

#include <QDialog>
#include <string>
#include "globals.h"
using namespace std;

namespace Ui {
class display;
}

class display : public QDialog
{
    Q_OBJECT

public:
    explicit display(QWidget *parent = 0);
    int getType();
    void setType(const int &t);
    void setPatient(string s, string l);
    ~display();

private slots:
    void on_close_clicked();

private:
    Ui::display *ui;
    int type;
};

#endif // DISPLAY_H
