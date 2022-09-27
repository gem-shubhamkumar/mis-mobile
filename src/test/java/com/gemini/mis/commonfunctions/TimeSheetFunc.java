package com.gemini.mis.pages;

import com.gemini.mis.selectors.TimeSheetSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import java.util.logging.Logger;

public class TimeSheetFunc extends PageObject {

    //declarations
    private final TimeSheetSelectors ts = new TimeSheetSelectors();
    private final GenericFunc gf = new GenericFunc();
    private final CommonFunc cf = new CommonFunc();
    private final static Logger log = Logger.getLogger(GenericFunc.class.getName());
    EnvironmentVariables conf = SystemEnvironmentVariables.createEnvironmentVariables();
    /*-----------------------------------------------------------------------------------------------------------*/

}
