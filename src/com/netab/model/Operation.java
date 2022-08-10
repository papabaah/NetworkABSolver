package com.netab.model;

import com.netab.util.Operator;

import java.sql.Timestamp;

public class Operation {
  private Integer id;
  private Double value1;
  private Double value2;
  private Double result;
  private Operator operator;
  private Timestamp dateCreated;

  public Operation() {}

  public Operation(Double value1, Double value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getValue1() {
    return value1;
  }

  public void setValue1(Double value1) {
    this.value1 = value1;
  }

  public Double getValue2() {
    return value2;
  }

  public void setValue2(Double value2) {
    this.value2 = value2;
  }

  public Double getResult() {
    return result;
  }

  public void setResult(Double result) {
    this.result = result;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public Timestamp getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Timestamp dateCreated) {
    this.dateCreated = dateCreated;
  }

  @Override
  public String toString() {
    return "Operation{" +
        "id=" + id +
        ", value1=" + value1 +
        ", value2=" + value2 +
        ", result=" + result +
        ", operator=" + operator +
        ", dateCreated=" + dateCreated +
        '}';
  }
}
