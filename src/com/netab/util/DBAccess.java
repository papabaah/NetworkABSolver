package com.netab.util;

import com.netab.model.Operation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {

  private final String CON_DRIVER = "com.mysql.cj.jdbc.Driver";
  private final String DBNAME = "db_solvenab";
  private final String PASSWORD = "12345";
  private final String USERNAME = "nabsolve";

  private Connection connect;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;

  public DBAccess() throws Exception {
    Class.forName(CON_DRIVER);
    connect = DriverManager.getConnection(getConnectionUrl());
  }

  public int save(Operation operation) throws SQLException {
    String query = "INSERT INTO nabsolver(value1, value2, result, operator, dateCreated) VALUES(?, ?, ?, ?, ?)";
    preparedStatement = connect.prepareStatement(query);
    preparedStatement.setDouble(1, operation.getValue1());
    preparedStatement.setDouble(2, operation.getValue2());
    preparedStatement.setDouble(3, operation.getResult());
    preparedStatement.setString(4, operation.getOperator().toString());
    preparedStatement.setTimestamp(5, operation.getDateCreated());
    return preparedStatement.executeUpdate();
  }

  public int delete(int id) throws SQLException {
    String query = "DELETE FROM nabsolver WHERE id=?";
    preparedStatement = connect.prepareStatement(query);
    preparedStatement.setInt(1, id);
    return preparedStatement.executeUpdate();
  }

  public List<Operation> findAll() throws SQLException {
    String query = "SELECT * FROM nabsolver";
    preparedStatement = connect.prepareStatement(query);
    resultSet = preparedStatement.executeQuery();
    return getOperationObjects(resultSet);
  }

  private List<Operation> getOperationObjects(ResultSet resultSet) throws SQLException {
    List<Operation> listOpt = new ArrayList<>();
    while(resultSet.next()) {
      Operation opt = new Operation();
      opt.setId(resultSet.getInt("id"));
      opt.setValue1(resultSet.getDouble("value1"));
      opt.setValue2(resultSet.getDouble("value2"));
      opt.setResult(resultSet.getDouble("result"));
      opt.setOperator(Operator.valueOf(resultSet.getString("operator")));
      opt.setDateCreated(resultSet.getTimestamp("dateCreated"));

      listOpt.add(opt);
    }
    return listOpt;
  }

  private String getConnectionUrl() {
    return "jdbc:mysql://" + USERNAME + ":" + PASSWORD + "@localhost/"+ DBNAME;
  }

}
