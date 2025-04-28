package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Plot extends RealEstate {
    public String areaSize;
    public String[] intendances;

    public Plot(WebDriver driver, String region, String district, String quartal, String street, String houseNum, boolean showHouseNum, String rcNum, boolean showRcNum, boolean interestedChange, boolean auction, String notes_lt, String notes_en, String notes_ru, String[] photos, String video, String tour3d, String price, String phoneNum, String email, boolean dontShowInAds, boolean dontWantChat, int accountType, boolean agreeToRules, String[] specials, String areaSize, String[] intendances) {
        super(driver, region, district, quartal, street, houseNum, showHouseNum, rcNum, showRcNum, interestedChange, auction, notes_lt, notes_en, notes_ru, photos, video, tour3d, price, phoneNum, email, dontShowInAds, dontWantChat, accountType, agreeToRules, specials);
        this.areaSize = areaSize;
        this.intendances = intendances;
    }

    @Override
    public void fill () {
        super.fill();
        fillAreaSize();
        fillIntendances();
    }

    private void fillIntendances() {
        for (int i = 0; i < this.intendances.length; i++) {
            try {
                driver.findElement(By.xpath("//div[@class='input-style-checkbox']//label[contains(., '" + this.intendances[i] + "')]")).click();
            } catch (Exception e) {
            }
        }
    }

    private void fillAreaSize() {
        driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.areaSize);
    }
}
