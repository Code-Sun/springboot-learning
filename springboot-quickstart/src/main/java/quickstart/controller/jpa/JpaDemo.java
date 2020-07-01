package quickstart.controller.jpa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quickstart.dao.FpPeopleRepository;
import quickstart.entity.FpPeople;

@Api(tags = "002 jpa demo")
@RestController
@RequestMapping(value = "jpa", produces = {MediaType.APPLICATION_JSON_VALUE})
public class JpaDemo {

    @Autowired
    FpPeopleRepository fpPeopleRepository;

    //这个方法是可靠的
    @ApiOperation(value = "分页查找")
    @PostMapping(value = "/findbyPage")
    public void synchrodata(){
        Pageable pageRequest = PageRequest.of(0,3);
        Page<FpPeople> all = fpPeopleRepository.findAll(pageRequest);
        System.out.println("总条数："+all.getTotalElements());
        System.out.println("总页数："+all.getTotalPages());
        System.out.println("当前页的查询条数：" + all.getNumberOfElements());
        System.out.println("当前页的大小：" + all.getSize());
        System.out.println("当前页码：" + all.getNumber());
        System.out.println("当前排序规则："+all.getSort());
        System.out.println("当前页码的Pageable对象"+all.getPageable());

        Pageable pageable = all.getPageable();
        System.out.println("当前页码"+pageable.getPageNumber());
        System.out.println("当前页码查询条数"+pageable.getPageSize());
        System.out.println("判断是否还有上一页"+pageable.hasPrevious());

        if (pageable.next().getPageNumber()>=all.getTotalPages()) {
            System.out.println("判断是否还有下一页："+ false);
        } else {
            System.out.println("判断是否还有下一页："+ true);
        }
    }
}
