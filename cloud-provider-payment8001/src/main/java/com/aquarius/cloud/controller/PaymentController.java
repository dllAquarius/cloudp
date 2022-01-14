package com.aquarius.cloud.controller;

import com.aquarius.cloud.entities.CommonResult;
import com.aquarius.cloud.entities.Payment;
import com.aquarius.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);

            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
             }
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentPort(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){


        // 暂停几秒线程
        try {
            TimeUnit.SECONDS.sleep(3);

        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
