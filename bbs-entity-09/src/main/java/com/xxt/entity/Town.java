package com.xxt.entity;

import com.xxt.common.base.BaseEntity;

public class Town extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;
    /** 区县编码 */
    private String code;
    /** 区县名称 */
    private String name;
    /** 所属城市编码 */
    private String city;

    /*field end*/

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    /*method end*/

	@Override
	public String toString() {
		return "Town [id=" + id + ", code=" + code + ", name=" + name + ", city=" + city+"]";
	}
}
