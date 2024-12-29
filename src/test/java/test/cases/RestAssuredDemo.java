package test.cases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredDemo {


    @Test
    public void CreateToken() {
        String body = """
                {
                     "username" : "admin",
                     "password" : "password123"
                }
                """;
        RestAssured
                .given().header("Content-Type", "application/json").body(body).log().all()
                .when().post("https://restful-booker.herokuapp.com/auth")
                .then().statusCode(200).and().log().body();
    }

    @Test
    public void restAssuredTestCreateBooking() {
        String body = """
                {
                    "firstname": "martina",
                    "lastname": "ibrahim",
                    "totalprice": 100,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2024-02-23",
                        "checkout": "2024-10-23"
                    },
                    "additionalneeds": "CupCake"
                }
                """;
        RestAssured
                .given().contentType(ContentType.JSON).body(body).log().all()
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(equalTo(200)).body("booking.firstname", equalTo("martina"))
                .and().log().body();
    }

    @Test
    public void restAssuredGetBookingByIdDynamic() {
        ///first create booking
        String body = """
                {
                    "firstname": "mariam",
                    "lastname": "garas",
                    "totalprice": 100,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2024-02-23",
                        "checkout": "2024-10-23"
                    },
                    "additionalneeds": "CottonCandy"
                }
                """;
        String bookingId = RestAssured
                .given().contentType(ContentType.JSON).body(body).log().all()
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200).and().log().body().extract().body().jsonPath().get("bookingid").toString();

        ///second get booking by id by returning response object to facilitate assertion
        Response getBookingByIdResponse = RestAssured
                .given().header("Accept", "application/json").pathParam("bookingid", bookingId).log().all()
                .when().get("https://restful-booker.herokuapp.com/booking/{bookingid}")
                .then()
                .statusCode(200)
                .and().log().body().extract().response();
        /// assertion by testng not rest assured
        String firstname = getBookingByIdResponse.body().jsonPath().get("firstname").toString();
        Assert.assertEquals(firstname, "mariam");
    }

    @Test
    public void restAssuredTestDeleteBookingDynamic() {
        String body = """
                {
                     "username" : "admin",
                     "password" : "password123"
                }
                """;
        String token = RestAssured
                .given().header("Content-Type", "application/json").body(body).log().all()
                .when().post("https://restful-booker.herokuapp.com/auth")
                .then().statusCode(200).and().log().body().extract().body().jsonPath().get("token").toString();

        String bodyofbooking = """
                {
                    "firstname": "martina",
                    "lastname": "ibrahim",
                    "totalprice": 100,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2024-02-23",
                        "checkout": "2024-10-23"
                    },
                    "additionalneeds": "CupCake"
                }
                """;
        String bookingid = RestAssured
                .given().contentType(ContentType.JSON).body(bodyofbooking).log().all()
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then().statusCode(200).and().log().body().extract().body().jsonPath().get("bookingid").toString();

        System.out.println("Token: " + token);
        System.out.println("Booking ID: " + bookingid);

//        Response getDeletedResponse = RestAssured.given().contentType(ContentType.JSON)
//                .header("Cookie", "token=" + token).pathParam("bookingid", bookingid).log().all()
//                .when().delete("https://restful-booker.herokuapp.com/booking/{bookingid}")
//                .then().statusCode(201).and().log().body().extract().response();
//
//        // Extract the response message as a string
//        String message = getDeletedResponse.getBody().asString();
//
//        // Assert that the response contains "Created"
//        assertThat(message, containsString("Created"));

        RestAssured
                .given().contentType(ContentType.JSON).header("Cookie", "token=" + token)
                .when().delete("https://restful-booker.herokuapp.com/booking/"+bookingid)
                .then().statusCode(201).body(equalTo("Created")).log().body();
    }
}

