package com.xxt.entity;

import com.xxt.common.base.BaseEntity;

public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 商品编号 */
    private String no;
    /** 商品名称 */
    private String name;
    /** 重量 单位:克 */
    private Double weight;
    /** 是否新品:0:旧品,1:新品 */
    private Short isNew;
    /** 是否热销:0,否 1:是 */
    private Short isHot;
    /** 推荐 1推荐 0 不推荐 */
    private Short isCommend;
    /** 添加时间 */
    private java.util.Date createTime;
    /** 添加人ID */
    private String createUserId;
    /** 审核时间 */
    private java.util.Date checkTime;
    /** 审核人ID */
    private String checkUserId;
    /** 上下架:0否 1是 */
    private Short isShow;
    /** 是否删除:0删除,1,没删除 */
    private Short isDel;
    /** 类型ID */
    private Integer typeId;
    /** 品牌ID */
    private Integer brandId;
    /** 检索关键词 */
    private String keywords;
    /** 销量 */
    private Integer sales;
    /** 商品描述 */
    private String description;
    /** 包装清单 */
    private String packageList;
    /** 商品属性集 */
    private String feature;
    /** 颜色集 */
    private String color;
    /** 尺寸集 */
    private String size;
    
    private String imgUrl;

    /*field end*/
    

    public Integer getId() {
        return id;
    }
    public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public void setId(Integer id) {
        this.id = id;
    }
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Short getIsNew() {
        return isNew;
    }
    public void setIsNew(Short isNew) {
        this.isNew = isNew;
    }
    public Short getIsHot() {
        return isHot;
    }
    public void setIsHot(Short isHot) {
        this.isHot = isHot;
    }
    public Short getIsCommend() {
        return isCommend;
    }
    public void setIsCommend(Short isCommend) {
        this.isCommend = isCommend;
    }
    public java.util.Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    public String getCreateUserId() {
        return createUserId;
    }
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
    public java.util.Date getCheckTime() {
        return checkTime;
    }
    public void setCheckTime(java.util.Date checkTime) {
        this.checkTime = checkTime;
    }
    public String getCheckUserId() {
        return checkUserId;
    }
    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId;
    }
    public Short getIsShow() {
        return isShow;
    }
    public void setIsShow(Short isShow) {
        this.isShow = isShow;
    }
    public Short getIsDel() {
        return isDel;
    }
    public void setIsDel(Short isDel) {
        this.isDel = isDel;
    }
    public Integer getTypeId() {
        return typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public Integer getBrandId() {
        return brandId;
    }
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public Integer getSales() {
        return sales;
    }
    public void setSales(Integer sales) {
        this.sales = sales;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPackageList() {
        return packageList;
    }
    public void setPackageList(String packageList) {
        this.packageList = packageList;
    }
    public String getFeature() {
        return feature;
    }
    public void setFeature(String feature) {
        this.feature = feature;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
	@Override
	public String toString() {
		return "Product [id=" + id + ", no=" + no + ", name=" + name + ", weight=" + weight + ", isNew=" + isNew
				+ ", isHot=" + isHot + ", isCommend=" + isCommend + ", createTime=" + createTime + ", createUserId="
				+ createUserId + ", checkTime=" + checkTime + ", checkUserId=" + checkUserId + ", isShow=" + isShow
				+ ", isDel=" + isDel + ", typeId=" + typeId + ", brandId=" + brandId + ", keywords=" + keywords
				+ ", sales=" + sales + ", description=" + description + ", packageList=" + packageList + ", feature="
				+ feature + ", color=" + color + ", size=" + size + ", imgUrl=" + imgUrl + "]";
	}
    

    /*method end*/

    
    
}
