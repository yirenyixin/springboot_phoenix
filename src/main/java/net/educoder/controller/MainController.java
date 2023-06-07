package net.educoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    /**
     * 模板跳转
     *
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String index(@PathVariable String page) {
        return page;
    }

}
