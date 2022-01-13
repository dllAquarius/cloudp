package com.aquarius.cloud.service.impl;

import com.aquarius.cloud.dao.PaymentDao;
import com.aquarius.cloud.entities.Payment;
import com.aquarius.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: dllAquarius
 * @Date: 2022/1/11
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
