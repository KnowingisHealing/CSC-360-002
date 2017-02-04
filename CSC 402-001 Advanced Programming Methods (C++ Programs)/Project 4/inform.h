#ifndef INFORM_H
#define INFORM_H

#include <QDialog>

namespace Ui {
class inform;
}

class inform : public QDialog
{
    Q_OBJECT

public:
    explicit inform(QWidget *parent = 0);
    ~inform();

private slots:
    void on_pushButton_clicked();

private:
    Ui::inform *ui;
};

#endif // INFORM_H
