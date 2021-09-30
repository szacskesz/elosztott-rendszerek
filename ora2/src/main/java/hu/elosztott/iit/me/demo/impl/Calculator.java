package hu.elosztott.iit.me.demo.impl;

import org.springframework.stereotype.Service;

@Service
public class Calculator implements hu.elosztott.iit.me.demo.Calculator {

    @Override
    public Double add(Double operand1, Double operand2) {
        return operand1 + operand2;
    }
}
