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

        try(
            Connection myConn = DBconnection.getInstance()
        ){
            if(myConn.getAutoCommit())myConn.setAutoCommit(false);

            try{
                Repository<Employee> repository = new EmployeeR(myConn);
                employeAux = new Employee(
                        "Carlos",
                        "Tobon",
                        "Tamayo",
                        "calor@example.com",
                        3000F,
                        "ASDFGHQWERTY789456"
                );
                repository.save(employeAux);
                myConn.commit();
            }catch(SQLException e){
                myConn.rollback();
                throw new RuntimeException(e);
            }
        }




    }
}