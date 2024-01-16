package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    void canCreateContact() {
        var contact = new ContactData()
                .withFirstname(randomString(10))
                .withLastname(randomString(10))
                .withPhoto("src/test/resources/images/avatar.png");
        app.contacts().create(contact);
    }
}
