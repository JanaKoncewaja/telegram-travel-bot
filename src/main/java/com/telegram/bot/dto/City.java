package com.telegram.bot.dto;

public class City {

private Long id;
private String cityName;
private String outPutMessage;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getOutPutMessage() {
        return outPutMessage;
    }

    public void setOutPutMessage(String outPutMessage) {
        this.outPutMessage = outPutMessage;
    }

    public City(String cityName, String outPutMessage) {
        this.cityName = cityName;
        this.outPutMessage = outPutMessage;
    }
}
