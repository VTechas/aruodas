package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class House {
    public WebDriver driver;
    public String region;
    public String district;
    public String quartal;
    public String street;
    public String houseNum;
    public boolean cbShowHouseNum;
    public String rcNum;
    public boolean cbShowRcNum;
    public String areaSize;

    public int houseHeight;
    public String areaLot;
    public boolean cbWithoutLot;
    public String years;
    public boolean renovated;
    public String renovatedYears;

    public int buildingType;
    public int houseType;
    public int houseState;
    public int roomNum;

    public int[] warmSystem;
    public int waterAccumName;
    public String waterAccumDist;
    public int[] waterSystem;
    public int[] specials;
    public int houseEfficiency;
    public boolean interestedChange;
    public boolean auction;
    public String notes_lt;
    public String notes_en;
    public String notes_ru;
    public String[] photos;
    public String video;
    public String tour3d;
    public String price;
    public String phoneNum;
    public String email;
    public boolean cbDontShowInAds;
    public boolean cbDontWantChat;
    public int accountType;
    public boolean cbAgreeToRules;


    public House(WebDriver driver, String region, String district, String quartal, String street, String houseNum, boolean cbShowHouseNum, String rcNum, boolean cbShowRcNum, String areaSize, int houseHeight, String areaLot, boolean cbWithoutLot, String years, boolean renovated, String renovatedYears, int buildingType, int houseType, int houseState, int roomNum, int[] warmSystem, int waterAccumName, String waterAccumDist, int[] waterSystem, int[] specials, int houseEfficiency, boolean interestedChange, boolean auction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phoneNum, String email, boolean cbDontShowInAds, boolean cbDontWantChat, int accountType, boolean cbAgreeToRules) {
        this.driver = driver;
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.houseNum = houseNum;
        this.cbShowHouseNum = cbShowHouseNum;
        this.rcNum = rcNum;
        this.cbShowRcNum = cbShowRcNum;
        this.areaSize = areaSize;
        this.houseHeight = houseHeight;
        this.areaLot = areaLot;
        this.cbWithoutLot = cbWithoutLot;
        this.years = years;
        this.renovated = renovated;
        this.renovatedYears = renovatedYears;
        this.buildingType = buildingType;
        this.houseType = houseType;
        this.houseState = houseState;
        this.roomNum = roomNum;
        this.warmSystem = warmSystem;
        this.waterAccumName = waterAccumName;
        this.waterAccumDist = waterAccumDist;
        this.waterSystem = waterSystem;
        this.specials = specials;
        this.houseEfficiency = houseEfficiency;
        this.interestedChange = interestedChange;
        this.auction = auction;
        this.notes_lt = notes_lt;
        this.notes_en = notes_en;
        this.notes_ru = notes_ru;
        this.photos = photos;
        this.video = video;
        this.tour3d = tour3d;
        this.price = price;
        this.phoneNum = phoneNum;
        this.email = email;
        this.cbDontShowInAds = cbDontShowInAds;
        this.cbDontWantChat = cbDontWantChat;
        this.accountType = accountType;
        this.cbAgreeToRules = cbAgreeToRules;
    }

    public void fill(){
        fillRegion();
        fillDistrict();
        fillQuartal();
        fillStreet();
        fillObjNum();
        fillShowHouseNum();
        fillRcNum();
        fillShowRcNum();
        fillAreaSize();
        
        fillHouseHeight();
    }

    private void fillHouseHeight() {
        if (this.houseHeight == 1 || this.houseHeight == 2) {
            driver.findElement(By.cssSelector(".input-button[data-value='" + this.houseHeight + "']")).click();
        } else {
            WebElement inputField = driver.findElement(By.cssSelector("div.input-buttons-wrapper.with-input input[placeholder='Įveskite']"));
            inputField.click();
            inputField.sendKeys(String.valueOf(this.houseHeight));
        }
    }

    private void fillAreaSize() {
        driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.areaSize);
    }

    private void fillShowRcNum() {
        if (!this.cbShowRcNum) {
            driver.findElement(By.cssSelector("label[for='cbshow_rc_number'] span")).click();
        }
    }

    private void fillRcNum() {
        driver.findElement(By.name("RCNumber")).sendKeys(this.rcNum);
    }

    private void fillShowHouseNum() {
        if (!this.cbShowHouseNum) {
            driver.findElement(By.cssSelector("label[for='cbshow_house_num'] span")).click();
        }
    }

    private void fillObjNum() {
        driver.findElement(By.name("FHouseNum")).sendKeys(this.houseNum);
    }

    private void fillStreet() {
        driver.findElements(By.className("dropdown-input-value-title")).get(3).click();
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(4).sendKeys(this.street);
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(4).sendKeys(Keys.ENTER);
    }

    private void fillQuartal() {
        driver.findElements(By.className("dropdown-input-value-title")).get(2).click();
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(1).sendKeys(this.quartal);
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(1).sendKeys(Keys.ENTER);
    }

    private void fillDistrict() {
    }

    private void fillRegion() {
        driver.findElements(By.className("dropdown-input-value-title")).get(0).click();
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(0).sendKeys(this.region);
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(0).sendKeys(Keys.ENTER);
    }

    public void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }




















}
