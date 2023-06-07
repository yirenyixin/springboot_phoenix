package net.educoder.service.impl;

import net.educoder.entity.Event;
import net.educoder.entity.JsMind;
import net.educoder.entity.User;
import net.educoder.mapper.Step1Mapper;
import net.educoder.mapper.Step2Mapper;
import net.educoder.service.Step1Service;
import net.educoder.service.Step2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Step2ServiceImpl implements Step2Service {

    /********** Begin **********/
    @Autowired
    private Step2Mapper step2Mapper;
    @Autowired
    private Step1Mapper step1Mapper;

    @Override
    public List<JsMind> findEventLogByCode(String id) {
        List<Event> events = step2Mapper.findEventsByCode(id);
        String userName="";
        List<User> list = step1Mapper.findMonitoringUser();
        for(int i=0;i<list.size();i++){
            User user=list.get(i);
            if(id.equals(user.getId())){
                userName=user.getTrueName();
                break;
            }
        }
        List<JsMind> jsMinds = new ArrayList<>();
        jsMinds.add(new JsMind("root", "true", "", userName));
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            jsMinds.add(new JsMind(String.valueOf(i), "false", "root", event.getLog()));
        }
        return jsMinds;

    }
    /********** End **********/
}
