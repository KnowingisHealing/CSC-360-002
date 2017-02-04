#include "patientsearch.h"
#include "ui_patientsearch.h"

patientSearch::patientSearch(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::patientSearch)
{
    ui->setupUi(this);
}

patientSearch::~patientSearch()
{
    delete ui;
}

void patientSearch::on_buttonBox_accepted()
{
    string first = ui->firstName->text().toStdString();
    string last = ui->lastName->text().toStdString();
    d.setPatient(first, last);
    d.setModal(true);
    d.exec();
    this->close();
}
