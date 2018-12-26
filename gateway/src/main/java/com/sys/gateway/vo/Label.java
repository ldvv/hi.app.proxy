package com.sys.gateway.vo;

public class Label {
    private Integer id;
    private String name;
    private Integer labelType;
    private Integer labelSystem;
    private Integer labelGroupId;
    private String desc;
    private Integer sort;
    private Integer status;
    private Integer creator;
    private String createDate;
    private String updateDate;
    private String remarks;
    private String matchCount;

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



    public Integer getLabelType() {
        return labelType;
    }

    public void setLabelType(Integer labelType) {
        this.labelType = labelType;
    }

    public Integer getLabelGroupId() {
        return labelGroupId;
    }

    public void setLabelGroupId(Integer labelGroupId) {
        this.labelGroupId = labelGroupId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getLabelSystem() {
        return labelSystem;
    }

    public void setLabelSystem(Integer labelSystem) {
        this.labelSystem = labelSystem;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(String matchCount) {
        this.matchCount = matchCount;
    }
}
