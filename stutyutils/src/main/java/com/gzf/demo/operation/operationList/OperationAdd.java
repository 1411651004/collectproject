package com.gzf.demo.operation.operationList;

import com.gzf.demo.operation.Operation;

public class OperationAdd extends Operation{
    public double GetResult(){
        double result = 0;
        result = getNum1()+getNum2();
        return result;
    }
}
