package pl.dk.soa.apply.resource;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import pl.dk.soa.apply.store.StoredApplication;

public class ApplicationStatusMatcher extends BaseMatcher<StoredApplication> {

    public static ApplicationStatusMatcher isNotProcessed() {
        return new ApplicationStatusMatcher();
    }

    @Override
    public boolean matches(Object o) {
        StoredApplication application = (StoredApplication) o;
        return application.getStatus() == StoredApplication.Status.NEW;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("application status should be ").appendValue(StoredApplication.Status.NEW.toString());
    }

    @Override
    public void describeMismatch(Object item, Description description) {
        description.appendText("was ").appendValue(((StoredApplication) item).getStatus().toString());
    }
}
