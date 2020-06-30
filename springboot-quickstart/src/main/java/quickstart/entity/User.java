package quickstart.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "人员表")
// @Entity(name="ai_pad_device")
public class User {

    @ApiModelProperty(value = "设备id", example = "1")
    // @Id
    // @GeneratedValue(generator = "snowFlakeId")
    // @GenericGenerator(name = "snowFlakeId", strategy = "com.cnbmtech.api.utils.id.SnowflakeId")
    // @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "port",example = "jack")
    private String  username;

    @ApiModelProperty(value = "port",example = "123")
    private String  password;

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
