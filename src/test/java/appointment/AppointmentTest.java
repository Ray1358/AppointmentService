package appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;

class AppointmentTest {

    private Date getFutureDate() {
        return new Date(System.currentTimeMillis() + 86_400_000L);
    }

    private Date getPastDate() {
        return new Date(System.currentTimeMillis() - 86_400_000L);
    }

    @Test
    void testAppointmentCreation() {
        Date futureDate = getFutureDate();

        Appointment appointment = new Appointment(
                "APT001",
                futureDate,
                "Doctor appointment"
        );

        assertEquals("APT001", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor appointment", appointment.getDescription());
    }

    @Test
    void testAppointmentIdExactlyTenCharacters() {
        Appointment appointment = new Appointment(
                "1234567890",
                getFutureDate(),
                "Valid appointment"
        );

        assertEquals("1234567890", appointment.getAppointmentId());
    }

    @Test
    void testAppointmentIdCannotBeNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        null,
                        getFutureDate(),
                        "Valid appointment"
                )
        );
    }

    @Test
    void testAppointmentIdCannotBeLongerThanTenCharacters() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "12345678901",
                        getFutureDate(),
                        "Valid appointment"
                )
        );
    }

    @Test
    void testAppointmentDateCannotBeNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "APT001",
                        null,
                        "Valid appointment"
                )
        );
    }

    @Test
    void testAppointmentDateCannotBeInPast() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "APT001",
                        getPastDate(),
                        "Valid appointment"
                )
        );
    }

    @Test
    void testDescriptionExactlyFiftyCharacters() {
        String description =
                "12345678901234567890123456789012345678901234567890";

        Appointment appointment = new Appointment(
                "APT001",
                getFutureDate(),
                description
        );

        assertEquals(description, appointment.getDescription());
    }

    @Test
    void testDescriptionCannotBeNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "APT001",
                        getFutureDate(),
                        null
                )
        );
    }

    @Test
    void testDescriptionCannotBeLongerThanFiftyCharacters() {
        String description =
                "123456789012345678901234567890123456789012345678901";

        assertThrows(
                IllegalArgumentException.class,
                () -> new Appointment(
                        "APT001",
                        getFutureDate(),
                        description
                )
        );
    }

    @Test
    void testAppointmentDateCanBeUpdated() {
        Appointment appointment = new Appointment(
                "APT001",
                getFutureDate(),
                "Doctor appointment"
        );

        Date updatedDate =
                new Date(System.currentTimeMillis() + 172_800_000L);

        appointment.setAppointmentDate(updatedDate);

        assertEquals(updatedDate, appointment.getAppointmentDate());
    }

    @Test
    void testUpdatedAppointmentDateCannotBeNull() {
        Appointment appointment = new Appointment(
                "APT001",
                getFutureDate(),
                "Doctor appointment"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> appointment.setAppointmentDate(null)
        );
    }

    @Test
    void testUpdatedAppointmentDateCannotBeInPast() {
        Appointment appointment = new Appointment(
                "APT001",
                getFutureDate(),
                "Doctor appointment"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> appointment.setAppointmentDate(getPastDate())
        );
    }

    @Test
    void testDescriptionCanBeUpdated() {
        Appointment appointment = new Appointment(
                "APT001",
                getFutureDate(),
                "Original description"
        );

        appointment.setDescription("Updated description");

        assertEquals(
                "Updated description",
                appointment.getDescription()
        );
    }

    @Test
    void testUpdatedDescriptionCannotBeNull() {
        Appointment appointment = new Appointment(
                "APT001",
                getFutureDate(),
                "Doctor appointment"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> appointment.setDescription(null)
        );
    }

    @Test
    void testUpdatedDescriptionCannotBeLongerThanFiftyCharacters() {
        Appointment appointment = new Appointment(
                "APT001",
                getFutureDate(),
                "Doctor appointment"
        );

        String description =
                "123456789012345678901234567890123456789012345678901";

        assertThrows(
                IllegalArgumentException.class,
                () -> appointment.setDescription(description)
        );
    }
}