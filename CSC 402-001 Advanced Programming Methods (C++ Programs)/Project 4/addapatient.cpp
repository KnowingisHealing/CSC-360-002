#include "addapatient.h"
#include "ui_addapatient.h"

addapatient::addapatient(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::addapatient)
{
    ui->setupUi(this);
}

addapatient::~addapatient()
{
    delete ui;
}

void addapatient::on_buttonBox_accepted()
{
    string first = ui->firstText->text().toStdString();
    string mid = ui->middleText->text().toStdString();
    string last = ui->lastText->text().toStdString();
    string suff = ui->suffixText->text().toStdString();
    string ailment = ui->ailmentText->text().toStdString();
    ailments.push_back(ailment);
    string doctor = ui->doctorText->text().toStdString();
    bool treated = false;
    if (ui->yesRadioButton->isChecked())
        treated = true;
    int priority = ui->priorityText->text().toInt();
    Patient p = Patient(first, mid, last, suff, ailments, doctor, treated, priority);
    er.addPatient(p);
}

void addapatient::on_pushButton_clicked()
{
    ailments.push_back(ui->ailmentText->text().toStdString());
    ui->ailmentText->clear();
}
