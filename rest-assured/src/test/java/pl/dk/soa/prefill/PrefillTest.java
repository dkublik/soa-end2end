package pl.dk.soa.prefill;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import pl.dk.soa.Hosts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class PrefillTest {

    @Test
    public void shouldGetDataForPrefill() {
        // given
        RequestSpecification requestSpecification = given().pathParam("candidateId", "mHamill");

        // when
        Response response = requestSpecification.when().get(Hosts.PREFILL_HOST + "/v1/prefill/for-candidate/{candidateId}");

        // then
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstName", is("Mark"))
                .body("lastName", is("Hamill"))
                .body("email", is("mark.hamill@gmail.com"));
    }

}