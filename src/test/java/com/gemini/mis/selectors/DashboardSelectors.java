package com.gemini.mis.selectors;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class DashboardSelectors extends PageObject {

    //Attendence Card
    public By txtAttendenceMonth = By.xpath("//span[contains(@aria-labelledby,'selectduration')]");
    public By txtFirstDate_Attendence = By.xpath("(//table[@id='employeesAttendenceTable']//td)[1]");

}
