package stepDefinitions;

import com.gemini.mis.pages.CommonFunc;
import com.gemini.mis.pages.MISCommonFunc;
import com.gemini.mis.pages.TimeSheetFunc;
import com.gemini.mis.selectors.MISCommonSelectors;
import com.gemini.mis.selectors.TimeSheetSelectors;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.java.en.And;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import java.util.logging.Logger;

public class TimeSheet extends PageObject {

    //declarations
    private final TimeSheetFunc tf = new TimeSheetFunc();
    private final MISCommonFunc mcf = new MISCommonFunc();
    private final TimeSheetSelectors ts = new TimeSheetSelectors();
    private final MISCommonSelectors mcs = new MISCommonSelectors();
    private final CommonFunc cf = new CommonFunc();
    private final static Logger log = Logger.getLogger(MISCommonFunc.class.getName());
    EnvironmentVariables conf = SystemEnvironmentVariables.createEnvironmentVariables();
    /*----------------------------------------------------------------------------------------------------------*/

    @And("Verify table data for configure Timesheet page")
    public void verifyCFTTableData() {
        tf.verifyCFTTableHeads();
        mcf.verifyTableData();
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

    @And("^Perform search for \"(.*?)\" using search box when no records are displayed$")
    public void performSearchForNoRecords(String Text) {
        mcf.searchTextForNoRecords(Text);
    }

    @And("^Perform invalid search for \"(.*?)\" using search box when records are displayed$")
    public void performInvalidSearch(String Text) {
        mcf.searchTextForNonMatchingRecords(Text);
    }

    @And("^Perform valid search for \"(.*?)\" using search box when records are displayed$")
    public void performValidSearch(String Text) {
        mcf.searchTextForMatchingRecords(Text);
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
    public void copyFromWeek(String Week, String Year) throws Exception {
        tf.clickCopyFromWeek();
        tf.verifyCopyTemplate(Week, Year);
        tf.closeCFWDialogBox();
    }

    @And("Verify table data for manage task template page")
    public void verifyMTTTableData() {
        tf.verifyMTTTableHeads();
        mcf.verifyTableData();
    }

    @And("^Add a new invalid task template with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void addNewInvalidTemplate(String Name, String Description, String Team, String Task) throws Exception {
        tf.clickAddNewTemplate();
        tf.AddInvalidTemplate(Name, Description, Team, Task);
    }

    @And("^Add a new duplicate task template with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void addNewDuplicateTemplate(String Name, String Description, String Team, String Task) throws Exception {
        tf.clickAddNewTemplate();
        tf.AddDuplicateTemplate(Name, Description, Team, Task);
    }

    @And("^Add a new valid task template with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void addNewValidTemplate(String Name, String Description, String Team, String Task) throws Exception {
        if($(mcs.txtSearch).isDisplayed()) {
            log.info("Search box displayed");
            $(mcs.txtSearch).typeAndEnter(Name);
            if($(ts.txtTemplateData1).getText().equals(Name)) {
                log.info("Searched item present");
                tf.clickDeleteTemplate(Name);
                mcf.verifyAndAcceptConfirmation();
                tf.clickAddNewTemplate();
                tf.AddValidTemplate(Name, Description, Team, Task);
            }else {
                tf.clickAddNewTemplate();
                tf.AddValidTemplate(Name, Description, Team, Task);
            }
        }else {
            Assert.fail("Search box not displayed");
        }
    }

    @And("^Edit a task template \"(.*?)\" with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void editTemplate(String txtUniqueIdentifier, String Name, String Description, String Team, String Task) throws Exception {
        tf.clickEditTemplate(txtUniqueIdentifier);
        tf.verifyEditTemplate(Name, Description, Team, Task);
    }

    @And("^Click on Delete button for a task template \"(.*?)\"$")
    public void deleteTemplate(String txtUniqueIdentifier) throws Exception {
        tf.clickDeleteTemplate(txtUniqueIdentifier);
    }
}
