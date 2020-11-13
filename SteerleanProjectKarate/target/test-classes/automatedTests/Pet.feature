Feature: Add a new pet and place an order for the same

Background:
	* def addPayload = read('classpath:Resources/AddPetPayload.json')
	* def global = read('classpath:Resources/global.json')
	* header Content-Type = 'application/json'

Scenario: Add a new pet to the store, update it, find pets by status, update pet with form data, delete it

# Add a new pet to the store
	Given url global.URI + global.petResource
  	When json payload = addPayload[1]
 	And request payload
 	When method POST
 	Then status 200	
	* def pID = response.id
		
# Update an existing pet
	Given url global.URI + global.petResource
  	When json payload = addPayload[2]
 	And request payload
 	When method PUT
 	Then status 200	
	And match response.name == "doggie9988"
	
# Find Pets by status	
	Given url global.URI + global.petResource + '/findByStatus'
	And param status = "available"
 	When method GET
 	Then status 200	

# Updates a pet in the store with form data	
	Given url global.URI + global.petResource + '/' + pID
	And form field name = "ABCD998"
	And form field status = "sold"
	And header Content-Type = 'application/x-www-form-urlencoded' 
 	When method POST
 	Then status 200	
	And match response.code == 200
	
# Deletes a pet
	Given url global.URI + global.petResource + '/' + pID
 	When method DELETE
 	Then status 200	
 	And match response.code == 200

	
	
	
	