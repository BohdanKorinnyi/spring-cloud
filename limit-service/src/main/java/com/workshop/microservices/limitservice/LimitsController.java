package com.workshop.microservices.limitservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private LimitsConfiguration limitsConfiguration;

    @GetMapping("limits")
    public LimitsDefinition getLimitsDefinition() {
        return new LimitsDefinition(limitsConfiguration.getMinimum(), limitsConfiguration.getMaximum());
    }

    @GetMapping("limits/hystrix")
    @HystrixCommand(fallbackMethod = "getDefaultLimitDefinition")
    public LimitsDefinition hystrix() {
        throw new RuntimeException("hystrix error");
    }

    public LimitsDefinition getDefaultLimitDefinition() {
        return new LimitsDefinition(-1, -1);
    }
}
