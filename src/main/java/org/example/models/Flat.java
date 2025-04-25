package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Flat {
    public WebDriver driver;
    public String region;
    public String district;
    public String quartal;
    public String street;
    public String objNum;
    public String apartNum;
    public String rcNum;
    public String areaSize;
    public int roomCount;
    public int floor;
    public int houseHeight;
    public boolean cbElevator;
    public String years;
    public boolean renovated;
    public int houseType;
    public int houseState;
    public int[] warmSystem;
    public int apartmentType;
    public int apartmentIntendance;
    public int[] windowsDirection;
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


    public Flat(WebDriver driver, String region, String district, String quartal, String street, String objNum, String apartNum, String rcNum, String areaSize, int roomCount, int floor, int houseHeight, boolean cbElevator, String years, boolean renovated, int houseType, int houseState, int[] warmSystem, int apartmentType, int apartmentIntendance, int[] windowsDirection, int[] specials, int houseEfficiency, boolean interestedChange, boolean auction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phoneNum, String email, boolean cbDontShowInAds, boolean cbDontWantChat, int accountType, boolean cbAgreeToRules) {
        this.driver = driver;
        this.region = region;
        this.district = district;
        this.quartal = quartal;
        this.street = street;
        this.objNum = objNum;
        this.apartNum = apartNum;
        this.rcNum = rcNum;
        this.areaSize = areaSize;
        this.roomCount = roomCount;
        this.floor = floor;
        this.houseHeight = houseHeight;
        this.cbElevator = cbElevator;
        this.years = years;
        this.renovated = renovated;
        this.houseType = houseType;
        this.houseState = houseState;
        this.warmSystem = warmSystem;
        this.apartmentType = apartmentType;
        this.apartmentIntendance = apartmentIntendance;
        this.windowsDirection = windowsDirection;
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

        fillApartNum();
        
        fillRcNum();
        fillAreaSize();
        
        fillRoomCount();
        fillFloor();
        fillHouseHeight();
        fillCbElevator();
    }

    private void fillCbElevator() {
        if (this.cbElevator) {
            driver.findElement(By.className("cbelevator_label")).click();
        }
    }

    private void fillHouseHeight() {
        driver.findElement(By.name("FHouseHeight")).sendKeys(String.valueOf(this.houseHeight));
    }


    private void fillFloor() {
        driver.findElement(By.name("FFloor")).sendKeys(String.valueOf(this.floor));
//        if (this.floor > 4) {
//            driver.findElement(By.name("FFloor")).sendKeys(String.valueOf(this.floor));
//        } else {
//            driver.findElements(By.className("input-right-dropdown")).get(4).click();
//            driver.findElements(By.className("dropdown-input-values")).get(1).click();
//            wait(500);
//            driver.findElement(By.xpath("//*[@id=\"fieldRow_FFloor\"]/div[1]/span[2]/ul/li[" + this.floor + "]")).click();
//        }
    }

    private void fillRoomCount() {
        if (this.roomCount > 4) {
            WebElement input = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[15]/div/span/input"));
            input.sendKeys(String.valueOf(this.roomCount));
        } else {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[15]/div/div[" + this.roomCount + "]")).click();

        }
    }

    private void fillAreaSize() {
        driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.areaSize);
    }

    private void fillRcNum() {
        driver.findElement(By.name("RCNumber")).sendKeys(this.rcNum);
    }

    private void fillApartNum() {
        driver.findElement(By.name("FApartNum")).sendKeys(this.apartNum);
    }

    private void fillObjNum() {
        driver.findElement(By.name("FHouseNum")).sendKeys(this.objNum);
    }

    private void fillStreet() {
        driver.findElements(By.className("dropdown-input-value-title")).get(3).click();
        wait(500);
        driver.findElements(By.className("dropdown-input-search-value")).get(5).sendKeys(this.street);  //keitesi get is 4 i 5
        wait(1000);
        driver.findElements(By.className("dropdown-input-search-value")).get(5).sendKeys(Keys.ENTER);   //keitesi get is 4 i 5
    }

    private void fillQuartal() {
        driver.findElements(By.className("dropdown-input-value-title")).get(2).click();
        wait(700);
        driver.findElements(By.className("dropdown-input-search-value")).get(2).sendKeys(this.quartal); //keitesi get is 1 i 2
        wait(700);
        driver.findElements(By.className("dropdown-input-search-value")).get(2).sendKeys(Keys.ENTER);   //keitesi get is 1 i 2
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
