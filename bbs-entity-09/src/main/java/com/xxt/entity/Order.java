package com.xxt.entity;

import com.xxt.common.base.BaseEntity;

public class Order extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 订单号 */
    private String oid;
    /** 运费 */
    private java.math.BigDecimal deliverFee;
    /** 应付金额 */
    private Double payableFee;
    /** 订单金额 */
    private Double totalPrice;
    /** 支付方式 0:到付 1:在线 2:邮局 3:公司转帐 */
    private Short paymentWay;
    /** 货到付款方式.1现金,2POS刷卡 */
    private Short paymentCash;
    /** 送货时间 */
    private Short delivery;
    /** 是否电话确认 1:是  0: 否 */
    private Short isConfirm;
    /** 支付状态 :0到付1待付款,2已付款,3待退款,4退款成功,5退款失败 */
    private Short isPaiy;
    /** 订单状态 0:提交订单 1:仓库配货 2:商品出库 3:等待收货 4:完成 5待退货 6已退货 */
    private Short state;
    /** 订单生成时间 */
    private java.util.Date createDate;
    /** 附言 */
    private String note;
    /** 用户名 */
    private String buyerId;

    /*field end*/

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOid() {
        return oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }
    public java.math.BigDecimal getDeliverFee() {
        return deliverFee;
    }
    public void setDeliverFee(java.math.BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }
    public Double getPayableFee() {
        return payableFee;
    }
    public void setPayableFee(Double payableFee) {
        this.payableFee = payableFee;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Short getPaymentWay() {
        return paymentWay;
    }
    public void setPaymentWay(Short paymentWay) {
        this.paymentWay = paymentWay;
    }
    public Short getPaymentCash() {
        return paymentCash;
    }
    public void setPaymentCash(Short paymentCash) {
        this.paymentCash = paymentCash;
    }
    public Short getDelivery() {
        return delivery;
    }
    public void setDelivery(Short delivery) {
        this.delivery = delivery;
    }
    public Short getIsConfirm() {
        return isConfirm;
    }
    public void setIsConfirm(Short isConfirm) {
        this.isConfirm = isConfirm;
    }
    public Short getIsPaiy() {
        return isPaiy;
    }
    public void setIsPaiy(Short isPaiy) {
        this.isPaiy = isPaiy;
    }
    public Short getState() {
        return state;
    }
    public void setState(Short state) {
        this.state = state;
    }
    public java.util.Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    /*method end*/

	@Override
	public String toString() {
		return "Order [id=" + id + ", oid=" + oid + ", deliverFee=" + deliverFee + ", payableFee=" + payableFee + ", totalPrice=" + totalPrice + ", paymentWay=" + paymentWay + ", paymentCash=" + paymentCash + ", delivery=" + delivery + ", isConfirm=" + isConfirm + ", isPaiy=" + isPaiy + ", state=" + state + ", createDate=" + createDate + ", note=" + note + ", buyerId=" + buyerId+"]";
	}
}
