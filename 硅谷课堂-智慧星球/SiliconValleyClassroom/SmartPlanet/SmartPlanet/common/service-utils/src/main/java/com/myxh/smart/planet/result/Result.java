package com.myxh.smart.planet.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MYXH
 * @date 2023/9/30
 * @description 全局统一返回结果类
 */
@Schema(description = "全局统一返回结果")
@NoArgsConstructor
@Data
public class Result<T>
{
    @Schema(description = "状态码")
    private Integer code;

    @Schema(description = "返回状态信息（成功、失败）")
    private String message;

    @Schema(description = "返回数据")
    private T data;

    /**
     * 使用 ResultCodeEnum 枚举构建 Result 实例
     *
     * @param body           返回数据
     * @param resultCodeEnum ResultCodeEnum 结果码枚举
     * @param <T>            数据类型
     * @return 构建好的 Result 实例
     */
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum)
    {
        Result<T> result = new Result<>();

        if (body != null)
        {
            result.setData(body);
        }

        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());

        return result;
    }

    /**
     * 操作成功，有 data 数据
     *
     * @param data 数据
     * @param <T>  数据 data 类型 T
     * @return result 结果
     */
    public static <T> Result<T> ok(T data)
    {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    /**
     * 操作失败，有 data 数据
     *
     * @param data 数据
     * @param <T>  数据 data 类型 T
     * @return result 结果
     */
    public static <T> Result<T> fail(T data)
    {
        return build(data, ResultCodeEnum.FAIL);
    }

    /**
     * 设置消息字段值
     *
     * @param message 要设置的值
     * @return 结果实例（用于链式调用）
     */
    public Result<T> message(String message)
    {
        this.setMessage(message);

        return this;
    }

    /**
     * 设置代码字段值
     *
     * @param code 要设置的值
     * @return 结果实例（用于链式调用）
     */
    public Result<T> code(Integer code)
    {
        this.setCode(code);

        return this;
    }

    /**
     * 操作成功，没有 data 数据
     *
     * @return result 结果
     * @param <T> 数据 data 类型 T
     */
    /*
    public static <T> Result<T> ok()
    {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("成功");

        return result;
    }
     */


    /**
     * 操作失败，没有 data 数据
     *
     * @return result 结果
     * @param <T> 数据 data 类型 T
     */
    /*
    public static <T> Result<T> fail()
    {
        Result<T> result = new Result<>();
        result.setCode(201);
        result.setMessage("失败");

        return result;
    }
     */
}
