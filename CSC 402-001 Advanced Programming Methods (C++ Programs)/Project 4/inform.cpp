#include "inform.h"
#include "ui_inform.h"

inform::inform(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::inform)
{
    ui->setupUi(this);
}

inform::~inform()
{
    delete ui;
}

void inform::on_pushButton_clicked()
{
    close();
}
