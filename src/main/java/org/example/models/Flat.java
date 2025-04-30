package org.example.models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Flat extends RealEstate{
    public String apartNum;
    public String areaSize;
    public int roomCount;
    public int floor;
    public int houseHeight;
    public boolean cbElevator;
    public String years;
    public boolean renovated;
    public String renovatedYears;
    public String houseType;
    public String houseState;
    public String[] warmSystem;
    public int apartmentType;
    public int apartmentIntendance;
    public int[] windowsDirection;
    public String houseEfficiency;

    public Flat(String region, String district, String quartal, String street, String houseNum, boolean showHouseNum, String rcNum, boolean showRcNum, boolean interestedChange, boolean auction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phoneNum, String email, boolean dontShowInAds, boolean dontWantChat, int accountType, boolean agreeToRules, String[] specials, String apartNum, String areaSize, int roomCount, int floor, int houseHeight, boolean cbElevator, String years, boolean renovated, String renovatedYears, String houseType, String houseState, String[] warmSystem, int apartmentType, int apartmentIntendance, int[] windowsDirection, String houseEfficiency) {
        super(region, district, quartal, street, houseNum, showHouseNum, rcNum, showRcNum, interestedChange, auction, notes_lt, notes_en, notes_ru, photos, video, tour3d, price, phoneNum, email, dontShowInAds, dontWantChat, accountType, agreeToRules, specials);
        this.apartNum = apartNum;
        this.areaSize = areaSize;
        this.roomCount = roomCount;
        this.floor = floor;
        this.houseHeight = houseHeight;
        this.cbElevator = cbElevator;
        this.years = years;
        this.renovated = renovated;
        this.renovatedYears = renovatedYears;
        this.houseType = houseType;
        this.houseState = houseState;
        this.warmSystem = warmSystem;
        this.apartmentType = apartmentType;
        this.apartmentIntendance = apartmentIntendance;
        this.windowsDirection = windowsDirection;
        this.houseEfficiency = houseEfficiency;
    }

    @Override
    public void fill(){
        super.fill();
        fillAreaSize();
        fillRoomCount();
        fillFloor();
        fillHouseHeight();
        fillCbElevator();
        fillYears();
        fillRenovated();
        fillHouseType();
        fillHouseState();
        fillWarmSystem();
        fillApartmentType();
        fillWindowsDirections();
        fillApartNum();
        fillHouseEfficiency();
    }

    private void fillHouseEfficiency() {
        List<WebElement> buttons = driver.findElements(By.className("input-button"));

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getAttribute("data-title").equals(this.houseEfficiency)) {
                buttons.get(i).click();
                break;
            }
        }
    }

    private void fillWindowsDirections() {
        for (int i = 0; i < this.windowsDirection.length; i++) {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/div/div/div[1]/div[" + this.windowsDirection[i] + "]/label")).click();
        }
    }

    private void fillApartmentType() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/div/div[" + this.apartmentType + "]")).click();
        if (this.apartmentType == 2) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[23]/div/div[" + this.apartmentIntendance + "]")).click();
        }
    }

    private void fillWarmSystem() {
        for (int i = 0; i < this.warmSystem.length; i++) {
            try {
                driver.findElement(By.xpath("//div[@class='input-style-checkbox']//label[contains(., '" + this.warmSystem[i] + "')]")).click();
            } catch (Exception e) {
            }
        }
    }

    private void fillHouseState() {
        driver.findElement(By.xpath("//div[contains(@class,'input-button') and @data-value='" + this.houseState + "']")).click();
    }

    private void fillHouseType() {
        driver.findElement(By.xpath("//div[contains(@class,'input-button') and @data-value='" + this.houseType + "']")).click();
    }

    private void fillRenovated() {
        if (this.renovated) {
            driver.findElement(By.className("cbrenovated_label")).click();
            driver.findElement(By.id("FRenovatedYear")).sendKeys(this.renovatedYears);
        }
    }

    private void fillYears() {
        driver.findElement(By.name("FBuildYear")).sendKeys(this.years);
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

    private void fillApartNum() {
        driver.findElement(By.name("FApartNum")).sendKeys(this.apartNum);
    }

}
