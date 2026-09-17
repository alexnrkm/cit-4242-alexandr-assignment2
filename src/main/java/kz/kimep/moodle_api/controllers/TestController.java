package kz.kimep.moodle_api.controllers;

import kz.kimep.moodle_api.responses.HelloFullName;
import kz.kimep.moodle_api.responses.FullNameResponse;
import kz.kimep.moodle_api.responses.HelloResponse;
import org.springframework.web.bind.annotation.*;

@RestController("")
public class TestController {

    @GetMapping("/hello")
    public HelloResponse hello(@RequestParam String name) {
        return new HelloResponse("Hello " + name);
    }

    @GetMapping("/full-name")
    public FullNameResponse fullName() {
        return new FullNameResponse(
                "Ivan",
                "Ivanov",
                "Ivanovich"
        );
    }

    @GetMapping("/hello-full-name")
    public String helloFullName(@RequestBody HelloFullName request){
        request.setFullName();
        return "Hello " + request.getFullName();
    }

}
