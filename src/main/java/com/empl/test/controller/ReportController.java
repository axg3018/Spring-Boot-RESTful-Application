package com.empl.test.controller;

import com.empl.test.data.Report;
import com.empl.test.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;



    @GetMapping("/reportingStructure/{id}")
    public Report read(@PathVariable String id) {
        LOG.debug("Received employee report request for id [{}]", id);

        return reportService.read(id);
    }

}
