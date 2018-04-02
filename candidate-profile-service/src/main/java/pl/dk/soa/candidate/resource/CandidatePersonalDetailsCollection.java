package pl.dk.soa.candidate.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dk.soa.candidate.service.CandidatePersonalDetails;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidatePersonalDetailsCollection {

    private List<CandidatePersonalDetails> candidates;

}
