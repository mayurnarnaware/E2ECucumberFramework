Feature: OrangeHRM Login

@sanity
Scenario: OrangeHRM default login

Given User is on login page
When User clicks on login by entering username as "admin" and password as "admin123"
Then login success is "true"

@smoke
Scenario: OrangeHRM invalid login

Given User is on login page
When User clicks on login by entering username as "adminA" and password as "adminA123"
Then login success is "false"