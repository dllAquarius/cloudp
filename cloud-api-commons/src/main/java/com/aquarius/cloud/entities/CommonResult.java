package com.aquarius.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: dllAquarius
 * @Date: 2022/1/11
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    //404 not_found
    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
