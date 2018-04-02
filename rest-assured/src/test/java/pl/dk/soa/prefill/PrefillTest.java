package pl.dk.soa.prefill;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import pl.dk.soa.Hosts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

class PrefillTest {

    @Test
    void shouldGetDataForPrefill() {
        // given
        RequestSpecification requestSpecification = given().pathParam("candidateId", "mHamill");

        // when
        Response response = requestSpecification.when().get(Hosts.PREFILL_HOST + "/v1/prefill/for-candidate/{candidateId}");

        // then
        response.then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("firstName", is("Mark"))
                .body("lastName", is("Hamill"))
                .body("email", is("mark.hamill@gmail.com"));
    }

}