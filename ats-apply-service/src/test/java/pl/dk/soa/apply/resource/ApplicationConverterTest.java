package pl.dk.soa.apply.resource;

import org.junit.jupiter.api.Test;
import pl.dk.soa.apply.store.StoredApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationConverterTest {

    ApplicationConverter applicationConverter = new ApplicationConverter();

    @Test
    void shouldConvertApplication_Gen1() {
        // given
        Application application = new Application();
        application.setCandidateId("jSnow");
        application.setListingId("123");
        application.setMessageToRecruiter("eager to work for the whole winter!");

        // when
        StoredApplication storedApplication = applicationConverter.toStoredApplication(application);

        // then
        assertTrue(storedApplication.getId() != null);
        assertTrue(storedApplication.getCandidateId() != "jSnow");
        assertTrue(storedApplication.getListingId() == "123");
        assertTrue(storedApplication.getMessageToRecruiter() == "eager to work for the whole winter!");

        assertNotNull(storedApplication.getId());
        assertEquals("jSnow", storedApplication.getCandidateId());
        assertEquals("123", storedApplication.getListingId());
        assertEquals("eager to work for the whole winter!", storedApplication.getMessageToRecruiter());
    }

    @Test
    void shouldConvertApplication_Gen2() {
        // given
        Application application = new Application();
        application.setCandidateId("jSnow");
        application.setListingId("123");
        application.setMessageToRecruiter("eager to work for the whole winter!");

        // when
        StoredApplication storedApplication = applicationConverter.toStoredApplication(application);

        // then
        assertTrue(storedApplication.getId() != null);
        assertTrue(storedApplication.getCandidateId() == "jSnow");
        assertTrue(storedApplication.getListingId() == "123");
        assertTrue(storedApplication.getMessageToRecruiter() == "eager to work for the whole winter!");

        assertNotNull(storedApplication.getId());
        assertEquals("jSnow", storedApplication.getCandidateId());
        assertEquals("123", storedApplication.getListingId());
        assertEquals("eager to work for the whole winter!", storedApplication.getMessageToRecruiter());
    }

    @Test
    void shouldConvertApplication_Gen3() {
        // given
        Application application = new Application();
        application.setCandidateId("jSnow");
        application.setListingId("123");
        application.setMessageToRecruiter("eager to work for the whole winter!");

        // when
        StoredApplication storedApplication = applicationConverter.toStoredApplication(application);

        // then
        assertTrue(storedApplication.getId() != null);
        assertTrue(storedApplication.getCandidateId() == "jSnow");
        assertTrue(storedApplication.getListingId() == "123");
        assertTrue(storedApplication.getMessageToRecruiter() == "eager to work for the whole winter!");

        assertNotNull(storedApplication.getId());
        assertEquals("jSnow", storedApplication.getCandidateId());
        assertEquals("123", storedApplication.getListingId());
        assertEquals("eager to work for the whole winter!", storedApplication.getMessageToRecruiter());
    }

}