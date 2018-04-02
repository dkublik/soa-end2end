package pl.dk.soa.candidate;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static pl.dk.soa.Hosts.CANDIDATE_HOST;

class CandidateTest {

    @Test
    void shouldGetProfileDetails() {
        // given / when
        // test zasobu: GET http://localhost:8082/v0/candidates/profile/{candidateId}
        // testowany uzytkownik mHamill


        // then
        // do sprawdzenia co najmniej:
        // status odpowiedzi
        // content type odpowiedzi
        // login
        // name
        // surname
        // email
        // address.country
        // address.city
        // address.street


        // hints:
        // 1. http://localhost:8082 jest stala w Hosts.CANDIDATE_HOST
        // 2. odpowiedz mozna podejrzec pod http://localhost:8082/swagger-ui.html

    }

}