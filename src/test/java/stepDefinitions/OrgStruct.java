package stepDefinitions;

import com.gemini.mis.pages.OrgStructFunc;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.java.en.And;

public class OrgStruct extends PageObject {

    //declarations
    private final OrgStructFunc of = new OrgStructFunc();
    /*----------------------------------------------------------------------------------------------------------*/

    @And("^Search an employee \"(.*?)\" and get their designation$")
    public void searchEmployeeAndGetDesig(String Name) {
        of.searchEmployee(Name);
        of.printEmployeeDesig(Name);
    }

    @And("Count the total number of seniors having reportees")
    public void countSeniorsWithReportees() {
        of.countSeniorsWithReportees();
    }

    @And("Verify side arrows are present on the page")
    public void confirmSideArrows() {
        of.confirmSideArrows();
    }

    @And("Expand or compress senior with max reportees")
    public void seniorWithMaxReportees_ExpAndComp() {
        of.expandOrCompressSenior(of.seniorWithMaxReportees());
        //of.verifyUpDownArrows();
        of.expandOrCompressSenior(of.seniorWithMaxReportees());
    }

    @And("Double click to zoom in or zoom out a card")
    public void zoomOnDoubleClick() {
        of.zoomOnDoubleClick();
    }

    @And("Zoom in and zoom out organization structure")
    public void zoomInZoomOutOrgStuct() {
        of.zoomInOrgStuct();
        //of.verifyRightLeftArrows();
        of.zoomOutOrgStuct();
    }

}
