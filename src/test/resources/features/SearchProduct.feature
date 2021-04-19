@Search
Feature: Validate user is able to add multiple products into cart

	@ProductSeach
	Scenario: User is able to search for various products and add each type of products into cart
	Given User navigated to the home application url
	When User search following product from search box and add into cart
	| ITEM 												|PRODUCT_NAME								| QUANTITY |
	|Dress												|Printed Chiffon Dress			| 1				 |
	|T-shirts											|Faded Short Sleeve T-shirts| 2				 |
	|Casual												|Printed Dress							| 3				 |
	Then User cart is updated with the products and quantity

 


