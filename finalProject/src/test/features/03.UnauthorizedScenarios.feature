Feature: Unauthorized Operations 
Background: 
	Given I am on main application page
	
@Search 
Scenario: 
	When I input "Freddie Mercury" in search field and press search button 
	Then I see results of search are displayed 
	
@SwitchFeed 
Scenario: 
	When I click enable feed link 
	Then I see that feed is enabled 
	Then I click disable feed link 
	And I see that feed is disabled 
	
@WeatherTests 
Scenario: 
	When I move to weather page 
	Then I see that weather block is present and current URL is "https://pogoda.mail.ru/prognoz/minsk/"