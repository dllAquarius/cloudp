package com.aquarius.cloud.controller;

import com.aquarius.cloud.entities.CommonResult;
import com.aquarius.cloud.entities.Payment;
import com.aquarius.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: dllAquarius
 * @Date: 2022/1/11
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);

        log.info("返回结果--->" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverport:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询数据库成功,serverport:"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询id是"+id,null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentPort(){
        return serverPort;
    }
}
