package com.example.demo.domain;

import com.example.demo.domain.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lijiyang on 2018/8/22.
 */
@Table(name = "house_info")
@Entity
public class HouseInfo extends BaseEntity{
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 36, precision = 0)
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" ,strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "titile",nullable = false)
    private String titile;

    @Column(name = "sub_titile",nullable = false)
    private String subTitile;

    @Column(name = "price",nullable = false)
    private Float price = 0F;

    @Column(name = "total_price",nullable = false)
    private Float totalPrice = 0F;

    @Column(name = "area",nullable = false)
    private String area = "";//所在区域

    @Column(name = "house_type",nullable = false)
    private String houseType = "";//户型

    @Column(name = "xiaoqu",nullable = false)
    private String xiaoqu;

    @Column(name = "lianjia_id",nullable = false)
    private String lianjiaID = "";

    @Column(name = "lianjia_id",nullable = false)
    private Date snapDate = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getSubTitile() {
        return subTitile;
    }

    public void setSubTitile(String subTitile) {
        this.subTitile = subTitile;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getArea() {
        return area;
    }

    public Date getSnapDate() {
        return snapDate;
    }

    public void setSnapDate(Date snapDate) {
        this.snapDate = snapDate;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getLianjiaID() {
        return lianjiaID;
    }

    public void setLianjiaID(String lianjiaID) {
        this.lianjiaID = lianjiaID;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "titile='" + titile + '\'' +
                ", subTitile='" + subTitile + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", area='" + area + '\'' +
                ", houseType='" + houseType + '\'' +
                ", xiaoqu='" + xiaoqu + '\'' +
                ", lianjiaID='" + lianjiaID + '\'' +
                '}';
    }
}
