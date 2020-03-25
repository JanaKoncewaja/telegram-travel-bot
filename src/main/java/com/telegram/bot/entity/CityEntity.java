package com.telegram.bot.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "cityentity")
public class CityEntity {

    @Id
    @GeneratedValue/*(strategy = GenerationType.IDENTITY)*/
    private Long id;


    @Column(name = "cityentityname")
    private String cityEntityName;


    @Column(name = "outputmessage")
    private String outPutMessage;


    public CityEntity() {
    }

    public CityEntity(@NotNull String cityEntityName, @NotNull String outPutMessage) {
        this.cityEntityName = cityEntityName;
        this.outPutMessage = outPutMessage;
    }

    public CityEntity(Long id, @NotNull String cityEntityName, @NotNull String outPutMessage) {
        this.id = id;
        this.cityEntityName = cityEntityName;
        this.outPutMessage = outPutMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityEntityName() {
        return cityEntityName;
    }

    public void setCityEntityName(String cityEntityName) {
        this.cityEntityName = cityEntityName;
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
                Objects.equals(cityEntityName, that.cityEntityName) &&
                Objects.equals(outPutMessage, that.outPutMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityEntityName, outPutMessage);
    }
}
