Feature: Inbox Operations 

Background: 
	Given I am on the main application page 
	Then I login 
	
@SendLetter 
Scenario: Send letter 
	When I compose and send letter: "TEST_SUBJECT", "TEST_MESSAGE", "tes1@mail.com", "tes2@mail.com", "test3@mail.com" 
	Then I see success send page 
	
@Remove 
Scenario: Remove 
	When I select and remove all letters 
	Then I see that inbox folder is empty 
	When I move to bin folder and move all letters to inbox 
	And I see that bin folder is empty 
	
@AddFolder 
Scenario: 
	When I click configure folders and add folder "MY_TEST_FOLDER" 
	Then I see that folder "MY_TEST_FOLDER" is added 
	
@FlagOperations 
Scenario: 
	When I mark all letters with flags 
	Then I see that all letters are marked with flag 
	
@SubjectSorting 
Scenario: 
	When I sort letters by subject in ascending order 
	Then I see that letters are sorted in ascending order