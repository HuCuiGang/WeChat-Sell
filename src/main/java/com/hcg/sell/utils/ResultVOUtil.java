package com.hcg.sell.utils;


import com.hcg.sell.VO.ResultVO;

/**
 * @program: sell
 * @description: 返回给前端的数据结果封装
 * @author: hcg
 * @create: 2019-05-18 14:14
 * @modify by:
 * @updated:
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
