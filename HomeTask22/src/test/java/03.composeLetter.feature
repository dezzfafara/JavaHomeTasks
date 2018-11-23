Feature: Compose Letter 

@ComposeLetter 
Scenario: Compose Letter test 
	Given I Am On main page 
	When I Login With valid login "v.afan.91" and password "PVTpvt1" and select correct domain "@inbox.ru" 
	Then I See Logout link 
	Then I Compose letter with parameters "TEST_GROUP_LETTER" "TEST_GROUP_LETTER TEXT" "tes1@mail.com" "tes2@mail.com" "tes1@mail.com" 
	And I Close Browser 
