package quickstart.entity;

import io.swagger.annotations.ApiModel;
import javax.persistence.Entity;
import javax.persistence.Id;

@ApiModel(description = "人员表")
@Entity(name="fp_people")
public class FpPeople {
  @Id
  private long id;
  private long companyId;
  private long personType;
  private long facialId;
  private String name;
  private long deptId;
  private String phone;
  private long status;
  private String remark;
  private String avatar;
  private String customAvatar;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
  }


  public long getPersonType() {
    return personType;
  }

  public void setPersonType(long personType) {
    this.personType = personType;
  }


  public long getFacialId() {
    return facialId;
  }

  public void setFacialId(long facialId) {
    this.facialId = facialId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getDeptId() {
    return deptId;
  }

  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public String getCustomAvatar() {
    return customAvatar;
  }

  public void setCustomAvatar(String customAvatar) {
    this.customAvatar = customAvatar;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
