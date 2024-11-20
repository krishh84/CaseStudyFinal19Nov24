Feature: Conduit CRUD functions

Background: Login into App
Given User is on Login page
When User provide "g.raja@tcs.com" and "Srivatsav@53"
Then User should be Home Page

Scenario: Create new Article
Given User should be on new Article Page
When User enters Article details
 |titleTest5 | DescTest5 | ContentTest5 | tagtest5 |
Then Article must be created

Scenario: View Article
Given User should be Global Feed Page
When User select an article "titleTest5"
Then Article detail page must be displayed

#Scenario: update an Article
#Given Article detail page must be displayed
#When User update article detail
#Then Article detail must be updated

#Scenario: Delete an Article
#Given Article detail page must be displayed
#When User delete article
#Then Article must be deleted





