package com.gemini.mis.pages;

import com.gemini.mis.selectors.CommonXpaths;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

public class LeaveBalancePages extends PageObject {

public void verifyNumberOfRecordsAreSame(){
    String text = $(LeaveBalanceSelectors.textNumberOfEntries).getText();
    String entries = text.substring(19,21);
    System.out.println(entries);
    String entriesOnLeaveCard = $(CommonXpaths.linkNumberOfLeave("WFH")).getText();
    if(entries.equals(entriesOnLeaveCard)){
        System.out.println("records are same as mentioned on leave card");
    }else{
        Assert.fail("number of records are different");
    }


}


}

