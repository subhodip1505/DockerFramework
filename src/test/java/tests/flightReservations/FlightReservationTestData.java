package tests.flightReservations;

public record FlightReservationTestData(String firstname,
										String lastname, 
										String email, 
										String password, 
										String street, 
										String city, 
										String zip, 
										String passengerCount, 
										String expectedPrice) {

}
