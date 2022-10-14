package com.gemini.mis.pages;

import com.gemini.mis.implementations.OrgStructureImpl;
import net.thucydides.core.annotations.Step;

public class OrgStructurePage {

    //declarations
    private final OrgStructureImpl orgImpl = new OrgStructureImpl();
    /*------------------------------------------------------------------------------------------------------------*/

    /*-------------------------------FUNCTIONS SPECIFIC TO ORGANIZATION STRUCTURE---------------------------------*/

    @Step
    public void searchEmployee(String Name) {
        orgImpl.searchEmployee(Name);
    }

    @Step
    public void printEmployeeDesig(String Name) {
        orgImpl.printEmployeeDesig(Name);
    }

    @Step
    public void countSeniorsWithReportees() {
        orgImpl.countSeniorsWithReportees();
    }

    @Step
    public void confirmSideArrows() {
        orgImpl.confirmSideArrows();
    }

    @Step
    public void expandOrCompressSenior(String Name) {
        orgImpl.expandOrCompressSenior(Name);
    }

    @Step
    public void verifyUpDownArrows() {
        orgImpl.verifyUpDownArrows();
    }

    @Step
    public void zoomOnDoubleClick() {
        orgImpl.zoomOnDoubleClick();
    }

    @Step
    public void zoomInOrgStuct() {
        orgImpl.zoomInOrgStuct();
    }

    @Step
    public void verifyRightLeftArrows() {
        orgImpl.verifyRightLeftArrows();
    }

    @Step
    public void zoomOutOrgStuct() {
        orgImpl.zoomOutOrgStuct();
    }

}