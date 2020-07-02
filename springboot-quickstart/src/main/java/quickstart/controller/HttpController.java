package quickstart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Api(tags = "600 离线版pad")
@RestController
@RequestMapping(value = "/ai/pads", produces = {MediaType.APPLICATION_JSON_VALUE})
public class HttpController {

    /**
     * 对于没有指定格式的这么接收
     * @param request
     */
    @ApiOperation(value = "中科智云pad igates将数据实时推送到此接口")
    @PostMapping(value = "/receive")
    public void receive(HttpServletRequest request) {
        try {
            ServletInputStream ris = request.getInputStream();
            StringBuilder content = new StringBuilder();
            byte[] b = new byte[1024];
            int length;
            while ((length = ris.read(b)) > 0) {
                content.append(new String(b, 0, length));
            }
            // 推送过来的数据内容
            String strdata = content.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
