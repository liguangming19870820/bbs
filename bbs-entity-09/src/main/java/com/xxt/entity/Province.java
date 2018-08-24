package com.xxt.entity;

import com.xxt.common.base.BaseEntity;

public class Province extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;
    /** 省份编码 */
    private String code;
    /** 省份名称 */
    private String name;

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

    /*method end*/

	@Override
	public String toString() {
		return "Province [id=" + id + ", code=" + code + ", name=" + name+"]";
	}
}
