package com.restaurant.rms.models.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MenuItemDTO {
    @NotEmpty(message = "Menu item name cannot be empty")
    private String menuItemName;

    @NotEmpty(message = "Menu item number cannot be empty")
    private String menuItemNum;

    @NotNull(message = "Menu item price cannot be empty")
    @Positive(message = "Menu item price cannot be negative")
    private double menuItemPrice;

    @NotEmpty(message = "Menu item category cannot be empty")
    private String menuItemCategory;

    @NotNull(message = "Menu item estimated serve time cannot be empty")
    private int menuItemEstServeTime;


    // getters and setters
    public @NotEmpty(message = "Menu item name cannot be empty") String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(@NotEmpty(message = "Menu item name cannot be empty") String menuItemName) {
        this.menuItemName = menuItemName;
    }


    public @NotEmpty(message = "Menu item number cannot be empty") String getMenuItemNum() {
        return menuItemNum;
    }

    public void setMenuItemNum(@NotEmpty(message = "Menu item number cannot be empty") String menuItemNum) {
        this.menuItemNum = menuItemNum;
    }


    public @NotNull(message = "Menu item price cannot be empty")
    @Positive(message = "Menu item price cannot be negative")
    double getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(@NotNull(message = "Menu item price cannot be empty")
                                 @Positive(message = "Menu item price cannot be negative")
                                 double menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }


    public @NotEmpty(message = "Menu item category cannot be empty") String getMenuItemCategory() {
        return menuItemCategory;
    }

    public void setMenuItemCategory(@NotEmpty(message = "Menu item category cannot be empty") String menuItemCategory) {
        this.menuItemCategory = menuItemCategory;
    }


    public @NotNull(message = "Menu item estimated serve time cannot be empty") int getMenuItemEstServeTime() {
        return menuItemEstServeTime;
    }

    public void setMenuItemEstServeTime(@NotNull(message = "Menu item estimated serve time cannot be empty") int menuItemEstServeTime) {
        this.menuItemEstServeTime = menuItemEstServeTime;
    }
}
