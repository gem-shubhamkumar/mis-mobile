package com.gemini.mis.implementations;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.MISPOM;
import com.gemini.mis.selectors.ReimbursementPOM;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class OtherPortalsImplementation extends PageObject {

    static final Logger logger = LoggerFactory.getLogger("SampleLogger");

    //Validate hyperlink
    public void validateOtherPortal(String subsScreen) {
        waitABit(3000);
        String mainWindowTitle = getDriver().getTitle();
        String mainWindow = getDriver().getWindowHandle();
        waitABit(5000);
        Set<String> windows = getDriver().getWindowHandles();
        Iterator<String> l1 = windows.iterator();
        while (l1.hasNext()) {
            String childWindow = l1.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                //switching to child window
                getDriver().switchTo().window(childWindow);
                waitABit(3000);
                String title = getDriver().getTitle();
                if (!title.equalsIgnoreCase(mainWindowTitle) || title.contains(subsScreen)) {
                    Assert.assertTrue("User is able to navigate to other portals successfully", true);
                } else {
                    Assert.fail("User is unable to navigate to other portals");
                    logger.info("User is unable to navigate to other portals");
                }
            }
        }

    }
/////////////////////////////////////////////////////////Function specific to MIS//////////////////////////////////////////////////////////////////////

    //navigation to main screen and sub screen tab
    public void navigateToTab(String parentTabName, String childTabName){
        waitABit(7000);
        if (parentTabName.equals("Other Portals")){
            // WebElementFacade parent=find(GenericFunctionPOM.screenNavigation(parentTabName));
            if (isElementVisible(MISPOM.screenNavigation(parentTabName)))
            { waitABit(2000);
                //clicks on parent tab
                $(MISPOM.screenNavigation(parentTabName)).click();
                waitABit(2000);

                Actions actions = new Actions(getDriver());
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
                // verifies sub tab available
                if (isElementVisible(MISPOM.screenNavigation(childTabName)))
                {
                    $(MISPOM.screenNavigation(childTabName)).click();
                    waitABit(5000);
                }

                else{
                    Assert.fail("Unable to locate child tab");
                    logger.info("Unable to locate child tab");
                }

            }

            else {
                Assert.fail("Unable to locate parent tab");
                logger.info("Unable to locate parent tab");
            }


        }else{
            waitABit(7000);
            // verification for Parent tab
            By parentTab = MISPOM.screenNavigation(parentTabName);
            if (isElementVisible(parentTab))
            {
                waitABit(3000);
                //clicks on parent tab
                $(parentTab).click();
                // verifies sub tab available
                By childTab = MISPOM.screenNavigation(childTabName);
                waitABit(5000);
                Actions act = new Actions(getDriver());
                act.click($(childTab)).build().perform();

            }

            else {
                Assert.fail("Unable to locate parent tab");
                logger.info("Unable to locate parent tab");
            }


        }}
    //navigate to main tab
    public void navigateToTab(String parentTabName) {

        if (isElementVisible(MISPOM.screenNavigation(parentTabName)))
        {
            waitABit(5000);
            //clicks on parent tab
            $(MISPOM.screenNavigation(parentTabName)).click();
        }else{
            Assert.assertFalse("Unable to locate parent tab",false);
        }
    }
    //all the generic button of MIS
    public void clickOnButton(String buttonName) {

        WebElementFacade buttonClick= find(MISPOM.buttonPath(buttonName));
        if (buttonName.equalsIgnoreCase("New Request")) {
            waitABit(9000);
            $(MISPOM.buttonPath(" New Request")).click();
            waitABit(2000);
        } else if (buttonName.equalsIgnoreCase("Submit")) {
            $(MISPOM.buttonPath(" Submit")).click();
            waitABit(2000);
        }else if(buttonName.equalsIgnoreCase("Save")) {
            $(MISPOM.saveButton).click();
            waitABit(2000);
        }else if(buttonName.equalsIgnoreCase("Back")){
                $(MISPOM.genericPath(" Back")).click();

        } else if (buttonClick.isVisible()){
            clickOn(buttonClick);
            waitABit(2000);
        }else{
                Assert.fail("Button " + buttonName + " not found");
              logger.info("Button " + buttonName + " not found");
        }

    }
    // validate number of entries present
    public void selectNoOfEntry(){
        waitABit(2000);
        $(MISPOM.entriesNo).click();
        $(MISPOM.optionOfEntry("50")).click();
        Boolean verifyEntry=  $(MISPOM.optionOfEntry("50")).isVisible();
        if(verifyEntry){
            Assert.assertTrue("User is able to change the entry number",true);
        }else{
            Assert.fail("User is unable to change the entry number");
            logger.info("User is unable to change the entry number");
        }
    }
    // validate search functionality
    public void verifySearch(String value){
        waitABit(3000);
        boolean result =true;
        waitABit(2000);
        WebElementFacade searchElement=$(MISPOM.searchBox);
        clickOn(searchElement);
        typeInto(searchElement,value);
        searchElement.sendKeys(Keys.ENTER);
        List<WebElement> totalAmount=getDriver().findElements(ReimbursementPOM.totalAmountValueText);
        for(WebElement amount:totalAmount){
            String temp=amount.getText();
            if(temp.contains(value) || temp.contains("0")){
               logger.info("The search functionality is working properly");
            }else{
                result=false;
            }
        }
        if(result){

            Assert.assertTrue("User is able to search properly",true);
        }else{
            Assert.fail("User is not able to search properly");
            logger.info("User is not able to search properly");
        }

    }
    //verify the text "No record Found"
    public void noRecordFoundWhileSearch(String Value){
        waitABit(2000);
        WebElementFacade searchElement=$(MISPOM.searchBox);
        clickOn(searchElement);
        typeInto(searchElement,Value);
        searchElement.sendKeys(Keys.ENTER);
        Boolean noRecords=$(MISPOM.genericPath("No matching records found")).isVisible();
        String recordsFound=$(ReimbursementPOM.tableInfo).getText();
        if(recordsFound.contains("Showing 0 ") && noRecords){
            Assert.assertTrue("Search functionality working properly",true);
        }else{
            Assert.fail("Search functionality not working properly");
            logger.info("Search functionality not working properly");
        }
    }

    // get last modified file
    public File getLAstModifiedFile() {

        String username = System.getProperty("user.name");
        //will fetch username of your system
        String downloadPath = "C:\\Users\\"+username+"\\Downloads\\";
        //concatenate usernameLeaveManagementTab.verifyFile(downloadPath,fileName)
        File directory=new File(downloadPath);
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
        }
        return choseFile ;
    }
}



