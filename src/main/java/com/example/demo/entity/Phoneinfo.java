package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Phoneinfo {

    @Id
    private int phone_id;
    private String phone_name;
    private String phone_place;
    private int phone_price;
    private Date phone_date;
    private String phone_type;


    public Phoneinfo(){}

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public String getPhone_name() {
        return phone_name;
    }

    public void setPhone_name(String phone_name) {
        this.phone_name = phone_name;
    }

    public String getPhone_place() {
        return phone_place;
    }

    public void setPhone_place(String phone_place) {
        this.phone_place = phone_place;
    }

    public int getPhone_price() {
        return phone_price;
    }

    public void setPhone_price(int phone_price) {
        this.phone_price = phone_price;
    }

    public Date getPhone_date() {
        return phone_date;
    }

    public void setPhone_date(Date phone_date) {
        this.phone_date = phone_date;
    }

    public String getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(String phone_type) {
        this.phone_type = phone_type;
    }



}
