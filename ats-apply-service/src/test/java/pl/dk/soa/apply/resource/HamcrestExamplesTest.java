package pl.dk.soa.apply.resource;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

class HamcrestExamplesTest {

    @Test
    void beanProperties() {
        Application application = new Application();
        application.setCandidateId("jSnow");
        application.setListingId("123");
        application.setMessageToRecruiter("eager to work for the whole winter!");

        assertThat(application.getCandidateId(), is("jSnow"));
        assertThat(application.getCandidateId(), equalToIgnoringCase("JSNOW"));
        assertThat(application.getMessageToRecruiter(), Matchers.stringContainsInOrder(asList("eager", "work", "winter!")));
        assertThat(application, hasProperty("listingId", is("123")));
        assertThat(application, samePropertyValuesAs(referenceApplication()));
    }

    private Application referenceApplication() {
        Application application = new Application();
        application.setCandidateId("jSnow");
        application.setListingId("123");
        application.setMessageToRecruiter("eager to work for the whole winter!");
        return application;
    }

    @Test
    void collections() {
        List<Integer> list = asList(9, 12, 31, 42, 8, 4);

        assertThat(list, hasSize(6));
        assertThat(list, everyItem(greaterThan(3)));
        assertThat(list, everyItem(anyOf(greaterThan(30), Matchers.lessThan(15))));
        assertThat(list, hasItem(greaterThan(30)));
    }

}