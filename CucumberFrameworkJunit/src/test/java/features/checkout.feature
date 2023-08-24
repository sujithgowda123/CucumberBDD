Feature: search and checkout the order for products 
@placeorder
Scenario: Search a product and place the order by checking out 
	Given User is on greencart  landing page 
	When user searched with shortname <Name> and extracted actualname of product 
	And added "3" items of the selected product to cart
	Then user proceeds to checkout and validate the <Name> items in checkout page
	And verify user has ability to apply promocode and place the order

	Examples: 
	
	| Name|
	| Beetroot |
	
	
