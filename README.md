# Steerlean-Project

End Points:
•	/pet end-points
•	POST /pet - Add a new pet to the store
•	PUT /pet - Update an existing pet
•	GET /pet/findByStatus - Find Pets by status
•	POST /pet/{petId} - Updates a pet in the store with form data
•	DELETE /pet/{petId} - Deletes a pet

•	/store end-points
•	POST /store/order - Place an order for a pet
•	GET /store/order/{orderId} - Find purchase order by ID
•	DELETE /store/order/{orderId} - Delete purchase order by ID

workflows tested:
•	Add a new pet and place an order for the same
•	Find an “available” pet and place an order for the same

mechanism to execute the tests:
Used both Rest Assured and Karate framework to execute the tests

