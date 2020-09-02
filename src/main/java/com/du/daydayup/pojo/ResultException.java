package com.du.daydayup.pojo;

import lombok.Getter;

/**
 * @author Du
 * @date 2020/9/2 22:24
 */
@Getter
public class ResultException extends Exception {

    ResultStatus resultStatus;

    public ResultException(){
        this(ResultStatus.INTERNAL_SERVER_ERROR);
    }
    public ResultException(ResultStatus resultStatus){
        super(resultStatus.getMessage());
        this.resultStatus = resultStatus;
    }

}
