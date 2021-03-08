package cn.liy.messagedeliver.client.common;


import java.io.Serializable;

/**
 * 返回结果状态码枚举
 *
 * @author liy
 * @date 2021-03-08 21:55
 */
public enum BaseErrorCode implements Serializable {

    /**
     * 失败
     */
    FAILED(0, "失败!"),

    /**
     * 操作成功
     */
    SUCCESS(1, "成功!"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(1000, "未知异常!"),

    ;

    /**
     * code 错误码
     */
    private Integer code;
    /**
     * description 描述
     */
    private String desc;

    /**
     * 构造函数
     * @param code
     * @param desc
     */
    private BaseErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 获取编码
     * @return
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * 获取描述
     * @return
     */
    public String getDesc() {
        return this.desc;
    }

    @Override
    public String toString() {
        return String.format("Code:[%s], Description:[%s]. ", this.code, this.desc);
    }

    /**
     *  根据code 获取 枚举值
     * @param code  code
     * @return 匹配的枚举
     */
    public static BaseErrorCode getEnumByCode(Integer code){
        if(code == null){
            return UNKNOWN_ERROR;
        }
        BaseErrorCode[] enums = BaseErrorCode.values();
        for(BaseErrorCode baseEnum : enums){
            if(baseEnum.code.equals(code)){
                return baseEnum;
            }
        }
        return UNKNOWN_ERROR;
    }
}
