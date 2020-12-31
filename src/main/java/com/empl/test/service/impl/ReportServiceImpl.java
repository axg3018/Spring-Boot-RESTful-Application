package com.empl.test.service.impl;


import com.empl.test.data.Employee;
import com.empl.test.data.Report;
import com.empl.test.service.EmployeeService;
import com.empl.test.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;


    @Override
    public Report read(String id) {
        LOG.debug("Reading employee with id [{}]", id);

        Employee employee = employeeService.read(id);
        Report report = new Report();
        report.setEmployee(employee);
        report.setReports(getnumOfReports(employee));

        if (report == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return report;
    }

    public int getnumOfReports(Employee empl){
        int numberOfReports = 0;
        List<Employee> var1 = empl.getDirectReports();
        if(var1 == null)
            return 0;

        for (Employee e : var1){
            String id = e.getEmployeeId();
            Employee e1 = employeeService.read(id);
            numberOfReports += 1 + getnumOfReports(e1);
        }

        return numberOfReports;

    }
}
