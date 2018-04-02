package pl.dk.soa.candidate.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidatePersonalDetails {

    private String login;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String photoPath;
    private String personalDescription;
    private CandidateAddress address;

}
