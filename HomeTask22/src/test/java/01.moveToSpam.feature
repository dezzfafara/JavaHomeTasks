Feature: Move to spam 

@MoveFromSpam 
Scenario: Move to spam test 
	Given I am on main page 
	When I login with valid login "v.afan.91" and password "PVTpvt1" and select correct domain "@inbox.ru" 
	Then I see logout link 
	Then I move "0" email to spam 
	And I close browser 
