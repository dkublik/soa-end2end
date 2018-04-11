package pl.dk.soa.candidate;

import com.atlassian.oai.validator.restassured.SwaggerValidationFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static pl.dk.soa.Hosts.CANDIDATE_HOST;

class OpenApiValidationExample {

    SwaggerValidationFilter validationFilter = new SwaggerValidationFilter("candidate-swagger-v1.yaml");

    @Test
    void shouldValidateAgainstOpenApiSpecification() {
        // given:
        RequestSpecification request = given()
                .filter(validationFilter);

        // when:
        Response response = request.when()
                .get(CANDIDATE_HOST + "/v1/candidates/profile");

        // then
        response.then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("login", is("mhamill"));
    }

}