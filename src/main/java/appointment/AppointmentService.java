package appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        appointments = new HashMap<>();
    }

    //Adds a new appointment.Appointment IDs must be unique.

    public void addAppointment(Appointment appointment) {

        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }

        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }

        appointments.put(appointment.getAppointmentId(), appointment);
    }


    // Deletes an appointment by its ID.

    public void deleteAppointment(String appointmentId) {

        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }

        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }

        appointments.remove(appointmentId);
    }


     //Returns an appointment Used mainly for testing.

    public Appointment getAppointment(String appointmentId) {

        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }

        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }

        return appointments.get(appointmentId);
    }

    //Returns the number of appointments.
    public int getAppointmentCount() {
        return appointments.size();
    }
}