package cn.nb.nbribbon.controller;

import cn.nb.nbribbon.service.ITest2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller {

    @Autowired
    private ITest2Service test2Service;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return test2Service.hiService(name);
    }
}
