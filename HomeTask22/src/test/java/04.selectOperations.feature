Feature: Select Operations 

@SelectOperations 
Scenario: Select Operations test 
	Given I Am On Main page 
	When I Login With Valid login "v.afan.91" and password "PVTpvt1" and select correct domain "@inbox.ru" 
	Then I See Logout Link 
	Then I select "3" letters 
	And I CLose Browser 
