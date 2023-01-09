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
    public static By btnSaveDoc = By.id("btnSaveDocument");
    public static By tagNameCloseButton = xpath("//button[@id='btnCloseDocumentTag']");
    public static By crossIconOnTagName = xpath("//*[@id=\"mypopupAddNewDocumentTagModal\"]/div/div/div[1]/button");
    public static By crossIconOnFolderName = xpath("//*[@id='mypopupAddNewDocGroupModal']/div/div/div[1]/button/span");
    public static By folderNameSaveButton = xpath("//*[@id=\"btnSaveGroup\"]");
    public static By folderNameCloseButton = xpath("//*[@id=\"btnCloseGroup\"]");
    public static By refreshDocs = xpath("//a[@id='imgAllDocument']");
    public static By emptyGridInAddNewDocs = xpath("//table[@id='tbldocumentGridViewList']/tbody/tr/td");
    public static By warningPopUpOk = xpath("//button[@class='confirm btn btn-lg btn-primary']");
    public static By tagAddedPopupOk = xpath("/html/body/div[13]/div[7]/div/button");
    public static By inputFolderName = xpath("//*[@id=\"groupName\"]");
    public static By warningPopUpText = xpath("//p[@class='lead text-muted ']");
    public static By recordCountLowerLeft = xpath("//*[@id='tbldocumentGridViewList_info']");
    public static By reloadButton = xpath("//a[@id='imgAllDocument']");
    public static By nextButton = xpath("(//a[@aria-controls='tbldocumentGridViewList'])[2]");
    public static By prevButton = xpath("(//a[@aria-controls='tbldocumentGridViewList'])[1]");
    public static By dropDown = xpath("//*[@id=\"tbldocumentGridViewList_length\"]/label/select");
//    public static By listOfFolders = xpath("//div[@id='DocumentGrouptree']/ul/li[]/span/a");
    public static By warnignOkOnFolderPopup = xpath("/html/body/div[13]/div[7]/div/button");
    public static By crossButtonLocator = By.xpath("//*[@id=\"mypopupWindowAddNewDocumentModal\"]/div/div/div[1]/button/span");

    //view shared documents xpaths
    public static By viewSharedDocumentMenu = xpath("/html/body/nav/div/div[1]/ul/li[6]/ul/li[2]/a");
    public static By popUpXpath = xpath("//*[@id='mypopupViewDocModal']");
    public static By popupTitle = xpath("//h4[@id='modalTitle']");
    public static By eyeButton = xpath("//button[@class='btn btn-sm teal']");
    public static By closeButtonOnDocument = xpath("//*[@id='mypopupViewDocModal']/div/div/div[1]/button/span");
    public static By iframeXpath = xpath("/html/body");
    public static By sortingIcon = xpath("//th[@class='sorting'][1]");
    public static By searchBarSharedDoc = By.xpath("//*[@id=\"tblShareDocumentList_filter\"]/label/input");
    public static By gridAfterSearch = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr/td");

    public static By searchBarInAddDoc = By.xpath("//*[@id=\"tbldocumentGridViewList_filter\"]/label/input");


    //upload document
    public static By docUpload = By.id("DocumentToUpload");
    public static By fileTitle = By.id("txtDescription");
    public static By fileDesc = By.id("txtFileDiscription");

    //folders
    public static By newFolder = By.xpath("//*[@id=\"DocumentGrouptree\"]/ul/li[2]/span/span[1]");
    public static By newFolder123 = By.xpath("//a[contains(text(),'New Folder123')]");
    public static By subFolder  = By.xpath("//*[@id=\"DocumentGrouptree\"]/ul/li[2]/ul/li/span/span[1]");
    public static By newFolderOnViewDoc  = By.xpath("//*[@id=\"DocumentGrouptree\"]/ul/li[2]/span/span[1]");
    public static By isDuplicateFolder  = By.xpath("/html/body/div[13]/p");
    public static By okOnDocUploadPOPup  = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");
    public static By totalPages = By.xpath("//*[@id=\"tblShareDocumentList_paginate\"]/ul/li[4]/a");
    public static By nextButtonDoc = By.xpath("//*[@id=\"tblShareDocumentList_next\"]/a");
    public static By prevButtonDoc = By.xpath("//*[@id=\"tblShareDocumentList_previous\"]/a");
    public static By infoOfPage = By.xpath("//*[@id=\"tblShareDocumentList_info\"]");
    public static By colOneText = By.xpath("//*[@id=\"tblShareDocumentList\"]/tbody/tr[1]/td[1]");
    public static By textInGrid = By.xpath("//*[@id=\"tblShareDocumentList\"]/tbody/tr/td");

    public static By listOfFolder = By.xpath("//div[@id='DocumentGrouptree']/ul/li/span/a");
    public static By sharedDocListInfo = By.id("tblShareDocumentList_info");
    public static By sharedDocGridInfo = By.id("tbldocumentGridViewList_info");
    public static By sharedDocListLen = By.name("tblShareDocumentList_length");
    public static By folderName = By.xpath("//div[@id='DocumentGrouptree']/ul/li/span/a");

    public static By docGridView = By.name("tbldocumentGridViewList_length");
}
