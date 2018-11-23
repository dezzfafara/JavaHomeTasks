Feature: Move from spam 

@MoveFromSpam 
Scenario: Move from spam test 
	Given I Am on main page 
	When I Login with valid login "v.afan.91" and password "PVTpvt1" and select correct domain "@inbox.ru" 
	Then I See logout link 
	Then I Move "0" email from spam 
	And I Close browser 
