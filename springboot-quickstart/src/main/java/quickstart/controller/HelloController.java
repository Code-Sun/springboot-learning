package quickstart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import quickstart.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api(tags = "001 hello")
@RestController
@RequestMapping(value = "hello", produces = {MediaType.APPLICATION_JSON_VALUE})
public class HelloController {

    /*
测试：
http://localhost:8080/hello/user/3 POST
{
  "id":1,
	"username":"jack",
  "password":"123456"
}

返回
3 hello User{id=1, username='jack', password='123456'}
 */
    @ApiOperation(value = "测试")
    @PostMapping(value = "/user/{id}")
    public String hello(@PathVariable("id") Integer id, @RequestBody User user) {
        return id + " hello " + user.toString();
    }

    // PathVaribale 获取url路径的数据

    /**
     * 测试：
     * 输入
     * http://localhost:9600/test/hello/1/rose
     * 返回
     * "id:1 name:rose"
     *
     * @param id
     * @param name
     * @return
     */
    // @GetMapping 组合注解，是 @RequestMapping(method = RequestMethod.GET) 的缩写
    // @RequestMapping(value="/hello/{id}/{name}",method= RequestMethod.GET)
    @GetMapping("/hello1/{id}/{name}")
    public String sayHello1(@PathVariable("id") Integer id,@PathVariable("name") String name){
        return "id:"+id+" name:"+name;
    }

    // RequestParam 获取请求参数的值

    /**
     * 测试：
     * 输入
     * http://localhost:9600/test/hello/?id=1000
     * 返回
     * "id:1000"
     *
     * 获取url参数值，默认方式，需要方法参数名称和url参数保持一致
     *
     * @param id
     * @return
     */
    // 将Integer 换成int也可以
    @RequestMapping(value="/hello2",method= RequestMethod.GET)
    public String sayHello2(@RequestParam Integer id){
        return "id:"+id;
    }

    /**
     * 测试：
     * 输入
     * localhost:9600/test/hello3?id=98&name=helloworld
     * 返回
     * "id:98 name:helloworld"
     *
     * url中有多个参数时
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value="/hello3",method= RequestMethod.GET)
    public String sayHello3(@RequestParam Integer id,@RequestParam String name){
        return "id:"+id+ " name:"+name;
    }

    /**
     * 测试：
     * 输入:localhost:9600/test/hello4?userId=1000
     * 返回:"id:1000"
     *
     * 输入:localhost:9600/test/hello4?userId=
     * 返回:"id:null"
     *
     * 获取url参数值，执行参数名称方式
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/hello4",method= RequestMethod.GET)
    public String sayHello4(@RequestParam("userId") Integer id){
        return "id:"+id;
    }

    // GET参数校验

    /**
     * 测试
     * 输入：localhost:9600/test/hello5
     * 返回："id:1"
     *
     * 输入：localhost:9600/test/hello5?id=
     * 返回："id:1"
     *
     * 输入：localhost:9600/test/hello5?id=1000
     * 返回："id:1000"
     *
     * GET参数校验
     * 用法：不输入id时，使用默认值
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/hello5",method= RequestMethod.GET)
    //required=false 表示url中可以无id参数，此时就使用默认参数
    public String sayHello5(@RequestParam(value="id",required = false,defaultValue = "1") Integer id){
        return "id:"+id;
    }

    // POST JSON参数校验

    /**
     * 测试
     * 输入：
     *     post: localhost:9600/test/hello6
     *     body:
     *          {
     * 	            "id":"1",
     * 	            "age":20,
     * 	            "name":"jack"
     *          }
     *  返回：
     *     User{id='1', age=20, name='jack'}
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/hello6",produces = MediaType.TEXT_PLAIN_VALUE)
    // @ResponseBody
    public String hello6(@RequestBody @Valid User user , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            System.out.println(objectErrors.toString());
            for(ObjectError objectError: objectErrors){
                System.out.println("objectError = " + objectError.getObjectName());
                System.out.println("objectError = " + objectError.getDefaultMessage());
                System.out.println("objectError = " + objectError.getCode());
                System.out.println("objectError = " + objectError.getArguments());
            }
        }
        String str =  user.toString();
        return str;
    }

    public static void main(String[] args) throws JsonProcessingException {

        User user = new User();
        user.setUsername("张三");

        //使用writeValuesAsString的方法就可以把对角转化成json字符串。
        System.out.println(new ObjectMapper().writeValueAsString(user));

    }


}
