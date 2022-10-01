package stepDefinitions;

import com.gemini.mis.pages.GenericFunc;
import com.gemini.mis.pages.TimeSheetFunc;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.java.en.And;

public class TimeSheet extends PageObject {

    //declarations
    private final TimeSheetFunc tf = new TimeSheetFunc();
    private final GenericFunc gf = new GenericFunc();
    /*----------------------------------------------------------------------------------------------------------*/

    @And("Verify table data for configure Timesheet page")
    public void verifyCFTTableData() {
        tf.verifyCFTTableHeads();
        gf.verifyNoTableData();
    }

    @And("Verify timesheet status")
    public void verifyTimesheetStatus() {
        tf.verifyTimesheetStatus();
    }

    @And("Verify all tabs and active tab")
    public void verifyTabsAndActiveTab() {
        tf.verifyCFTTabs();
        tf.verifyActiveCFTTab();
    }

    @And("^Perform search for \"(.*?)\" using search box$")
    public void performSearch(String Text) {
        gf.searchText(Text);
    }

    @And("Click on save button")
    public void clickSave() {
        tf.clickSave();
    }

    @And("Verify and accept please note popup")
    public void verifyAndAcceptNote() {
        tf.verifyAndAcceptPleaseNotePopup();
    }

    @And("Verify table data for create Timesheet page")
    public void verifyCTTableData() {
        tf.verifyCTTableHeads();
        tf.verifyCTTableData();
    }

    @And("Open previous and next week")
    public void openPreNextWeek() {
        tf.openPreNextWeek("Previous");
        tf.openPreNextWeek("Next");
        tf.openPreNextWeek("Next");
    }

    @And("^Copy timesheet from week \"(.*?)\" of year \"(.*?)\"$")
    public void copyFromWeek(String Week, String Year) {
        tf.clickCopyFromWeek();
        tf.verifyCopyTemplate(Week, Year);
        tf.closeCFWDialogBox();
    }

    @And("Verify table data for manage task template page")
    public void verifyMTTTableData() {
        tf.verifyMTTTableHeads();
        gf.verifyNoTableData();
    }

    @And("^Add a new task template with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void addNewTemplate(String Name, String Description, String Team, String Task) {
        tf.clickAddNewTemplate();
        tf.verifyAddTemplate(Name, Description, Team, Task);
    }

    @And("^Edit a task template \"(.*?)\" with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void editTemplate(String txtUniqueIdentifier, String Name, String Description, String Team, String Task) {
        tf.clickEditTemplate(txtUniqueIdentifier);
        tf.verifyEditTemplate(Name, Description, Team, Task);
    }

    @And("^Click on Delete button for a task template \"(.*?)\"$")
    public void clickOnDelete(String txtUniqueIdentifier) {
        tf.clickDeleteTemplate(txtUniqueIdentifier);
    }

}
