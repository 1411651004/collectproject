package com.gzf.demo.operation;

import com.gzf.demo.operation.operationList.OperationAdd;
import com.gzf.demo.operation.operationList.OperationDiv;
import com.gzf.demo.operation.operationList.OperationMul;
import com.gzf.demo.operation.operationList.OperationSub;

public class OperationFactory {
    public static Operation createOperation(String operate){
        Operation opr = null;
        switch (operate){
            case "+":
                opr = new OperationAdd();
                break;
            case "-":
                opr = new OperationSub();
                break;
            case "*":
                opr = new OperationMul();
                break;
            case "/":
                opr = new OperationDiv();
                break;
        }
        return opr;
    }
}
