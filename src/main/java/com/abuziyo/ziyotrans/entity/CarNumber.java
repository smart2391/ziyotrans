package com.abuziyo.ziyotrans.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "carnum")
public class CarNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String carNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    @Override
    public String toString() {
        return "CarNumber{" +
                "id=" + id +
                ", carNum='" + carNum + '\'' +
                '}';
    }
}
