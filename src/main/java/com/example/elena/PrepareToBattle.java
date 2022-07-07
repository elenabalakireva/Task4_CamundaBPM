package com.example.elena;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PrepareToBattle implements JavaDelegate {

    private int maxValue = 200;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int value = (int) (Math.random()* ++maxValue);
        String userTask;
        boolean isWin = false;

        if (value>100) {
            isWin = true;
            userTask = "You are win!";
        } else {
            userTask = "You are loose(";
        }

        delegateExecution.setVariable("value", value);
        delegateExecution.setVariable("userTask", userTask);
        delegateExecution.setVariable("isWin", isWin);
    }
}
