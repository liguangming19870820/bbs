package com.xxt.entity;

import com.xxt.common.base.BaseEntity;

public class Type extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 名称 */
    private String name;
    /** 父ID */
    private Integer parentId;
    /** 备注,用于google搜索页面描述 */
    private String note;
    /** 是否可见 1:可见 0:不可见 */
    private Short isDisplay;

    /*field end*/

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Short getIsDisplay() {
        return isDisplay;
    }
    public void setIsDisplay(Short isDisplay) {
        this.isDisplay = isDisplay;
    }

    /*method end*/

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", parentId=" + parentId + ", note=" + note + ", isDisplay=" + isDisplay+"]";
	}
}
