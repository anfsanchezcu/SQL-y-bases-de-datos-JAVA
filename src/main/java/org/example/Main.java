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

        //Todos las instacias que son pasadas al try se cerraran al finalizar la ejecucion

            Repository<Employee> respository  = new EmployeeR();

            //System.out.println(respository.getById(20));


            employeeList = respository.findAll();
            employeeList.forEach(System.out::println);


            //respository.save(new Employee("Edward", "Rondon", "Sanchez", "rondon@unal.edu.co", (float)2135));

            //employeeList = respository.findAll();
            //employeeList.forEach(System.out::println);

            respository.delete(14);

    }
}