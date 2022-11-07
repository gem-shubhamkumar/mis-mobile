package com.gemini.mis.stepdefinitions;

import com.gemini.mis.implementations.OrgStructureImpl;
import com.gemini.mis.pages.OrgStructurePage;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class OrgStructure {

    @Steps
    OrgStructurePage org;

    //declarations
    private final OrgStructureImpl orgImpl = new OrgStructureImpl();
    /*-----------------------------------------------------------------------------------------------------------*/

    /*------------------------------------------ORGANIZATION STRUCTURE-------------------------------------------*/

    @And("^Search an employee \"(.*?)\" and get their designation$")
    public void searchEmployeeAndGetDesig(String Name) {
        org.searchEmployee(Name);
        org.printEmployeeDesig(Name);
    }

    @And("Count the total number of seniors having reportees")
    public void countSeniorsWithReportees() {
        org.countSeniorsWithReportees();
    }

    @And("Verify side arrows are present on the page")
    public void confirmSideArrows() {
        org.confirmSideArrows();
    }

    @And("Expand or compress senior with max reportees")
    public void seniorWithMaxReportees_ExpAndComp() {
        org.expandOrCompressSenior(orgImpl.seniorWithMaxReportees());
        //of.verifyUpDownArrows();
        org.expandOrCompressSenior(orgImpl.seniorWithMaxReportees());
    }

    @And("Double click to zoom in or zoom out a card")
    public void zoomOnDoubleClick() {
        org.zoomOnDoubleClick();
    }

    @And("Zoom in and zoom out organization structure")
    public void zoomInZoomOutOrgStuct() {
        org.zoomInOrgStuct();
        //of.verifyRightLeftArrows();
        org.zoomOutOrgStuct();
    }

}
