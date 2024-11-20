package stepDefs;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateArticlePage;
import pages.LoginPage;
import pages.ViewArticlePage;

public class ArticleStepDef {
	WebDriver driver = TestBase.getDriver();
	LoginPage loginPage;
	CreateArticlePage createArticlePage;
	ViewArticlePage viewArticlePage;
	
public ArticleStepDef() {
	loginPage = new LoginPage(driver);
	createArticlePage = new CreateArticlePage(driver);
	viewArticlePage = new ViewArticlePage(driver);
}
@Given("User is on Login page")
public void user_is_on_login_page() {
	TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
}
@When("User provide {string} and {string}")
public void user_provide_and(String strUser, String strPwd) {
	loginPage.validLogin(strUser, strPwd);
	
}
@Then("User should be Home Page")
public void user_should_be_home_page() {
    Assert.assertTrue(loginPage.isLoggedin());;
}

@Given("User should be on new Article Page")
public void user_should_be_on_new_article_page() {
	createArticlePage.clickCreateArt();
}
@When("User enters Article details")
public void user_enters_article_details(DataTable dataTable) throws InterruptedException {
	List<List<String>> data = dataTable.asLists();
	String title = data.get(0).get(0);
	String Desc = data.get(0).get(1);
	String Content = data.get(0).get(2);
	String tag = data.get(0).get(3);
	createArticlePage.newArticlePg(title, Desc, Content, tag);
}
@Then("Article must be created")
public void article_must_be_created() {
   Assert.assertTrue(createArticlePage.isArticleCreated());
}
@Given("User should be Global Feed Page")
public void user_should_be_global_feed_page() {
	viewArticlePage.clickHomeBtn();
	viewArticlePage.clickGobalFeed();
}
@When("User select an article {string}")
public void user_select_an_article(String art) {
	viewArticlePage.articleList(art);
}
@Then("Article detail page must be displayed")
public void article_detail_page_must_be_displayed() {
    Assert.assertTrue(viewArticlePage.articleDis());
}
}
