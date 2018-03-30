package hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    String sayHello() {
        return "Hello World!";
    }

}
