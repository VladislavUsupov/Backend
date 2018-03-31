package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatasetModel {
    @JsonProperty(value = "Id")
    private int id;
    @JsonProperty(value = "Caption")
    private String caption;
    @JsonProperty(value = "SefUrl")
    private String selfUrl;
    @JsonProperty(value = "LastUpdateDate")
    private String lastUpdateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getSelfUrl() {
        return selfUrl;
    }

    public void setSelfUrl(String selfUrl) {
        this.selfUrl = selfUrl;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "DatasetModel{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", selfUrl='" + selfUrl + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                '}';
    }
}
