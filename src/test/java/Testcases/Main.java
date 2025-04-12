package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import FristProject.Project.Base;
import landingPage.landingpagebase;

public class Main extends Base {
	@Test
	public void train() throws InterruptedException, IOException {

		driver = initailzer();
		landingpagebase irctc = new landingpagebase(driver);
		irctc.url();
		irctc.image();
		irctc.starting("CHENNAI", "CHENNAI EGMORE - MS(CHENNAI)");
		irctc.ending("BAN", "BANDRA TERMINUS - BDTS (MUMBAI)");
		irctc.clickbox();
		irctc.ladiesbox();
		Thread.sleep(2000);
		irctc.clickdate();
		irctc.trainbrith();
		irctc.ticketdate();
		Thread.sleep(2000);
		irctc.ticketbook();
		irctc.mutipledorpdown();
		irctc.checkloaction();
		irctc.handlebusandwindow();
		irctc.checkbrokenlinks();
		irctc.checkallfooter();

	}	
	


}