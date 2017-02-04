#include "entry.h"
#include "ui_entry.h"

entry::entry(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::entry)
{
    ui->setupUi(this);
}

entry::~entry()
{
    delete ui;
}

void entry::setType(int t) {
    type = t;
}

void entry::on_buttonBox_rejected()
{
    close();
}

void entry::on_buttonBox_accepted()
{
    string path = ui->filePath->text().toStdString();
    if (type == 0)
        er.addFromFile(path);
    else if (type == 1)
        er.setLogFilePath(path);
}
