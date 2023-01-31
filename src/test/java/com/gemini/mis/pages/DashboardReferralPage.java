package com.gemini.mis.pages;

import com.gemini.mis.implementations.DashboardReferralImplementation;
import net.thucydides.core.annotations.Step;

public class DashboardReferralPage {

    DashboardReferralImplementation dashboardImplement;

    //verify all the buttons are visible on page load
    @Step("Click on jd button and verify window is visible or not")
    public void verifyJdButton() {
        dashboardImplement.verifyJdButton();
    }

    //validate red warning when you keep filed empty
    @Step("Create a refal and verify if some values are left blank it gives warning")
    public void validateRedWarnings() {
        dashboardImplement.validateRedWarnings();
    }

    //Verify referral creation
    @Step("Create a proper referral and verify it's save ")
    public void createReferral(String filePath, String name, String email, String mobileNo, String type) {
        dashboardImplement.createReferral(filePath, name, email, mobileNo, type);
    }

    //Resume pop while you click on the name of the person
    @Step("verify on clicking on any name in MyReferral the resume of that person will pop")
    public void verifyResumePopup() {
        dashboardImplement.verifyResumePopup();
    }

    //Wrong email warning
    @Step("Verify wrong email popup")
    public void wrongEmail() {

        dashboardImplement.wrongEmail();
    }

    //Warning file upload format
    @Step("Warning when uploading in jpg or png format")
    public void warningWrongFormat(String filePath) {
        dashboardImplement.warningWrongFormat(filePath);
    }

    //FAQ pdf visibility
    @Step("Verify FAQ pdf view is visible")
    public void fAQPdfView() {
        dashboardImplement.fAQPdfView();
    }

    //Pdf visibility
    @Step("Verify Manual pdf view is visible")
    public void manualPdfView() {
        dashboardImplement.manualPdfView();
    }
}