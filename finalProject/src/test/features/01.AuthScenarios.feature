Feature: Authorized Operations 

Background: 
	Given I am on the main page 
@ValidCredentials 
Scenario: Valid Auth Tests 
	When I login with valid credentials 
	Then I see logout link 
	Then I logout 
	And I see register link 