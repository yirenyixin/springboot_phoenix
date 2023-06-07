package net.educoder.controller;

import net.educoder.entity.JsMind;
import net.educoder.service.Step2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Step2Controller {

    /********** Begin **********/
    @Autowired
    private Step2Service step2Service;

    @RequestMapping("/jsMindInfo")
    @ResponseBody
    public Map<String, Object> jsMindInfo(String id) {
        HashMap<String, Object> map = new HashMap<>();
        List<JsMind> list = step2Service.findEventLogByCode(id);
        map.put("list", list);
        return map;
    }
    /********** End **********/
}
