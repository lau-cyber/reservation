package com.cpt202a19.reservation.entity;

import java.io.Serializable;
import java.util.Objects;

public class Room extends BaseEntity implements Serializable {
    private Integer id;
    private Integer categoryId;
    private String itemType;
    private String title;
    private String point;
    private Double rotime;
    private Integer num;
    private String image;
    private Integer status;
    private Integer priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) && Objects.equals(categoryId, room.categoryId) && Objects.equals(itemType, room.itemType) && Objects.equals(title, room.title) && Objects.equals(point, room.point) && Objects.equals(rotime, room.rotime) && Objects.equals(num, room.num) && Objects.equals(image, room.image) && Objects.equals(status, room.status) && Objects.equals(priority, room.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, categoryId, itemType, title, point, rotime, num, image, status, priority);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", itemType='" + itemType + '\'' +
                ", title='" + title + '\'' +
                ", point='" + point + '\'' +
                ", rotime=" + rotime +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
