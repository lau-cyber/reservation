package com.cpt202a19.reservation.entity;

import java.util.Objects;
import java.io.Serializable;

/** Information entity */
public class Information extends BaseEntity implements Serializable{

    private Integer rid;
    private Integer uid;
    private String name;
    private String departmentName;
    private String departmentCode;
    private String majorName;
    private String majorCode;
    private String gradeName;
    private String gradeCode;
    private String stId;
    private String details;
    private String mail;
    private String tel;
    private String tag;
    private Integer isDefault;

    public Integer getRid() { return rid; }

    public void setRid(Integer rid) { this.rid = rid; }

    public Integer getUid() { return uid; }

    public void setUid(Integer uid) { this.uid = uid; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDepartmentName() { return departmentName; }

    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getDepartmentCode() { return departmentCode; }

    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }

    public String getMajorName() { return majorName; }

    public void setMajorName(String majorName) { this.majorName = majorName; }

    public String getMajorCode() { return majorCode; }

    public void setMajorCode(String majorCode) { this.majorCode = majorCode; }

    public String getGradeName() { return gradeName; }

    public void setGradeName(String gradeName) { this.gradeName = gradeName; }

    public String getGradeCode() { return gradeCode; }

    public void setGradeCode(String gradeCode) { this.gradeCode = gradeCode; }

    public String getStId() { return stId; }

    public void setStId(String stId) { this.stId = stId; }

    public String getDetails() { return details; }

    public void setDetails(String details) { this.details = details; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getTel() { return tel; }

    public void setTel(String tel) { this.tel = tel; }

    public String getTag() { return tag; }

    public void setTag(String tag) { this.tag = tag; }

    public Integer getIsDefault() { return isDefault; }

    public void setIsDefault(Integer isDefault) { this.isDefault = isDefault; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Information)) return false;
        if (!super.equals(o)) return false;
        Information inforamtion1 = (Information) o;
        return Objects.equals(getRid(), inforamtion1.getRid()) && Objects.equals(getUid(), inforamtion1.getUid()) && Objects.equals(getName(), inforamtion1.getName()) && Objects.equals(getDepartmentName(), inforamtion1.getDepartmentName()) && Objects.equals(getDepartmentCode(), inforamtion1.getDepartmentCode()) && Objects.equals(getMajorName(), inforamtion1.getMajorName()) && Objects.equals(getMajorCode(), inforamtion1.getMajorCode()) && Objects.equals(getGradeName(), inforamtion1.getGradeName()) && Objects.equals(getGradeCode(), inforamtion1.getGradeCode()) && Objects.equals(getStId(), inforamtion1.getStId()) && Objects.equals(getDetails(), inforamtion1.getDetails()) && Objects.equals(getMail(), inforamtion1.getMail()) && Objects.equals(getTel(), inforamtion1.getTel()) && Objects.equals(getTag(), inforamtion1.getTag()) && Objects.equals(getIsDefault(), inforamtion1.getIsDefault());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRid(), getUid(), getName(), getDepartmentName(), getDepartmentCode(), getMajorName(), getMajorCode(), getGradeName(), getGradeCode(), getStId(), getDetails(), getMail(), getTel(), getTag(), getIsDefault());
    }

    @Override
    public String toString() {
        return "Information{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", majorName='" + majorName + '\'' +
                ", majorCode='" + majorCode + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", gradeCode='" + gradeCode + '\'' +
                ", stId='" + stId + '\'' +
                ", details='" + details + '\'' +
                ", mail='" + mail + '\'' +
                ", tel='" + tel + '\'' +
                ", tag='" + tag + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }

}