package pl.edu.wat.flatmates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.flatmates.beans.Tasktype;


@RestController
public class TasktypeController {

    @Autowired
    TasktypeRepository tasktypeRepository;

    @RequestMapping( path = "/test", method = RequestMethod.GET)
    public void test(){
        Tasktype test = new Tasktype(1,"lala");
        tasktypeRepository.save(test);
    }
}
