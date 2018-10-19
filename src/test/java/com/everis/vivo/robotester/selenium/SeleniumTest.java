package com.everis.vivo.robotester.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.everis.vivo.robotester.selenium.utils.ByTypes;
import com.everis.vivo.robotester.selenium.utils.SeleniumUtils;

public class SeleniumTest extends SeleniumUtils{

	private static final String BASE_URL = "https://www.google.com.br";
	private static final String GOOGLE_SEARCH_BAR = "/html/body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[@class='tsf-p']/div[@class='sfibbbc']/div[@id='sbtc']/div[@class='sbibtd']/div[@id='sfdiv']/div[@class='lst-c']/div[@class='gstl_0 sbib_a']/div[@id='sb_ifc0']/div[@id='gs_lc0']/input[@id='lst-ib']";
	private static final String PESQUISA_BTN = "/html/body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[@class='tsf-p']/div[@class='jsb']/center/input[1]";
	private static final String PACMAN_BOX = "/html/body[@id='gsr']/div[@id='main']/div[@id='cnt']/div[@class='mw'][2]/div[@id='rcnt']/div[@class='col'][1]/div[@id='center_col']/div[@id='res']/div[@id='search']/div/div[@id='ires']/div[@id='rso']/div[@class='bkWMgd'][1]/div[@class='g mnr-c g-blk']/div[@class='kp-blk Wnoohf OJXvsb']/div[@class='xpdopen rYczAc']/div[@class='ifM9O']/div[2]/div[@class='yp1CPe mod']/div/div[@class='lbULyc']/div[@class='ACcnec']/span[@class='vk_h vk_bk']";
	private static final String PACMAN_TEXT = "Play PAC-MAN Doodle";
	private static final String PACMAN = "pacman";	
	@Test
	public void test() {
		
		setChromeBrowser();

		gotoPage(BASE_URL);
		
		sendText2Element(ByTypes.XPATH, PACMAN, GOOGLE_SEARCH_BAR);
		
		clickElement(ByTypes.XPATH,PESQUISA_BTN);
		
		assertTrue(checkTextElement(ByTypes.XPATH,PACMAN_TEXT, PACMAN_BOX));
		
		closeBrowser();
	}
}
