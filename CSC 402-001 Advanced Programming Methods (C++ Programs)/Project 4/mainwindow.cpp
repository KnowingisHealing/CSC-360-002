#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    er.setLogFilePath("log.txt");
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_addPatient_clicked()
{
    a.setModal(true);
    a.exec();
}

void MainWindow::on_viewNext_clicked()
{
    d.setType(0);
    d.setModal(true);
    d.exec();
}

void MainWindow::on_printAll_clicked()
{
    d.setType(1);
    d.setModal(true);
    d.exec();
}

void MainWindow::on_printPatient_clicked()
{
    p.setModal(true);
    p.exec();
}

void MainWindow::on_printByDoctor_clicked()
{
    d.setType(2);
    d.setModal(true);
    d.exec();
}

void MainWindow::on_printTreated_clicked()
{
    d.setType(3);
    d.setModal(true);
    d.exec();
}

void MainWindow::on_addPatients_clicked()
{
    e.setModal(true);
    e.setType(0);
    e.exec();
}

void MainWindow::on_treatPatient_clicked()
{
    er.treatPatient();
    i.setModal(true);
    i.exec();
}

void MainWindow::on_treatAll_clicked()
{
    er.treatAll();
    i.setModal(true);
    i.exec();
}

void MainWindow::on_setLogFile_clicked()
{
    e.setModal(true);
    e.setType(1);
    e.exec();
}
