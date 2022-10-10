package com.gemini.mis.selectors;

import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class KnowledgeBaseLocators {
    public static By knowledgeBaseMenu = xpath("/html/body/nav/div/div[1]/ul/li[6]/span");


    //view documents xpaths
    public static By viewDocumentMenu = xpath("/html/body/nav/div/div[1]/ul/li[6]/ul/li[1]/a/span");
    public static By addNewDocument = xpath("//div[@id='viewDocument-leftContainer']/div/a[1]");
    public static By addNewFolder = xpath("//a[@id='popupAddNewDocGroup']");
    public static By tagNameInputBox =xpath("//input[@id='txtTagName']");
    public static By tagNameSaveButton = xpath("//button[@id='btnSaveDocumentTag']");
    public static By tagNameCloseButton = xpath("//button[@id='btnCloseDocumentTag']");
    public static By crossIconOnTagName = xpath("//*[@id=\"mypopupAddNewDocumentTagModal\"]/div/div/div[1]/button");
    public static By crossIconOnFolderName = xpath("//*[@id='mypopupAddNewDocGroupModal']/div/div/div[1]/button/span");
    public static By folderNameSaveButton = xpath("//*[@id=\"btnSaveGroup\"]");
    public static By folderNameCloseButton = xpath("//*[@id=\"btnCloseGroup\"]");
    public static By refreshDocs = xpath("//a[@id='imgAllDocument']");
    public static By emptyGridInAddNewDocs = xpath("//table[@id='tbldocumentGridViewList']/tbody/tr/td");
    public static By warningPopUpOk = xpath("/html/body/div[14]/div[7]/div/button");
    public static By tagAddedPopupOk = xpath("/html/body/div[13]/div[7]/div/button");
    public static By inputFolderName = xpath("//*[@id=\"groupName\"]");
    public static By warningPopUpText = xpath("//p[@class='lead text-muted ']");
    public static By recordCountLowerLeft = xpath("//*[@id='tbldocumentGridViewList_info']");
    public static By reloadButton = xpath("//a[@id='imgAllDocument']");
    public static By nextButton = xpath("(//a[@aria-controls='tbldocumentGridViewList'])[2]");
    public static By prevButton = xpath("(//a[@aria-controls='tbldocumentGridViewList'])[1]");
    public static By dropDown = xpath("//*[@id=\"tbldocumentGridViewList_length\"]/label/select");
    // public static By listOfFolders = xpath("");
    public static By warnignOkOnFolderPopup = xpath("/html/body/div[13]/div[7]/div/button");

    //view shared documents xpaths
    public static By viewSharedDocumentMenu = xpath("/html/body/nav/div/div[1]/ul/li[6]/ul/li[2]/a");
    public static By popUpXpath = xpath("//*[@id='mypopupViewDocModal']");
    public static By popupTitle = xpath("//h4[@id='modalTitle']");
    public static By eyeButton = xpath("//button[@class='btn btn-sm teal']");
    public static By closeButtonOnDocument = xpath("//*[@id='mypopupViewDocModal']/div/div/div[1]/button/span");
    public static By iframeXpath = xpath("/html/body");
    public static By sortingIcon = xpath("//th[@class='sorting'][1]");


}
