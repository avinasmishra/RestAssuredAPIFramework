Feature: AddPlace API's Validation

# Data Driven Scenarios
@AddPlace
Scenario Outline: Verify if AddPlace api is successful added

Given add input payload details with "<name>" "<language>" "<address>"
When user submit "AddPlaceAPI" api with http "POST" request
Then verify the status code 200
And verify the "status" in response body is "OK" 
And verify the "scope" in response body is "APP" 
And verify placeId creted and maps to "<name>" using "getPlaceAPI"

Examples:
| name   | language | address  |
| Kunal  |  Hindi   | New Delhi|
| Avinash|  English | Banglore |

@DeletePlace
Scenario: Verify if DeletePlaceAPI functionality is working correctly
Given deletePlace payload
When user submit "deletePlaceAPI" api with http "POST" request
Then verify the status code 200
And verify the "status" in response body is "OK" 

