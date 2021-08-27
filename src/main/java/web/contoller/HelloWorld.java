package web.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {

    @GetMapping(value = "/")
    public String helloWorld() {
        return "index";
    }
}
