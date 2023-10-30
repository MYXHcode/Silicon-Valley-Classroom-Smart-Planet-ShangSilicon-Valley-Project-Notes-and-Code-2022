package com.myxh.smart.planet.exception;

import com.myxh.smart.planet.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MYXH
 * @date 2023/9/30
 */
// 底层通过 AOP 实现
@ControllerAdvice
public class GlobalExceptionHandler
{
    /**
     * 全局异常处理
     *
     * @return Result 全局统一返回结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e)
    {
        e.printStackTrace();

        return Result.fail(null).message("执行全局异常处理");
    }

    /**
     * 特定异常处理
     *
     * @return Result 全局统一返回结果
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e)
    {
        e.printStackTrace();

        return Result.fail(null).message("执行 ArithmeticException 特定异常处理");
    }

    /**
     * SmartPlanetException 自定义异常处理
     *
     * @return Result 全局统一返回结果
     */
    @ExceptionHandler(SmartPlanetException.class)
    @ResponseBody
    public Result error(SmartPlanetException e)
    {
        e.printStackTrace();

        return Result.fail(null).code(e.getCode()).message(e.getMessage());
    }
}
