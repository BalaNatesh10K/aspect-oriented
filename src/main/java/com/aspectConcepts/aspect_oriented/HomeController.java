package com.aspectConcepts.aspect_oriented;

import com.aspectConcepts.aspect_oriented.aspects.CheckSomething;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {
    @RequestMapping("/")
    @CheckSomething(roles ={"role3"})
    public String index(){
        return "Vanakkam da maapla SpringBoot la irunthu";
    }
}
