package com.gzf.demo.operation.operationList;

import com.gzf.demo.operation.Operation;

public class OperationDiv extends Operation{
    public double GetResult(){
        double result = 0;
        if (getNum2() == 0)
            try {
                throw new Exception("除数不能为0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        result = getNum1()/getNum2();
        return result;
    }
}
