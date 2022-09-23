package com.gemini.mis.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Iterator;
import java.util.Set;

public class OtherPortalPages extends PageObject {

@Step("Click on other hyperlink and validate that the hyperlink is able to open")
    public void validateOtherPortal(String subsScreen){

        String mainWindow=getDriver().getWindowHandle();
        Set<String> windows=getDriver().getWindowHandles();
        Iterator<String> l1=windows.iterator();
        while (l1.hasNext()){
            String childWindow=l1.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                //switching to child window
                getDriver().switchTo().window(childWindow);
                String title=getDriver().getTitle();
                if (title.contains(subsScreen)){
                    Assert.assertTrue("We are able to navigate to other portals successfully",true);
                }else{
                    Assert.fail("We are unable to navigate to other portals");
                }
            }
        }

    }
}
