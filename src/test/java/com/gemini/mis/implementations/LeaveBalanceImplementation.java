package com.gemini.mis.implementations;

import com.gemini.mis.selectors.AccountPortalSelectors;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import com.gemini.mis.selectors.NavBarSelectors;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Assert;

public class LeaveBalanceImplementation extends PageObject {

    public void verifyNumberOfRecordsAreSame() {
        String text = $(LeaveBalanceSelectors.textNumberOfEntries).getText();
        String entries = text.substring(19, 21);
        System.out.println(entries);
        String entriesOnLeaveCard = $(AccountPortalSelectors.linkNumberOfLeave("WFH")).getText();
        if (StringUtils.equals(entries, entriesOnLeaveCard)) {
            System.out.println("records are same as mentioned on leave card");
        } else {
            Assert.fail("number of records are different");
        }
    }

    public void verifyIsVisibleOnTheCurrentScreen(String eleName) {
        switch (eleName) {
            case "Leave history window":
                $(LeaveBalanceSelectors.gridLeaveHistory).isVisible();
                break;
            case "Add skills window":
                $(NavBarSelectors.windowAddSkills).isVisible();
                break;
            case "Dashboard setting table":
                $(NavBarSelectors.textDashboardTable).isVisible();
                break;

            default:
                Assert.fail("Element name not added in switch cases");
        }
    }

    public void verifyLeaveHistoryWindowCloses() {
        if (!$(LeaveBalanceSelectors.btnLeaveHistoryClose).isVisible()) {
            System.out.println("Leave window closes successfully");
        } else {
            Assert.fail("Leave window is open");
        }
    }


}
