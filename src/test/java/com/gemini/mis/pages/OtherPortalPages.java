package com.gemini.mis.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Iterator;
import java.util.Set;

public class OtherPortalPages extends PageObject {

@Step("Click on other portals hyperlink and validate that the hyperlink is able to open the web page")
    public void validateOtherPortal(String subsScreen){
String mainWindowTitle=getDriver().getTitle();
        String mainWindow=getDriver().getWindowHandle();
        waitABit(5000);
        Set<String> windows=getDriver().getWindowHandles();
        Iterator<String> l1=windows.iterator();
        while (l1.hasNext()){
            String childWindow=l1.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                //switching to child window
                getDriver().switchTo().window(childWindow);
                waitABit(2000);
                String title=getDriver().getTitle();
                if (!title.equalsIgnoreCase(mainWindowTitle)){
                    Assert.assertTrue("We are able to navigate to other portals successfully",true);
                }else{
                    Assert.fail("We are unable to navigate to other portals");
                }
            }
        }

    }
}
