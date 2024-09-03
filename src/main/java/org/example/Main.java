package org.example;

import model.Employee;
import repository.EmployeeR;
import repository.Repository;
import util.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employeAux;

        System.out.println("listando todos");

        Repository <Employee> repository  = new EmployeeR();
        repository.findAll().forEach(System.out::println);

        System.out.println("search by ID");
        System.out.println(repository.getById(16));



    }
}