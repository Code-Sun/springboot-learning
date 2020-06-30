package quickstart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import quickstart.entity.User;

@Api(tags = "001 hello")
@RestController
@RequestMapping(value = "hello", produces = {MediaType.APPLICATION_JSON_VALUE})
public class HelloController {

    @ApiOperation(value = "测试")
    @PostMapping(value = "/user/{id}")
    public String hello(@PathVariable("id") Integer id, @RequestBody User user){
        return id+" hello "+user.toString();
    }
}
