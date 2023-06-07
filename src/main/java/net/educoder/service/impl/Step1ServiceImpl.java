package net.educoder.service.impl;

import net.educoder.entity.User;
import net.educoder.mapper.Step1Mapper;
import net.educoder.service.Step1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Step1ServiceImpl implements Step1Service {


    /********** Begin **********/


    @Autowired
    private Step1Mapper step1mapper;
    @Override
    public List<User> findMonitoringUser() {
        return step1mapper.findMonitoringUser();
    }

    /********** End **********/

}
