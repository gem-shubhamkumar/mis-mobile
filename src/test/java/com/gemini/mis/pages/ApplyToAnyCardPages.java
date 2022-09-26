package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.Utils;
import com.gemini.mis.selectors.ApplyToAnyLocators;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApplyToAnyCardPages {

     Utils utils = new Utils();

     @Step("Verify if {0} card is present")
    public void verifyIfCardIsPresent(String cardName) {
         int flag = 0;

         utils.customWait(1000);

         List<WebElement> cards = utils.getMultipleElements(By.xpath(ApplyToAnyLocators.cardNames));

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
            Assert.assertFalse(utils.isPresent(By.xpath(ApplyToAnyLocators.tableDiv)));
    }

    @Step("Click on skill {0}")
    public void clickASkill(String skill) {
         utils.click(By.xpath(ApplyToAnyLocators.skillName.replace("skill", skill)));
    }

    @Step("Verify Modal Opened")
    public void verifySkillModal() {
         utils.switchToActiveElement();
         Assert.assertTrue(utils.isPresent(By.xpath(ApplyToAnyLocators.modalTitle)));
    }

    @Step("Select Value {1}")
    public void selectValue(String id, String value) {
         utils.selectFromDropdown(utils.getElement(By.id(id)), value);
    }

    public void enterValue(String value) {
         utils.clearField(By.id("expinMonthsEdit"));
         utils.typeText(By.id("expinMonthsEdit"), value);
    }


    public void clickOK() {
         utils.pressEnter();
    }

    public void verifyData(String skill, String type, String experience) {
         int flag = 0;
        List<WebElement> tableRow = utils.getMultipleElements(By.xpath(ApplyToAnyLocators.tableRow));
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

    public void verifyForError(String inputType) {
         switch (inputType) {
             case "skill" :
                 Assert.assertTrue(utils.isPresent(By.xpath(ApplyToAnyLocators.errorType.replace("ids", "ddlSkillTypeEdit"))));
                    break;
             case "experience" :
                 String xpath = ApplyToAnyLocators.errorType.replace("select", "input");
                 xpath = xpath.replace("ids", "expinMonthsEdit");
                 Assert.assertTrue(utils.isPresent(By.xpath(xpath)));
                 break;
         }
    }
}
