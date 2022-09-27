package com.gemini.mis.pages;

import com.gemini.mis.commonFunctions.commonMethods;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class NavBarPages {
    @Steps
    commonMethods commonFunction;
    public void verifyUserRedirectedToLandingPage(){
        if(commonFunction.isElementFound(LeaveBalanceSelectors.cardProfile)){
            System.out.println("User successfully redirected to landing page");
        }else{
            Assert.fail("Failed to navigate to landing page");
        }
    }
}
