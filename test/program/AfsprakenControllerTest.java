package program;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AfsprakenControllerTest {
    private AfsprakenController afsprakenController = new AfsprakenController();
    public ObservableList<Appointment> appointments = FXCollections.observableArrayList();
    private homescreenController homescreenController = new homescreenController();
    private Doctor doctor = new Doctor("Dr. Piet de Slang",
            afsprakenController.firstDoctorWorkingDays(),
            afsprakenController.firstDoctorWorkingTimesPerDay(),
            afsprakenController.firstDoctorSpecializations());
    private Doctor doctor2 = new Doctor("Dr. Kees de Beer",
            afsprakenController.firstDoctorWorkingDays(),
            afsprakenController.secondDoctorWorkingTimesPerDay(),
            afsprakenController.secondDoctorSpecializations());
    private Appointment appointment = new Appointment(doctor,
            afsprakenController.firstDoctorWorkingDays().get(2),
            afsprakenController.firstDoctorWorkingTimes().get(2),
            afsprakenController.firstDoctorSpecializations().get(1));
    private Appointment appointment2 = new Appointment(doctor2,
            afsprakenController.firstDoctorWorkingDays().get(2),
            afsprakenController.secondDoctorWorkingTimes().get(3),
            afsprakenController.secondDoctorSpecializations().get(1));
    private Appointment appointment3 = new Appointment(doctor,
            afsprakenController.firstDoctorWorkingDays().get(2),
            afsprakenController.firstDoctorWorkingTimes().get(3),
            afsprakenController.secondDoctorSpecializations().get(1));

    public void setup(){
        Data.allAppointments.clear();
        homescreenController.setStartingData();
        if(Data.doctors.isEmpty()){
            Data.doctors.add(doctor);
            Data.doctors.add(doctor2);
        }
        afsprakenController.doctorSelected = doctor;
        afsprakenController.daySelected = afsprakenController.firstDoctorWorkingDays().get(2);
        afsprakenController.timeSelected = afsprakenController.firstDoctorWorkingTimes().get(2);
        afsprakenController.specializationSelected = afsprakenController.firstDoctorSpecializations().get(1);
        afsprakenController.addButtonClicked();
        appointments.add(appointment);
    }

    @Test
    public void checkAfspraakMogelijk(){
        setup();

        assertEquals(appointments.get(0).getDoctor(), Data.allAppointments.get(1).getDoctor());
        assertEquals(appointments.get(0).getDay(), Data.allAppointments.get(1).getDay());
        assertEquals(appointments.get(0).getTime(), Data.allAppointments.get(1).getTime());
        assertEquals(appointments.get(0).getSpecialization(), Data.allAppointments.get(1).getSpecialization());
    }

    @Test
    public void checkBeschikbaarheidTijd(){
        setup();

        afsprakenController.doctorSelected = doctor;
        afsprakenController.daySelected = afsprakenController.firstDoctorWorkingDays().get(2);
        afsprakenController.timeSelected = afsprakenController.firstDoctorWorkingTimes().get(2);
        afsprakenController.specializationSelected = afsprakenController.firstDoctorSpecializations().get(1);
        afsprakenController.addButtonClicked();

        assertEquals(appointments.get(0).getDoctor(), Data.allAppointments.get(2).getDoctor());
        assertEquals(appointments.get(0).getDay(), Data.allAppointments.get(2).getDay());
        assertEquals(appointments.get(0).getTime(), Data.allAppointments.get(2).getTime());
        assertEquals(appointments.get(0).getSpecialization(), Data.allAppointments.get(2).getSpecialization());
    }

    @Test
    public void checkSpecialicatieChecker(){
        Data.allAppointments.clear();
        afsprakenController.doctorSelected = doctor;
        afsprakenController.specializationSelected = afsprakenController.secondDoctorSpecializations().get(1);
        assertFalse(afsprakenController.checkDoctorSpecialization());
    }

    //Deze test checkt of firstAppointments wordt aangepast, zodat op het hoofdscherm altijd de eerstkomende afspraak wordt laten zien.
    @Test
    public void checkEersteAfspraak(){
        Data.allAppointments.clear();
        ObservableList<Appointment> firstappointment = FXCollections.observableArrayList();
        Data.allAppointments.add(appointment);
        Data.allAppointments.add(appointment2);
        Data.firstAppointments.add(appointment2);
        firstappointment.add(appointment);
        afsprakenController.updateFirstAppointment();
        assertEquals(firstappointment, Data.firstAppointments);
    }
}
