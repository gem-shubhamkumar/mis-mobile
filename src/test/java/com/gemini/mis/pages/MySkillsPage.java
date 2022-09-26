package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MySkillsPage extends PageObject {

     CommonFunctions commonFunctions = new CommonFunctions();

     @Step("Verify if {0} card is present")
    public void verifyIfCardIsPresent(String cardName) {
         int flag = 0;

         waitABit(1000);

         List<WebElement> cards = getDriver().findElements(By.xpath(MySkillsLocators.cardNames));

         for (WebElement card : cards
         ) {
             if (card.getText().equals(cardName)) {
                 flag = 1;
                 break;
             }
         }
         if(flag == 0)
         Assert.fail("Card " + cardName + " is not present");
         else
             Assert.assertTrue(true);

     }

    @Step("Verify card is not empty")
    public void verifyCardNotEmpty() {
            Assert.assertFalse($(By.xpath(MySkillsLocators.tableDiv)).isPresent());
    }

    @Step("Click on skill {0}")
    public void clickASkill(String skill) {
         $(By.xpath(MySkillsLocators.skillName.replace("skill", skill))).waitUntilPresent().click();
    }


    @Step("Select Value {1}")
    public void selectValue(String id, String value) {
         commonFunctions.selectFromDropdown($(By.id(id)).getElement(), value);
    }
    @Step
    public void enterValue(String value) {
         $(By.id("expinMonthsEdit")).sendKeys(Keys.BACK_SPACE);
         $(By.id("expinMonthsEdit")).type(value);
    }

    @Step
    public void clickOK() {
         waitABit(1000);
        withAction().sendKeys(Keys.ENTER).build().perform();

    }
    @Step
    public void verifyData(String skill, String type, String experience) {
         int flag = 0;
        List<WebElement> tableRow = getDriver().findElements(By.xpath(MySkillsLocators.tableRow.replace("ids", "tblSkillSet")));
        for (WebElement row: tableRow
             ) {
            if(row.getText().contains(skill) && row.getText().contains(type) && row.getText().contains(experience)) {
                flag = 1;
                break;
            }
        }
        if(flag == 1) Assert.assertTrue("Record updated Successfully", true);
        else Assert.fail("Record was not updated Successfully");
    }

}
