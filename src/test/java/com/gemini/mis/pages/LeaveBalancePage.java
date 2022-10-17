package com.gemini.mis.pages;

import com.gemini.mis.implementations.LeaveBalanceImplementation;
import net.serenitybdd.core.pages.PageObject;


public class LeaveBalancePage extends PageObject {

    LeaveBalanceImplementation leaveBalanceImp;

    public void verifyNumberOfRecordsAreSame(){
        leaveBalanceImp. verifyNumberOfRecordsAreSame();
    }

    public void verifyIsVisibleOnTheCurrentScreen(String eleName){
        leaveBalanceImp.verifyIsVisibleOnTheCurrentScreen(eleName);
    }

    public void verifyLeaveHistoryWindowCloses(){
        leaveBalanceImp.verifyLeaveHistoryWindowCloses();
    }

}

