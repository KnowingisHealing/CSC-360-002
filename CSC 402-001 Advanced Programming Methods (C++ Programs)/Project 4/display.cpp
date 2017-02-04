#include "display.h"
#include "ui_display.h"

display::display(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::display)
{
    ui->setupUi(this);
}

display::~display()
{
    delete ui;
}

int display::getType() {
    return type;
}

void display::setPatient(string f, string l) {
    ui->textBrowser->setPlainText(QString::fromStdString(er.printPatient(f, l)));
}

void display::setType(const int &t) {
    switch (t) {
        case 0 :
            ui->textBrowser->setPlainText(QString::fromStdString(er.viewNextPatient()));
            break;
        case 1 :
            ui ->textBrowser->setPlainText(QString::fromStdString(er.printAll()));
            break;
        case 2 :
            ui->textBrowser->setPlainText(QString::fromStdString(er.printByDoctor()));
            break;
        case 3 :
            ui->textBrowser->setPlainText(QString::fromStdString(er.printTreated()));
            break;
        }
    type = t;
}

void display::on_close_clicked()
{
    close();
}
