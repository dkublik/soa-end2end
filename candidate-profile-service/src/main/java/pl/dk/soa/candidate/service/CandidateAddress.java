package pl.dk.soa.candidate.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateAddress {

    private String country;
    private String city;
    private String street;
    private String zip;
}
