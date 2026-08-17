package appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

    private AppointmentService appointmentService;
    private Appointment appointment;

    private Date getFutureDate() {
        return new Date(System.currentTimeMillis() + 86_400_000L);
    }

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();

        appointment = new Appointment(
                "APT001",
                getFutureDate(),
                "Doctor appointment"
        );
    }

    @Test
    void testAddAppointment() {
        appointmentService.addAppointment(appointment);

        assertEquals(
                appointment,
                appointmentService.getAppointment("APT001")
        );

        assertEquals(
                1,
                appointmentService.getAppointmentCount()
        );
    }

    @Test
    void testAddMultipleAppointments() {

        Appointment secondAppointment = new Appointment(
                "APT002",
                getFutureDate(),
                "Dental appointment"
        );

        appointmentService.addAppointment(appointment);
        appointmentService.addAppointment(secondAppointment);

        assertEquals(
                2,
                appointmentService.getAppointmentCount()
        );
    }

    @Test
    void testCannotAddNullAppointment() {

        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService.addAppointment(null)
        );
    }

    @Test
    void testCannotAddDuplicateAppointmentId() {

        Appointment duplicateAppointment = new Appointment(
                "APT001",
                getFutureDate(),
                "Duplicate appointment"
        );

        appointmentService.addAppointment(appointment);

        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService.addAppointment(duplicateAppointment)
        );

        assertEquals(
                1,
                appointmentService.getAppointmentCount()
        );
    }

    @Test
    void testDeleteAppointment() {

        appointmentService.addAppointment(appointment);

        appointmentService.deleteAppointment("APT001");

        assertEquals(
                0,
                appointmentService.getAppointmentCount()
        );
    }

    @Test
    void testCannotDeleteNullAppointmentId() {

        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService.deleteAppointment(null)
        );
    }

    @Test
    void testCannotDeleteAppointmentThatDoesNotExist() {

        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService.deleteAppointment("APT999")
        );
    }

    @Test
    void testGetAppointment() {

        appointmentService.addAppointment(appointment);

        Appointment returnedAppointment =
                appointmentService.getAppointment("APT001");

        assertEquals(
                "APT001",
                returnedAppointment.getAppointmentId()
        );

        assertEquals(
                "Doctor appointment",
                returnedAppointment.getDescription()
        );
    }

    @Test
    void testCannotGetAppointmentWithNullId() {

        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService.getAppointment(null)
        );
    }

    @Test
    void testCannotGetAppointmentThatDoesNotExist() {

        assertThrows(
                IllegalArgumentException.class,
                () -> appointmentService.getAppointment("APT999")
        );
    }
}