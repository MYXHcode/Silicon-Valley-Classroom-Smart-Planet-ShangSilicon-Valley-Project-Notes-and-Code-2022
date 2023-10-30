package com.myxh.smart.planet.live.mtcloud;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author MYXH
 * @date 2023/10/23
 */
public class CommonResult<T> implements Serializable
{
    @Getter
    @Serial
    private static final long serialVersionUID = 7917345507074842804L;
    @Getter
    private String code;
    @Getter
    private String msg;
    @Getter
    private T data;
    private final String format = "json";

    public static class Builder
    {
        public static CommonResult SUCC()
        {
            CommonResult vo = new CommonResult();
            vo.setCode("0");
            vo.setmsg("suc");

            return vo;
        }

        public static CommonResult FAIL()
        {
            CommonResult vo = new CommonResult();
            
            return vo;
        }
    }

    public CommonResult initErrCodeAndMsg(String code, String msg)
    {
        this.code = code;
        this.msg = msg;

        return this;
    }

    public CommonResult initErrCodeAndMsg(int code, String msg)
    {
        this.code = Integer.toString(code);
        this.msg = msg;

        return this;
    }

    public CommonResult initSuccCodeAndMsg(String code, String msg)
    {
        this.code = code;
        this.msg = msg;

        return this;
    }

    public CommonResult initSuccData(T data)
    {
        this.data = data;

        return this;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public void setmsg(String msg)
    {
        this.msg = msg;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
