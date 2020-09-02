package com.du.daydayup.result;


import com.du.daydayup.pojo.ResultStatus;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Du
 * @date 2020/9/2 22:31
 */

@Getter
@ToString
public class Result<T> {

    private Integer code;
    private String message;
    /**
     *  返回参数
     */
    private T data;

    private Result(ResultStatus resultStatus,T data){
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.data = data;
    }

    /**
     * 业务成返回业务代码和描述信息
     * @return
     */
    public static Result<Void> success(){
        return new Result<>(ResultStatus.SUCCESS,null);
    }

    /**
     * 业务成功返回业务代码，描述和返回的参数
     */
    public static <T> Result<T> success(ResultStatus resultStatus,T data){
        if (resultStatus == null){
            return success(data);
        }
        return new Result<>(resultStatus,data);
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(ResultStatus.SUCCESS,data);
    }

    /**
     * 业务异常返回码和描述信息
     * @return
     */
    public static <T> Result<T> failure(){
        return new Result<T>(ResultStatus.INTERNAL_SERVER_ERROR,null);
    }

    /**
     * 业务成功返回业务代码，描述和返回的参数
     */
    public static <T> Result<T> failure(ResultStatus resultStatus,T data){
        if (resultStatus == null){
            return new Result<T>(ResultStatus.INTERNAL_SERVER_ERROR,null);
        }
        return new Result<T>(resultStatus,data);
    }

    public static <T> Result<T> failure(ResultStatus resultStatus){
        return failure(resultStatus,null);
    }

}
