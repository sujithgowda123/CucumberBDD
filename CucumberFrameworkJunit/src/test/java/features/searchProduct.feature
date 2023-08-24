Feature: search and place the order for products 
@Offerspage
Scenario: Search experience for product search in both home and offers page 
	Given User is on greencart  landing page 
	When user searched with shortname <Name> and extracted actualname of product 
	Then User searched for <Name> product in offers page 
	And validate product name in offers page matches with landing page 
	
	Examples:
	
	| Name|
	| Tom |
	| Beet|