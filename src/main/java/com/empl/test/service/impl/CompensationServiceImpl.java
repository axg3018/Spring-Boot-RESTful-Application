package com.empl.test.service.impl;

import com.empl.test.dao.CompensationRepository;
import com.empl.test.dao.EmployeeRepository;
import com.empl.test.data.Compensation;
import com.empl.test.data.Employee;
import com.empl.test.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Compensation create(Compensation comp) {
        LOG.debug("Creating salary [{}]", comp);
        Employee employee = employeeRepository.findByEmployeeId(comp.getEmployeeId());
        comp.setEmployee(employee);
        compensationRepository.insert(comp);
        comp.setEmployeeId(null);


        return comp;
    }

    @Override
    public Compensation read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        Compensation salary = compensationRepository.findByEmployeeId(id);
        salary.setEmployee(employee);
        salary.setEmployeeId(null);
        return salary;
    }
}
