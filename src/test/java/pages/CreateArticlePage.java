package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateArticlePage {
	@FindBy(linkText = "New Article")
	WebElement newArtBtn;
	
	@FindBy(name = "title")
	WebElement entrTitle;
	
	@FindBy(xpath = "//input[@name =  'description']")
	WebElement entrDescrpt;
	
	@FindBy(name = "body")
	WebElement entrBody;
	
	@FindBy(name = "tags")
	WebElement entrTags;
	
	@FindBy(xpath = "//button[text() = 'Publish Article']")
	WebElement publishBtn;
	
	@FindBy(xpath ="//a[contains(text(),'Raja')]" )
	WebElement articleCreated;
	
public CreateArticlePage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}

public void clickCreateArt() {
	newArtBtn.click();
}
public void newArticlePg(String eTitle,String eDescrpt,String eBody,String eTags) throws InterruptedException {
	entrTitle.sendKeys(eTitle);
	Thread.sleep(2000);
	entrDescrpt.sendKeys(eDescrpt);
	entrBody.sendKeys(eBody);
	entrTags.sendKeys(eTags);
	publishBtn.click();
}

public boolean isArticleCreated() {
	return articleCreated.isDisplayed();
}
}
