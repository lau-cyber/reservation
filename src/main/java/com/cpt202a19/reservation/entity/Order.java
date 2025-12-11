package com.cpt202a19.reservation.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/** 订单数据的实体类 */
public class Order extends BaseEntity implements Serializable {
    private Integer oid;
    private Integer uid;
    private String recvName;
    private String recvTel;
    private String recvDepartment;
    private String recvMajor;
    private String recvGrade;
    private String recvDetails;
    private Long totalTime;
    private Integer status;
    private Date orderTime;
    private Date submitTime;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getRecvTel() {
        return recvTel;
    }

    public void setRecvTel(String recvTel) {
        this.recvTel = recvTel;
    }

    public String getRecvDepartment() {
        return recvDepartment;
    }

    public void setRecvDepartment(String recvDepartment) {
        this.recvDepartment = recvDepartment;
    }

    public String getRecvMajor() {
        return recvMajor;
    }

    public void setRecvMajor(String recvMajor) {
        this.recvMajor = recvMajor;
    }

    public String getRecvGrade() {
        return recvGrade;
    }

    public void setRecvGrade(String recvGrade) {
        this.recvGrade = recvGrade;
    }

    public String getRecvDetails() {
        return recvDetails;
    }

    public void setRecvDetails(String recvDetails) {
        this.recvDetails = recvDetails;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(getOid(), order.getOid()) && Objects.equals(getUid(), order.getUid()) && Objects.equals(getRecvName(), order.getRecvName()) && Objects.equals(getRecvTel(), order.getRecvTel()) && Objects.equals(getRecvDepartment(), order.getRecvDepartment()) && Objects.equals(getRecvMajor(), order.getRecvMajor()) && Objects.equals(getRecvGrade(), order.getRecvGrade()) && Objects.equals(getRecvDetails(), order.getRecvDetails()) && Objects.equals(getTotalTime(), order.getTotalTime()) && Objects.equals(getStatus(), order.getStatus()) && Objects.equals(getOrderTime(), order.getOrderTime()) && Objects.equals(getSubmitTime(), order.getSubmitTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOid(), getUid(), getRecvName(), getRecvTel(), getRecvDepartment(), getRecvMajor(), getRecvGrade(), getRecvDetails(), getTotalTime(), getStatus(), getOrderTime(), getSubmitTime());
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", recvName='" + recvName + '\'' +
                ", recvTel='" + recvTel + '\'' +
                ", recvDepartment='" + recvDepartment + '\'' +
                ", recvMajor='" + recvMajor + '\'' +
                ", recvGrade='" + recvGrade + '\'' +
                ", recvDetails='" + recvDetails + '\'' +
                ", totalTime=" + totalTime +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", submitTime=" + submitTime +
                '}';
    }

}