package com.empl.test.data;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Compensation {
    private Employee employee;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String employeeId;

    private int salary;
    private String effectiveDate;

    public Compensation() {
    }


    public String getEmployeeId(){
        return this.employeeId;
    }

    public void setEmployeeId(String id){
        try{
            if (id != null)
                this.employee.setEmployeeId(id);
            employeeId = id;
        }
        catch(Exception e){
            this.employee = new Employee();
            if (id != null)
                this.employee.setEmployeeId(id);
            employeeId = id;

        }
    }



    public void setEmployee(Employee emp) {

        this.employee = emp;
    }

    public Employee getEmployee(){

        return this.employee;
    }

    public void setSalary(int comp) {

        this.salary = comp;
    }

    public int getSalary(){

        return this.salary;
    }

    public void setEffectiveDate(String date) {

        this.effectiveDate = date;
    }

    public String getEffectiveDate(){
        return this.effectiveDate;
    }


}
