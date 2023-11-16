Feature: OrangeHRM Login

@regression
Scenario Outline: OrangeHRM DDT login

Given User is on login page
When User clicks on login by entering username as <username> and password as <password>
Then login success is "true"

Examples:
|username		|password	|
|admin			|admin123	|
|adminA			|adminA123|
|adminB			|adminB123|
|adminC			|adminC123|