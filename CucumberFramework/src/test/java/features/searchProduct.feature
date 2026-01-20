Feature: Search the products and Place the order 

@OffersPage
Scenario Outline: Search Experience for product search in both Home and Offers Page
Given User is on GreenCart Landing page
When user searched with Shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page
And  validate product name in offers page matches with Landing Page

Examples: 
| Name |
| Tom |
| Beet |
