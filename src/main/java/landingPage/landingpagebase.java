package landingPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpagebase  {

	WebDriver driver;

	public landingpagebase(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@id='disha-banner-close']")
	WebElement banner;

	@FindBy(css = ".ng-tns-c57-8.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ui-autocomplete-input.ng-star-inserted")
	WebElement from;

	@FindBy(xpath = "//li/span[@class='ng-star-inserted']")
	List<WebElement> autosuggestion;

	@FindBy(xpath = "//input[@class='ng-tns-c57-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")
	WebElement to;

	@FindBy(xpath = "//li/span[@class='ng-star-inserted']")
	List<WebElement> autosuggestions;

	@FindBy(xpath = "//span[@class='ng-tns-c65-12 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement box;

	@FindBy(xpath = "//li[@aria-label='LADIES']")
	WebElement ladies;

	@FindBy(xpath = "//label[normalize-space()='Flexible With Date']")
	WebElement date;

	@FindBy(xpath = "//label[normalize-space()='Train with Available Berth']")
	WebElement train;

	@FindBy(xpath = "//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")
	WebElement ticket;

	@FindBy(xpath = "//a[normalize-space()='11']")
	WebElement booking;

	@FindBy(xpath = "//span[@class='ng-tns-c65-11 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement mutiple;

	@FindBy(xpath = "//span[normalize-space()='Vistadome AC (EV)']")
	WebElement loaction;

	public void url() {
		driver.get("https://www.irctc.co.in/nget/train-search");

	}

	public void image() {
		banner.click();
	}

	public void starting(String start, String fname) throws InterruptedException {
		from.sendKeys(start);
		Thread.sleep(2000);
		for (WebElement option : autosuggestion) {
			option.getText().equalsIgnoreCase(fname);
			option.click();
			break;
		}

	}

	public void ending(String end, String ename) throws InterruptedException {
		to.sendKeys(end);
		Thread.sleep(2000);
		for (WebElement options : autosuggestions) {
			options.getText().equalsIgnoreCase(ename);
			options.click();
			break;
		}
	}

	public void clickbox() {
		box.click();

	}

	public void ladiesbox() throws InterruptedException {
		ladies.click();

	}

	public void clickdate() {
		date.click();

	}

	public void trainbrith() {
		train.click();
	}

	public void ticketdate() {
		ticket.click();
	}

	public void ticketbook() {
		booking.click();
	}

	public void mutipledorpdown() {
		mutiple.click();
	}

	public void checkloaction() {
		loaction.click();
	}

	public void handlebusandwindow() {
		JavascriptExecutor down = (JavascriptExecutor) driver;
		down.executeScript("window.scrollBy(0,600)");
		WebElement bus = driver.findElement(By.xpath("//label[normalize-space()='BUS']"));
		down.executeScript("arguments[0].click();", bus);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentid);
	}

	public void checkbrokenlinks() throws IOException {
		WebElement link = driver.findElement(By.xpath("//div[@class='iconsection']//ul"));
		List<WebElement> links = link.findElements(By.tagName("a"));
		List<String> text = links.stream().map(s -> s.getText()).filter(s -> !s.isEmpty()).collect(Collectors.toList());
		text.forEach(s -> System.out.println(s));
		System.out.println(links.size());
		for (WebElement clink : links) {
			String url = clink.getDomAttribute("href");
			if (url == null || url.isEmpty() || url.equals("#")) {
				continue;
			}
			HttpURLConnection cwlink = (HttpURLConnection) new URL(url).openConnection();
			cwlink.setRequestMethod("HEAD");
			cwlink.connect();
			int code = cwlink.getResponseCode();
			if (code < 400) {
				System.out.println(url + code);
			} else {
				System.out.println(url + code);
			}
		}
	}

	public void checkallfooter() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"dFooter\"]/div/div/div"));
		List<WebElement> dropdowns = dropdown.findElements(By.xpath("//button[@class='btn_Tab']"));
		{
			for (int i = 0; i < dropdowns.size(); i++) {
				dropdowns.get(i).click();
				Thread.sleep(1000);
				dropdowns.get(i).click();

			}

		}
	}

	public String getFromLocationValue() 
	{
	    return from.getDomAttribute("value");
	}

	public String getToLocationValue() 
	{
		return to.getDomAttribute("value");
	
	}


}
