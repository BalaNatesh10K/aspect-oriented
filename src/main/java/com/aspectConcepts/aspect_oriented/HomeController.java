package com.aspectConcepts.aspect_oriented;

import com.aspectConcepts.aspect_oriented.aspects.CheckSomething;
import com.aspectConcepts.aspect_oriented.aspects.Loggable;
import com.aspectConcepts.aspect_oriented.service.TimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {
    @RequestMapping("/")
    @CheckSomething(roles ={"role3"})
    @Loggable
    public String index(){
        TimeService timeService = new TimeService();
        System.out.println("Time is "+timeService.getCurrentTime());
        return "Vanakkam da maapla SpringBoot la irunthu";
    }

    @RequestMapping("/throwException")
    @CheckSomething(roles = {"role1", "role2"})
    @Loggable
    public String throwException() throws Exception{
        try{
            throw new Exception("Exception has come, check the logs");
        }catch (Exception ex){
            return ex.getMessage();
        }
    }
}
