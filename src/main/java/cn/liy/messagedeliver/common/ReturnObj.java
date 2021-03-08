package cn.liy.messagedeliver.common;

import lombok.Data;


/**
 * 小返回对象
 *
 * @author liy
 * @date 2021-03-08 21:46
 */
@Data
public class ReturnObj<T> {
    /**
     * count sql返回的影响行数
     */
    private int count;
    /**
     * data 数据
     */
    private T data;
}
