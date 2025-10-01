//package com.restaurant.rms.models;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="MenuItem")
//public class MenuItem {
//    @Id
//    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
//    private int menuItemId;
//
//    private String menuItemName;
//    private String menuItemNum;
//    private double menuItemPrice;
//    private String menuItemCategory;
//    private int menuItemEstServeTime;
//
//    public MenuItem() {}
//    public MenuItem(String menuItemName, String menuItemNum, double menuItemPrice, String menuItemCategory, int menuItemEstServeTime) {
//        this.menuItemName = menuItemName;
//        this.menuItemNum = menuItemNum;
//        this.menuItemPrice = menuItemPrice;
//        this.menuItemCategory = menuItemCategory;
//        this.menuItemEstServeTime = menuItemEstServeTime;
//    }
//
//
//    public int getMenuItemId() {
//        return menuItemId;
//    }
//    public String getMenuItemName() {
//        return menuItemName;
//    }
//
//    public String getMenuItemNum() {
//        return menuItemNum;
//    }
//
//    public double getMenuItemPrice() {
//        return menuItemPrice;
//    }
//
//    public String getMenuItemCategory() {
//        return menuItemCategory;
//    }
//
//    public int getMenuItemEstServeTime() {
//        return menuItemEstServeTime;
//    }
//
//
//    public void setMenuItemId(int menuItemId) {
//        this.menuItemId = menuItemId;
//    }
//
//    public void setMenuItemName(String menuItemName) {
//        this.menuItemName = menuItemName;
//    }
//
//    public void setMenuItemNum(String menuItemNum) {
//        this.menuItemNum = menuItemNum;
//    }
//
//    public void setMenuItemPrice(double menuItemPrice) {
//        this.menuItemPrice = menuItemPrice;
//    }
//
//    public void setMenuItemCategory(String menuItemCategory) {
//        this.menuItemCategory = menuItemCategory;
//    }
//
//    public void setMenuItemEstServeTime(int menuItemEstServeTime) {
//        this.menuItemEstServeTime = menuItemEstServeTime;
//    }
//
//    public static MenuItem copy(MenuItem menuItem) {
//        return new MenuItem(
//                menuItem.getMenuItemName(),
//                menuItem.getMenuItemNum(),
//                menuItem.getMenuItemPrice(),
//                menuItem.getMenuItemCategory(),
//                menuItem.getMenuItemEstServeTime()
//        );
//    }
//
//    @Override
//    public String toString() {
//        return "MenuItem{" +
//                "menu_item_id=" + menuItemId +
//                ", menuItemName='" + menuItemName + '\'' +
//                ", menuItemNum='" + menuItemNum + '\'' +
//                ", menuItemPrice=" + menuItemPrice +
//                ", menuItemCategory='" + menuItemCategory + '\'' +
//                ", menuItemEstServeTime=" + menuItemEstServeTime +
//                '}';
//    }
//}

package com.restaurant.rms.models;

import jakarta.persistence.*;

//import java.util.ArrayList;
//import java.util.List;

@Entity
@Table(name="MenuItem")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int menuItemId;

    private String menuItemName;
    private String menuItemNum;
    private double menuItemPrice;
    private String menuItemCategory;
    private int menuItemEstServeTime;

//@OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL, orphanRemoval = true)
//private List<OrderDetail> orderDetail = new ArrayList<>();

    public MenuItem() {}
    public MenuItem(String menuItemName, String menuItemNum, double menuItemPrice, String menuItemCategory
            ,int menuItemEstServeTime
    ) {
        this.menuItemName = menuItemName;
        this.menuItemNum = menuItemNum;
        this.menuItemPrice = menuItemPrice;
        this.menuItemCategory = menuItemCategory;
        this.menuItemEstServeTime = menuItemEstServeTime;
    }


    public int getMenuItemId() {
        return menuItemId;
    }
    public String getMenuItemName() {
        return menuItemName;
    }

    public String getMenuItemNum() {
        return menuItemNum;
    }

    public double getMenuItemPrice() {
        return menuItemPrice;
    }

    public String getMenuItemCategory() {
        return menuItemCategory;
    }

    public int getMenuItemEstServeTime() {
        return menuItemEstServeTime;
    }


    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public void setMenuItemNum(String menuItemNum) {
        this.menuItemNum = menuItemNum;
    }

    public void setMenuItemPrice(double menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }

    public void setMenuItemCategory(String menuItemCategory) {
        this.menuItemCategory = menuItemCategory;
    }

    public void setMenuItemEstServeTime(int menuItemEstServeTime) {
        this.menuItemEstServeTime = menuItemEstServeTime;
    }

    public static MenuItem copy(MenuItem menuItem) {
        return new MenuItem(
                menuItem.getMenuItemName(),
                menuItem.getMenuItemNum(),
                menuItem.getMenuItemPrice(),
                menuItem.getMenuItemCategory()
                ,menuItem.getMenuItemEstServeTime()
        );
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menu_item_id=" + menuItemId +
                ", menuItemName='" + menuItemName + '\'' +
                ", menuItemNumber='" + menuItemNum + '\'' +
                ", menuItemPrice=" + menuItemPrice +
                ", menuItemCategory='" + menuItemCategory + '\''
                +
                ", menuItemEstServeTime=" + menuItemEstServeTime
                +
                '}';
    }
}

