package com.FlightManagementSystem.service;

import com.FlightManagementSystem.entity.Schedule;
import com.FlightManagementSystem.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    ScheduleRepository scheduleRepository;
    @Override
    public Schedule addSchedule(Schedule s) {
        return scheduleRepository.save(s);
    }
}
