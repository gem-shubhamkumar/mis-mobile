package stepDefinitions;

import com.gemini.mis.pages.DashboardFunc;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.java.en.And;
import java.text.ParseException;

public class Dashboard extends PageObject {

    //declarations
    private final DashboardFunc df = new DashboardFunc();
    /*----------------------------------------------------------------------------------------------------------*/

    @And("^Open attendance of \"(.*?)\"$")
    public void OpenAttendence(String MMMMYYYY) throws ParseException {
        df.selectAndVerifyAttendanceMonth(MMMMYYYY);
    }

}
