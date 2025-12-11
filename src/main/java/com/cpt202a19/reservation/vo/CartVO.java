package com.cpt202a19.reservation.vo;

import java.io.Serializable;

/** reservation-list data's Value Object class */
public class CartVO implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer roid;
    private Double rotime;
    private Integer num;
    private String title;
    private String image;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRoid() {
        return roid;
    }

    public void setRoid(Integer roid) {
        this.roid = roid;
    }

    public Double getRotime() {
        return rotime;
    }

    public void setRotime(Double rotime) {
        this.rotime = rotime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartVO)) return false;

        CartVO cartVO = (CartVO) o;

        if (getCid() != null ? !getCid().equals(cartVO.getCid()) : cartVO.getCid() != null) return false;
        if (getUid() != null ? !getUid().equals(cartVO.getUid()) : cartVO.getUid() != null) return false;
        if (getRoid() != null ? !getRoid().equals(cartVO.getRoid()) : cartVO.getRoid() != null) return false;
        if (getRotime() != null ? !getRotime().equals(cartVO.getRotime()) : cartVO.getRotime() != null) return false;
        if (getNum() != null ? !getNum().equals(cartVO.getNum()) : cartVO.getNum() != null) return false;
        if (getTitle() != null ? !getTitle().equals(cartVO.getTitle()) : cartVO.getTitle() != null) return false;
        return getImage() != null ? getImage().equals(cartVO.getImage()) : cartVO.getImage() == null;
    }

    @Override
    public int hashCode() {
        int result = getCid() != null ? getCid().hashCode() : 0;
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getRoid() != null ? getRoid().hashCode() : 0);
        result = 31 * result + (getRotime() != null ? getRotime().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", roid=" + roid +
                ", rotime=" + rotime +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
