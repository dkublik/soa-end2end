package pl.dk.soa.candidate.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dk.soa.candidate.service.CandidatePersonalDetails;
import pl.dk.soa.candidate.service.CandidateService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/v0/candidates/profile", produces = APPLICATION_JSON_VALUE)
@Api(description = "candidate data")
class CandidateControllerV0 {

    private final CandidateService candidateService;

    CandidateControllerV0(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    @ApiOperation(value = "get all candidates data")
    @SuppressWarnings("unchecked")
    List<CandidatePersonalDetails> getCandidates() {
        return candidateService.getCandidates();
    }

    @GetMapping("{candidateId}")
    @ApiOperation(value = "get candidate data")
    @SuppressWarnings("unchecked")
    ResponseEntity<CandidatePersonalDetails> getCandidate(@PathVariable String candidateId) {
        return candidateService.getCandidate(candidateId)
                .map(data -> new ResponseEntity(data, OK))
                .orElse(new ResponseEntity(NOT_FOUND));
    }
}
