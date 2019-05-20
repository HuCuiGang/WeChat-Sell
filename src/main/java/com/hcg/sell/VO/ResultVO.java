package com.hcg.sell.VO;

import lombok.Data;

/**
 * @program: sell
 * @description: http返回的最外层对象
 * @author: hcg
 * @create: 2019-05-18 19:18
 * @modify by:
 * @updated:
 **/
@Data
public class ResultVO<T> {
    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 具体内容、数据 */
    private T data;

}
