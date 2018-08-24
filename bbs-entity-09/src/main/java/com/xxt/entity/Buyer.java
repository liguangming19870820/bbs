package com.xxt.entity;

import com.xxt.common.base.BaseEntity;

public class Buyer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /**  */
    private String gender;
    /** 邮箱 */
    private String email;
    /** 真实名字 */
    private String realName;
    /** 注册时间 */
    private java.util.Date registerTime;
    /** 省ID */
    private String province;
    /** 市ID */
    private String city;
    /** 县ID */
    private String town;
    /** 地址 */
    private String addr;
    /** 是否已删除:1:未,0:删除了 */
    private Short isDel;

    /*field end*/

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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public java.util.Date getRegisterTime() {
        return registerTime;
    }
    public void setRegisterTime(java.util.Date registerTime) {
        this.registerTime = registerTime;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = town;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public Short getIsDel() {
        return isDel;
    }
    public void setIsDel(Short isDel) {
        this.isDel = isDel;
    }

    /*method end*/

	@Override
	public String toString() {
		return "Buyer [username=" + username + ", password=" + password + ", gender=" + gender + ", email=" + email + ", realName=" + realName + ", registerTime=" + registerTime + ", province=" + province + ", city=" + city + ", town=" + town + ", addr=" + addr + ", isDel=" + isDel+"]";
	}
}
