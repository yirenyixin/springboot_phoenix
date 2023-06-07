package net.educoder.controller;
import net.educoder.entity.User;
import net.educoder.service.Step1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class Step1Controller {

    /********** Begin **********/
    @Autowired
    private Step1Service step1Service;


    @RequestMapping("/monitoringUser")
    @ResponseBody
    public Map<String, Object> monitoringUser() {
        HashMap<String, Object> map = new HashMap<>();
        List<User> list = step1Service.findMonitoringUser();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }
    /********** End **********/
}