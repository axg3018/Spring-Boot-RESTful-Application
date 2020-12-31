package com.empl.test.controller;

import com.empl.test.data.Compensation;
import com.empl.test.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation salary) {
        LOG.debug("Received salary create request for [{}]", salary);


        return compensationService.create(salary);
    }

    @GetMapping("/compensation/employee/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received employee salary request for id [{}]", id);

        return compensationService.read(id);
    }

}
