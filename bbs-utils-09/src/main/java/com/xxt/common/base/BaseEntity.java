package com.xxt.common.base;

import java.io.Serializable;

import com.xxt.common.config.Config;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    protected Integer pageNo = 1;
    protected Integer startRow;
    protected Integer pageSize = Config.PAGE_SIZE;
    
    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }
    public Integer getPageNo() {
        return pageNo;
    }
    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }
    public Integer getStartRow() {
        return startRow;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }
    public Integer getPageSize() {
        return pageSize;
    }
}
