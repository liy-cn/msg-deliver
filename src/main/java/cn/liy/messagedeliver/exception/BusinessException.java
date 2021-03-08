package cn.liy.messagedeliver.exception;

import cn.liy.messagedeliver.client.common.BaseErrorCode;

import java.io.Serializable;

/**
 * 自定义业务异常类
 * @date 2021-03-08 21:54
 * @author liy
 */
public class BusinessException extends RuntimeException implements Serializable {

    /**
     * 错误 BaseErrorCode
     */
    private BaseErrorCode errorCode;

    /**
     * BusinessException
     * @param errorCode
     */
    public BusinessException(BaseErrorCode errorCode) {
        this(errorCode, errorCode.getDesc());
    }

    /**
     * BusinessException
     * @param errorCode
     * @param errorMessage
     */
    public BusinessException(BaseErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    /**
     * 构造函数
     * @param errorCode
     * @param errorMessage
     * @param cause
     */
    private BusinessException(BaseErrorCode errorCode, String errorMessage, Throwable cause) {
        super(String.format("Code:[%s], Description:[%s],cause [%s]", errorCode.getCode(), errorMessage, cause));
        this.errorCode = errorCode;
    }

    /**
     * asBusinessException
     * @param errorCode
     * @return
     */
    public static BusinessException asBusinessException(BaseErrorCode errorCode) {
        return new BusinessException(errorCode);
    }

    /**
     * asBusinessException
     * @param errorCode
     * @param message
     * @return
     */
    public static BusinessException asBusinessException(BaseErrorCode errorCode, String message) {
        return new BusinessException(errorCode, message);
    }

    /**
     * asBusinessException
     * @param errorCode
     * @param message
     * @param cause
     * @return
     */
    public static BusinessException asBusinessException(BaseErrorCode errorCode, String message, Throwable cause) {
        return cause instanceof BusinessException ? (BusinessException)cause : new BusinessException(errorCode, message, cause);
    }

    /**
     * asBusinessException
     * @param errorCode
     * @param cause
     * @return
     */
    public static BusinessException asBusinessException(BaseErrorCode errorCode, Throwable cause) {
        return cause instanceof BusinessException ? (BusinessException)cause : new BusinessException(errorCode, errorCode.getDesc(), cause);
    }

    public BaseErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * getMessage
     * @param obj
     * @return
     */
    private static String getMessage(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj instanceof Throwable ? ((Throwable)obj).getMessage() : obj.toString();
        }
    }
}
