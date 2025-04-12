package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import FristProject.Project.Base;
import landingPage.landingpagebase;

public class Errorvalidation extends Base {

	@Test
	public void train() throws InterruptedException, IOException {

		driver = initailzer();
		landingpagebase irctc = new landingpagebase(driver);
		irctc.url();
		irctc.image();
		irctc.starting("PU", "PATCHUR - PU ");
		Assert.assertTrue(true);

	}

	@Test
	public void train1() throws IOException, InterruptedException {
		driver = initailzer();
		landingpagebase irctc = new landingpagebase(driver);
		irctc.url();
		irctc.image();
		irctc.ending("GO", "GHOTI - GO ");
		Assert.assertTrue(true);

	}

}
