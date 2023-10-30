package com.myxh.smart.planet.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MYXH
 * @date 2023/9/30
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SmartPlanetException extends RuntimeException
{
    private Integer code;
    private String message;
}
