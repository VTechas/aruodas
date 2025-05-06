package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Flat extends RealEstate {
    public String apartNum;
    public boolean showApartNum;
    public String areaSize;
    public int roomCount;
    public int floor;
    public int houseHeight;
    public boolean elevator;
    public String years;
    public boolean renovated;
    public String renovatedYears;
    public String houseType;
    public String houseState;
    public String[] warmSystem;
    public String apartmentType;
    public String apartmentIntendance;
    public String[] windowsDirection;
    public String houseEfficiency;

    public Flat(String region, String district, String quartal, String street, String houseNum, boolean showHouseNum, String rcNum, boolean showRcNum, boolean interestedChange, boolean auction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phoneNum, String email, boolean dontShowInAds, boolean dontWantChat, int accountType, boolean agreeToRules, String[] specials, String apartNum, boolean showApartNum, String areaSize, int roomCount, int floor, int houseHeight, boolean elevator, String years, boolean renovated, String renovatedYears, String houseType, String houseState, String[] warmSystem, String apartmentType, String apartmentIntendance, String[] windowsDirection, String houseEfficiency) {
        super(region, district, quartal, street, houseNum, showHouseNum, rcNum, showRcNum, interestedChange, auction, notes_lt, notes_en, notes_ru, photos, video, tour3d, price, phoneNum, email, dontShowInAds, dontWantChat, accountType, agreeToRules, specials);
        this.apartNum = apartNum;
        this.showApartNum = showApartNum;
        this.areaSize = areaSize;
        this.roomCount = roomCount;
        this.floor = floor;
        this.houseHeight = houseHeight;
        this.elevator = elevator;
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
    public void fill() {
        super.fill();
        fillAreaSize();
        fillRoomCount();
        fillFloor();
        fillHouseHeight();
        fillElevator();
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
        if (this.houseEfficiency.isEmpty()) return;
        List<WebElement> buttons = driver.findElements(By.className("input-button"));

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getAttribute("data-title").equals(this.houseEfficiency)) {
                buttons.get(i).click();
                break;
            }
        }
    }

    private void fillWindowsDirections() {
        if (this.windowsDirection.length == 0) return;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 0; i < windowsDirection.length; i++) {

            String direction = windowsDirection[i];

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[translate(normalize-space(@data-title), 'ABCDEFGHIJKLMNOPQRSTUVWXYZĄČĘĖĮŠŲŪŽabcdefghijklmnopqrstuvwxyząčęėįšųūž', 'abcdefghijklmnopqrstuvwxyzaceeisuuzabcdefghijklmnopqrstuvwxyzaceeisuuz') = '"
                            + normalizeSpecial(direction.toLowerCase()) + "']/following-sibling::label"))).click();

        }
    }

    private void fillApartmentType() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if (this.apartmentType.isEmpty()) {
            driver.findElement(By.cssSelector(".input-buttons-wrapper[data-key='ApartmentType'] .input-button[data-title='Butas']")).click();
        } else {
            WebElement typeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".input-buttons-wrapper[data-key='ApartmentType'] .input-button[data-title='" + this.apartmentType + "']")));
            typeButton.click();

            if ("Patalpa".equals(this.apartmentType)) {
                if (this.apartmentIntendance.isEmpty()) return;
                WebElement intendanceButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".input-buttons-wrapper[data-key='ApartmentIntendance'] .input-button[data-title='" + this.apartmentIntendance + "']")));
                intendanceButton.click();
            }
        }
    }

    private void fillWarmSystem() {
        if (this.warmSystem.length == 0) return;
        for (int i = 0; i < this.warmSystem.length; i++) {
            try {
                driver.findElement(By.xpath("//div[@class='input-style-checkbox']//label[contains(., '" + this.warmSystem[i] + "')]")).click();
            } catch (Exception e) {}
        }
    }

    private void fillHouseState() {
        if (this.houseState.isEmpty()) return;
        driver.findElement(By.xpath("//div[contains(@class,'input-button') and @data-value='" + this.houseState + "']")).click();
    }

    private void fillHouseType() {
        if (this.houseType.isEmpty()) return;
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

    private void fillElevator() {
        if (this.elevator) {
            driver.findElement(By.className("cbelevator_label")).click();
        }
    }

    private void fillHouseHeight() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if (this.houseHeight <= 0) return;
        int relativeHeightIndex = this.houseHeight - this.floor + 1;

        if (relativeHeightIndex < 1 || relativeHeightIndex > 9) {
            WebElement houseHeightInput = driver.findElement(By.name("FHouseHeight"));
            houseHeightInput.clear();
            houseHeightInput.sendKeys(String.valueOf(this.houseHeight));
        } else {
            WebElement dropdownArrow = driver.findElement(By.cssSelector("#fieldRow_FHouseHeight .input-style-dropdown .input-right-dropdown"));
            dropdownArrow.click();

            try {
                WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("#fieldRow_FHouseHeight .dropdown-input-values li[data-value='" + relativeHeightIndex + "']")));
                option.click();
            } catch (TimeoutException e) {
            }
        }
    }


    private void fillFloor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if (this.floor <= 0) return;
        if (this.floor > 4) {
            WebElement floorInput = driver.findElement(By.name("FFloor"));
            floorInput.clear();
            floorInput.sendKeys(String.valueOf(this.floor));
        } else {
            WebElement dropdownArrow = driver.findElement(By.cssSelector("#fieldRow_FFloor .input-style-dropdown .input-right-dropdown"));
            dropdownArrow.click();

            try {
                WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("#fieldRow_FFloor .dropdown-input-values li[data-value='" + this.floor + "']")));
                option.click();
            } catch (TimeoutException e) {
            }
        }
    }

    private void fillRoomCount() {
        if (this.roomCount <= 0) return;
        if (this.roomCount > 4) {
            WebElement input = driver.findElement(By.cssSelector("div[data-key='FRoomNum'] input[type='text']"));
            input.clear();
            input.sendKeys(String.valueOf(this.roomCount));
        } else {
            String roomCountStr = String.valueOf(this.roomCount);
            WebElement button = driver.findElement(By.cssSelector("div[data-key='FRoomNum'] .input-button[data-value='" + roomCountStr + "']"));
            button.click();
        }
    }

    private void fillAreaSize() {
        driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.areaSize);
    }

    private void fillApartNum() {
        driver.findElement(By.name("FApartNum")).sendKeys(this.apartNum);
    }

}
