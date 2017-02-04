#ifndef ENTRY_H
#define ENTRY_H

#include <QDialog>
#include "globals.h"

namespace Ui {
class entry;
}

class entry : public QDialog
{
    Q_OBJECT

public:
    explicit entry(QWidget *parent = 0);
    void setType(int t);
    ~entry();

private slots:
    void on_buttonBox_rejected();

    void on_buttonBox_accepted();

private:
    Ui::entry *ui;
    int type;
};

#endif // ENTRY_H
