package com.abuziyo.ziyotrans.entity;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "cardoc")
public class CarDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nameDrive")
    private String nameDrive;

    @Column(name = "tirNumber")
    private String tirNumber;

    @Column(name = "wayBill")
    private String wayBill;

    @Column(name = "numberCMR")
    private String numberCMR;

    @Column(name = "numberCMR2")
    private String numberCMR2;

    @Column(name = "dazvol")
    private String dazvol;

    @Column(name = "comUdos")
    private String comUdos;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "checkTirNum")
    private int checkTirNum;

    @Column(name = "checkWayBill")
    private int checkWayBill;

    @Column(name = "checkCmr")
    private int checkCmr;

    @Column(name = "checkCmr2")
    private     int checkCmr2;

    @Column(name = "checkDazvol")
    private int checkDazvol;

    @Column(name = "checkcomUdos")
    private int checkcomUdos;

    @Column(name = "checkAll")
    private int checkAll;


    @ManyToOne(targetEntity = CarNumber.class)
    @JoinColumn(name = "car_fk", referencedColumnName = "id")
    @NotNull
    private CarNumber carNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDrive() {
        return nameDrive;
    }

    public void setNameDrive(String nameDrive) {
        this.nameDrive = nameDrive;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTirNumber() {
        return tirNumber;
    }

    public void setTirNumber(String tirNumber) {
        this.tirNumber = tirNumber;
    }

    public String getWayBill() {
        return wayBill;
    }

    public void setWayBill(String wayBill) {
        this.wayBill = wayBill;
    }

    public String getNumberCMR() {
        return numberCMR;
    }

    public void setNumberCMR(String numberCMR) {
        this.numberCMR = numberCMR;
    }

    public String getNumberCMR2() {
        return numberCMR2;
    }

    public void setNumberCMR2(String numberCMR2) {
        this.numberCMR2 = numberCMR2;
    }

    public String getDazvol() {
        return dazvol;
    }

    public void setDazvol(String dazvol) {
        this.dazvol = dazvol;
    }

    public String getComUdos() {
        return comUdos;
    }

    public void setComUdos(String comUdos) {
        this.comUdos = comUdos;
    }

    public int getCheckTirNum() {
        return checkTirNum;
    }

    public void setCheckTirNum(int checkTirNum) {
        this.checkTirNum = checkTirNum;
    }

    public int getCheckWayBill() {
        return checkWayBill;
    }

    public void setCheckWayBill(int checkWayBill) {
        this.checkWayBill = checkWayBill;
    }

    public int getCheckCmr() {
        return checkCmr;
    }

    public void setCheckCmr(int checkCmr) {
        this.checkCmr = checkCmr;
    }

    public int getCheckCmr2() {
        return checkCmr2;
    }

    public void setCheckCmr2(int checkCmr2) {
        this.checkCmr2 = checkCmr2;
    }

    public int getCheckDazvol() {
        return checkDazvol;
    }

    public void setCheckDazvol(int checkDazvol) {
        this.checkDazvol = checkDazvol;
    }

    public int getCheckAll() {
        return checkAll;
    }

    public void setCheckAll(int checkAll) {
        this.checkAll = checkAll;
    }

    public CarNumber getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(CarNumber carNumber) {
        this.carNumber = carNumber;
    }

    public int getCheckcomUdos() {
        return checkcomUdos;
    }

    public void setCheckcomUdos(int checkcomUdos) {
        this.checkcomUdos = checkcomUdos;
    }

}

