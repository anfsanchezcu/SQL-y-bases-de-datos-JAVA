package repository;

import model.Employee;
import util.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeR implements Repository<Employee> {

    //
    final String id = "id";
    final String first_name = "first_name";
    final String pa_surname = "pa_surname";
    final String ma_surname = "ma_surname";
    final String email = "email";
    final String salary = "salary";
    final String curp = "curp";

    //SQLstatements
    final String sqlGetAll = "SELECT * FROM employees";
    final String sqlGetByID = "SELECT * FROM employees WHERE id =?";
    final String sqlInsert = "INSERT INTO employees ("+first_name +","+ pa_surname +","+ ma_surname +","+ email +","+ salary +","+ curp +") VALUE (?,?,?,?,?,?)";
    final String sqlDelete = "DELETE FROM employees WHERE id=?";

    //auxiliar instances
    Employee employeeAux;






    private Connection getConnection() throws SQLException {
        return DBconnection.getConnection();
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employeesList = new ArrayList<>();
        try (
                Connection myConn = getConnection();
                Statement myStatement = myConn.createStatement();
                ResultSet myRes = myStatement.executeQuery(sqlGetAll);
        ) {
            while (myRes.next()) {
                createEmployee(myRes);
                employeesList.add(employeeAux);
            }
        }
        return employeesList;
    }

    @Override
    public Employee getById(Integer id) throws SQLException{
        try(
            Connection myConn = getConnection();
            PreparedStatement myStatement = myConn.prepareStatement(sqlGetByID);
        ){
            myStatement.setInt(1,id);
            try(
                ResultSet myresult = myStatement.executeQuery();
            ){
                if(myresult.next())
                    createEmployee(myresult);
            }

        }
        return employeeAux;
    }

    @Override
    public void save(Employee employee) throws SQLException{
        try(
            Connection myConn = getConnection();
            PreparedStatement myStatement = myConn.prepareStatement(sqlInsert);
        ){
            myStatement.setString(1, employee.getFirst_name());
            myStatement.setString(2, employee.getPa_surname());
            myStatement.setString(3, employee.getMa_surname());
            myStatement.setString(4, employee.getEmail());
            myStatement.setFloat(5, employee.getSalary());
            myStatement.setString(6, employee.getCurp());
            myStatement.executeUpdate();
        }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        try(
            Connection myConn = getConnection();
            PreparedStatement exist = myConn.prepareStatement(sqlGetByID);
            PreparedStatement myStatement = myConn.prepareStatement(sqlDelete);
        ){
            exist.setInt(1,id);
            if(exist.executeQuery().next()){
                myStatement.setInt(1,id);
                myStatement.executeUpdate();
                System.out.println("Se elimino correctamente");
            }else{
                System.out.println("No exite");
            }
        }
    }


    private  void  createEmployee(ResultSet myRes) throws SQLException{
        employeeAux = new Employee(
                myRes.getString(first_name),
                myRes.getString(pa_surname),
                myRes.getString(ma_surname),
                myRes.getString(email),
                myRes.getFloat(salary),
                myRes.getString(curp)
        );

        employeeAux.setId(myRes.getInt("id"));
    }
}
