package com.everis.vivo.robotester.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SeleniumUtils {

	protected WebDriver browser;
	protected Logger logger;

	public SeleniumUtils() {
		logger = LoggerFactory.getLogger(this.getClass());
	}

	protected void setChromeBrowser() {

		logger.info("setting property webdriver (chrome) ");
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

		logger.info("opening chrome ");
		browser = new ChromeDriver();
	}

	protected void closeBrowser() {

		logger.info("closing chrome ");
		browser.close();
	}

	protected void setInternetExplorerBrowser() throws Exception {

		throw new Exception("InternetExplorer webdriver not supported yet");
	}

	protected void setFirefoxBrowser() throws Exception {

		throw new Exception("Firefox webdriver not supported yet");
	}

	protected void gotoPage(String url) {
		logger.info(String.format("browser to %s", url));
		browser.get(url);

	}

	private WebElement find(ByTypes type, String param) throws RuntimeException {
		WebElement element = null;

		switch (type) {
		case ID:
			element = browser.findElement(By.id(param));
			break;
		case NAME:
			element = browser.findElement(By.name(param));
			break;
		case XPATH:
			element = browser.findElement(By.xpath(param));
			break;

		default:
			throw new NotFoundException(String.format("ByTypes %s not found", type));
		}
		if (element == null) {
			throw new NotFoundException(String.format("findBy%s(%s) return no element", type, param));
		}
		logger.info(String.format("identified element by %s '%s' ", type, param));
		return element;
	}

	protected void clickElement(ByTypes type, String id) {
		WebElement element = find(type, id);

		logger.info(String.format("clicking element id '%s' ", id));
		element.click();
	}

	protected void sendText2Element(ByTypes type, String text2Send, String id) {
		WebElement element = find(type, id);
		element.sendKeys(text2Send);
	}

	protected boolean checkTextElement(ByTypes type, String text2Check, String xpath) {
		WebElement element = find(type, xpath);
		String text = element.getText();
		return text2Check.compareTo(text) == 0;
	}
}
