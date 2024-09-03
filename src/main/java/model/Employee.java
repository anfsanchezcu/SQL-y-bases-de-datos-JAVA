package model;

public class Employee {
    private  Integer id;
    private  String first_name;
    private  String pa_surname;
    private  String ma_surname;
    private  String email;
    private  Float salary;
    private String curp;


    public Employee(){

    }

    public Employee(
        String first_name,
        String pa_surname,
        String ma_surname,
        String email,
        Float salary,
        String curp
        )
    {
        this.first_name=first_name;
        this.pa_surname=pa_surname;
        this.ma_surname=ma_surname;
        this.email=email;
        this.salary=salary;
        this.curp = curp;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMa_surname() {
        return ma_surname;
    }

    public void setMa_surname(String ma_surname) {
        this.ma_surname = ma_surname;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPa_surname() {
        return pa_surname;
    }

    public void setPa_surname(String pa_surname) {
        this.pa_surname = pa_surname;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString(){
        return id +":"+ first_name  +" "+ curp;
    }
}
