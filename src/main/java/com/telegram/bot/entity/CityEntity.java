package com.telegram.bot.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "city_information")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String cityName;

    @NotNull
    @Column(name = "outPutMessage")
    private String outPutMessage;


    public CityEntity() {
    }

    public CityEntity(Long id, @NotNull String cityName, @NotNull String outPutMessage) {
        this.id = id;
        this.cityName = cityName;
        this.outPutMessage = outPutMessage;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(outPutMessage, that.outPutMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, outPutMessage);
    }
}
