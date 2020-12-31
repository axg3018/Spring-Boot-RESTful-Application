package com.empl.test.data;

public class Report {
    private Employee employee;
    private int numberOfReports;

    public Report() {
    }

    public void setEmployee(Employee emp) {

        this.employee = emp;
    }

    public Employee getEmployee(){

        return this.employee;
    }

    public void setReports(int reports){

        this.numberOfReports = reports;
    }

    public int getReports(){

        return this.numberOfReports;
    }


}
