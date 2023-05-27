Feature: Login Functionality

  @validLogin
  Scenario Outline: User Should Login With Valid Credentials
    Given Post Login API
    When Provide Valid Credential "<email>""<password>"
    Then Status_code equals 200
    Examples:
      | email                | password
      | merchant@foodics.com | 123456


  @invalidLogin
  Scenario Outline: Email and Password Validation in Login API
    Given Post Login API
    When Provide different combinations to "<email>""<password>"
    Then Status_code equals <statuscode>
    Examples:
      |email     		|password    | statuscode
      | abc@abc.com   	| password   |   401
      | abc	  	        |            |   401
