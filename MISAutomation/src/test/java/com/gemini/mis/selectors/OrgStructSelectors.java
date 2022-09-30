package com.gemini.mis.selectors;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class OrgStructSelectors extends PageObject {

    public By searchBox = By.xpath("//input[@placeholder='Search']");
    public By arrowUp = By.xpath("//div[@class='gem-up']");
    public By arrowDown = By.xpath("//div[@class='gem-down']");
    public By arrowLeft = By.xpath("//div[@class='gem-left']");
    public By arrowRight = By.xpath("//div[@class='gem-right']");
    public By ceoCard = By.xpath("//*[local-name()='g' and @class='gem-level-1 ']");
    public By rightMostCard = By.xpath("//*[local-name()='g' and @class='gem-level-3 ' and @data-node-id='545']");
    public By leftMostCard = By.xpath("//*[local-name()='g' and @class='gem-level-3 ' and @data-node-id='83']");
    public By seniors = By.xpath("//*[local-name()='circle' and @display='block']//following-sibling::*[ local-name()='text' and @class='reporters-text']");
    public By btnZoomIn = By.xpath("//a[@title='zoom in']");
    public By btnZoomOut = By.xpath("//a[@title='zoom out']");

}
