package pl.dk.soa.apply.resource;

import org.junit.Test;
import pl.dk.soa.apply.store.StoredApplication;

import static org.junit.Assert.assertTrue;

public class ApplicationConverterTest {

    ApplicationConverter applicationConverter = new ApplicationConverter();

    @Test
    public void shouldConvertApplication_Gen1() {
        // given
        Application application = new Application();
        application.setCandidateId("jSnow");
        application.setListingId("123");
        application.setMessageToRecruiter("eager to work for the whole winter!");

        // when
        StoredApplication storedApplication = applicationConverter.toStoredApplication(application);

        // then
        assertTrue(storedApplication.getId() != null);
        assertTrue(storedApplication.getCandidateId() == "jSnow1");
        assertTrue(storedApplication.getListingId() == "123");
        assertTrue(storedApplication.getMessageToRecruiter() == "eager to work for the whole winter!");
    }

}