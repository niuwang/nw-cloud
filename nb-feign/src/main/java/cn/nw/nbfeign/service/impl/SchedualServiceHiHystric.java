package cn.nw.nbfeign.service.impl;

import cn.nw.nbfeign.service.SchedualServiceHi;
import org.springframework.stereotype.Service;

@Service
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
