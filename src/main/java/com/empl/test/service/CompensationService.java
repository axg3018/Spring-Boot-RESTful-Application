package com.empl.test.service;


import com.empl.test.data.Compensation;

public interface CompensationService {
    Compensation create(Compensation comp);
    Compensation read(String id);
}
