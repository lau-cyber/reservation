package com.cpt202a19.reservation.entity;

import java.io.Serializable;
import java.util.Objects;

/** 订单中的商品数据 */
public class OrderItem extends BaseEntity implements Serializable {
    private Integer id;
    private Integer oid;
    private Integer roid;
    private String title;
    private String image;
    private Double time;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getRoid() {
        return roid;
    }

    public void setRoid(Integer roid) {
        this.roid = roid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        if (!super.equals(o)) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(getId(), orderItem.getId()) && Objects.equals(getOid(), orderItem.getOid()) && Objects.equals(getRoid(), orderItem.getRoid()) && Objects.equals(getTitle(), orderItem.getTitle()) && Objects.equals(getImage(), orderItem.getImage()) && Objects.equals(getTime(), orderItem.getTime()) && Objects.equals(getNum(), orderItem.getNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getOid(), getRoid(), getTitle(), getImage(), getTime(), getNum());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", oid=" + oid +
                ", roid=" + roid +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", time=" + time +
                ", num=" + num +
                '}';
    }

}