package com.netab.app;

import com.netab.model.Operation;
import com.netab.util.DBAccess;
import com.netab.util.Operator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Start {


  public static void main(String[] args) {
    try{
//      double v1 = 2;
//      double v2 = 188;
//      double res = v1 * v2;
//      Operator opr = Operator.multiply;
//      Timestamp dctd = new Timestamp(new Date().getTime());
//
//      Operation opt = new Operation();
//      opt.setValue1(v1);
//      opt.setValue2(v2);
//      opt.setResult(res);
//      opt.setOperator(opr);
//      opt.setDateCreated(dctd);

      DBAccess dao = new DBAccess();
      List<Operation> listOp1 = dao.findAll();
      for(Operation op : listOp1) {
        System.out.println(op.toString());
      }


      dao.delete(3);

      System.out.println("After Deleting...\n");
      List<Operation> listOp = dao.findAll();
      for(Operation op : listOp) {
        System.out.println(op.toString());
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
