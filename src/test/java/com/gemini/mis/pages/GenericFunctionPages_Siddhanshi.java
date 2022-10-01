package com.gemini.mis.pages;

//All the common functions which are going to be used in MIS only

import com.gemini.mis.selectors.GenericFunctionPOM;
import com.gemini.mis.selectors.ReimbursementPOM;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class GenericFunctionPages_Siddhanshi extends PageObject {


    public void navigateToTab(String parentTabName, String childTabName){
        if (parentTabName.equals("Other Portals")){
            WebElementFacade parent=find(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",parentTabName)));
            if (isElementVisible(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",parentTabName))))
            { waitABit(3000);
                //clicks on parent tab
                $(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",parentTabName))).click();
                waitABit(3000);

                Actions actions = new Actions(getDriver());
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
                // verifies sub tab available
                if (isElementVisible(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",childTabName))))
                {  $(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",childTabName))).click();
                }

                else{ Assert.assertFalse("Unable to locate child tab",false);}

            }

            else { Assert.assertFalse("Unable to locate parent tab",false);
            }


        }else{
        waitABit(3000);
        // verification for Parent tab
         if (isElementVisible(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",parentTabName))))
         { waitABit(3000);
         //clicks on parent tab
             $(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",parentTabName))).click();
         waitABit(3000);
       // verifies sub tab available
         if (isElementVisible(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",childTabName))))
        {  $(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",childTabName))).click();
         }

else{ Assert.assertFalse("Unable to locate child tab",false);}

    }

else { Assert.assertFalse("Unable to locate parent tab",false);
}


    }}

    public void navigateToTab(String parentTabName) {


        if (isElementVisible(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",parentTabName))))
        { waitABit(3000);
            //clicks on parent tab
            $(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",parentTabName))).click();
        }else{
            Assert.assertFalse("Unable to locate parent tab",false);
        }
    }
@Step("Click on required button")
    public void ClickOnButton(String buttonName){
        switch (buttonName){
            case"New Request":
                waitABit(2000);
                $(By.xpath(GenericFunctionPOM.buttonPath.replace("BUTTONNAME"," New Request"))).click();
                waitABit(2000);
                break;
                case"Submit":
                    $(By.xpath(GenericFunctionPOM.buttonPath.replace("BUTTONNAME"," Submit"))).click();
                    waitABit(2000);
                    break;
            case"OK":
                $(By.xpath(GenericFunctionPOM.buttonPath.replace("BUTTONNAME","OK"))).click();
                waitABit(2000);
                break;
            case"Browse":
                $(By.xpath(GenericFunctionPOM.buttonPath.replace("BUTTONNAME","Browse"))).click();
                waitABit(2000);
                break;
            case"Save":
                $(GenericFunctionPOM.saveButton).click();
                waitABit(2000);
                break;
            case"Save as draft":
                $(By.xpath(GenericFunctionPOM.buttonPath.replace("BUTTONNAME","Save as draft"))).click();

            case "Back":
                $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR"," Back"))).click();
        }
    }
    @Step("Click and validate selection of a new entry number in entry drop down")
    public void SelectNoOfEntry(){
waitABit(2000);
        $(GenericFunctionPOM.enteriesNo).click();
        $(By.xpath(GenericFunctionPOM.OptionOfEntry.replace("VAR","50"))).click();
      Boolean verifyEntry=  $(By.xpath(GenericFunctionPOM.OptionOfEntry.replace("VAR","50"))).isVisible();
        if(verifyEntry){
            Assert.assertTrue("We are able to change the entry number",true);
        }else{
            Assert.fail("We are unable to change the entry number");
        }
    }

    @Step("Verify search is working as expected")
    public void VerifySearch(String Value){
        waitABit(2000);
        WebElementFacade searchElement=$(GenericFunctionPOM.searchBox);
clickOn(searchElement);
       typeInto(searchElement,Value);
       searchElement.sendKeys(Keys.ENTER);

        String textAmount=$(ReimbursementPOM.totalAmountValue).getText();
        if(textAmount.contains(Value)){

            Assert.assertTrue("We are able to search properly",true);
        }else{
            Assert.fail("We are not able to search properly");
        }

    }
    @Step("Verify if there is no record found text found")
    public void NoRecordFoundWhileSearch(String Value){
        waitABit(2000);
        WebElementFacade searchElement=$(GenericFunctionPOM.searchBox);
        clickOn(searchElement);
        typeInto(searchElement,Value);
        searchElement.sendKeys(Keys.ENTER);
Boolean noRecords=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","No matching records found"))).isVisible();
        String recordsFound=$(ReimbursementPOM.tableInfo).getText();
        if(recordsFound.contains("Showing 0 ") && noRecords){

            Assert.assertTrue("Search functionality working properly",true);
        }else{
            Assert.fail("Search functionality not working properly");
        }
    }
    @Step("get LastModified File")
    public File getLAstModifiedFile(String directoryFilePath) {
File directory=new File(directoryFilePath);
File[] files= directory.listFiles(File::isFile);
long lastModifiedFileTime=Long.MIN_VALUE;
File choseFile=null;
if(files!= null){
    for(File file:files){
        if (file.lastModified()>lastModifiedFileTime){
            choseFile=file;
            lastModifiedFileTime=file.lastModified();
        }
    }
}return choseFile ;
    }
    }

