package pl.dk.soa.candidate;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static pl.dk.soa.Hosts.CANDIDATE_HOST;

class JsonPathExamples {

    @Test
    void propertiesByDot() {
        // when
        Response response = when().get(CANDIDATE_HOST + "/v0/candidates/profile");

        // then
        response.then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("candidates[0].login", is("just_britney"))
                .body("candidates[0].address.country", is("Poland"));
    }

    @Test
    void propertiesByDotReverse() {
        // when
        Response response = when().get(CANDIDATE_HOST + "/v0/candidates/profile");

        // then
        response.then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("candidates[-1].login", is("mrpresident"))
                .body("candidates[-1].address.country", is("Poland"));
    }

    @Test
    void find() {
        // when
        Response response = when().get(CANDIDATE_HOST + "/v0/candidates/profile");

        // then
        response.then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("candidates.find { it.login == 'just_britney' }.address.city", is("Bydgoszcz"))
                .body("candidates.findAll { it.address.city == 'Warsaw' }.login", hasItems("mhamill", "mrpresident"))
                .body("candidates.findAll { it.email.endsWith('pl') }.login", hasItems("just_britney", "mrpresident"));
    }

    @Test
    void min() {
        // when
        Response response = when().get(CANDIDATE_HOST + "/v0/candidates/profile");

        // then
        response.then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("candidates.min { it.address.zip }.login", is("mrpresident"));
    }

    @Test
    void aggregates() {
        // when
        Response response = when().get(CANDIDATE_HOST + "/v0/candidates/profile");

        // then
        response.then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .body("candidates.size()", is(3))
                .body("candidates.login.collect { it.length() }.sum()", is(30));
    }

    @Test
    void extractingJsonPathObject() {
        // when
        Response response = when().get(CANDIDATE_HOST + "/v0/candidates/profile");

        // then
        int size = JsonPath.from(response.asString()).getInt("candidates.size()");
        Assert.assertEquals(3, size);
    }

}