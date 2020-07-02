package quickstart.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@ApiModel(description = "人员表")
// @Entity(name="ai_pad_device")
public class User {

    @ApiModelProperty(value = "设备id", example = "1")
    @NotEmpty(message = "ID不能为空")
    @NotBlank(message = "ID不能为空哟")
    // @Id
    // @GeneratedValue(generator = "snowFlakeId")
    // @GenericGenerator(name = "snowFlakeId", strategy = "com.cnbmtech.api.utils.id.SnowflakeId")
    // @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "port",example = "jack")
    // 当前端属性为username,后台接收对象的属性为name时可以用@JsonProperty来保持一致
    @JsonProperty("name")
    private String  username;

    @ApiModelProperty(value = "port",example = "123")
    private String  password;

    @Min(value = 18)
    @Max(value = 30)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
