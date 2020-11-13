Feature: Find an “available” pet and place an order for the same

Background:
	* def addPayload = read('classpath:Resources/AddPetPayload.json')
	* def global = read('classpath:Resources/global.json')
	* headers {Content-Type : 'application/json', Accept : 'application/json'}

Scenario: Perform placing an order for pet and finding purchase order by ID and delete purchase order by ID

# Place an order for a pet
	Given url global.URI + global.storeResource
  	When json payload = addPayload[0]
 	And request payload
 	When method POST
 	Then status 200	
	* def pID = response.id
		
# Find purchase order by ID
	Given url global.URI + global.storeResource + '/' + pID
 	When method GET
 	Then status 200	
	And match response.status == "placed"
	
# Delete purchase order by ID
	Given url global.URI + global.storeResource + '/' + pID
 	When method DELETE
 	Then status 200	
	And match response.code == 200

	