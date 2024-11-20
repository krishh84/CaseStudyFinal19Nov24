package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewArticlePage {
	@FindBy(xpath = "//a[text()='Home']")
	WebElement clckHomeBtn;
	
	@FindBy(xpath = "//button[text() = 'Global Feed']")
	WebElement viewArt;
	
	@FindBy(xpath = "//a[@class = 'preview-link']")
	WebElement artList;
	
	@FindBy(css ="div>h1" )
	WebElement articleCreated;


public ViewArticlePage(WebDriver driver) {
	
	PageFactory.initElements(driver,this);
}
public void clickHomeBtn() {
	clckHomeBtn.click();
}
public void clickGobalFeed() {
	viewArt.click();
}

public void articleList(String art) {
	artList.sendKeys(art);
	artList.click();
}

public boolean articleDis() {
	return articleCreated.isDisplayed();
}
}