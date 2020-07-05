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

    //Deze test kijkt of als er op addButtonClicked de juiste appointment wordt toegevoegd
    @Test
    public void checkAfspraakMogelijk(){
        setup();

        assertEquals(appointments.get(0).getDoctor(), Data.allAppointments.get(1).getDoctor());
        assertEquals(appointments.get(0).getDay(), Data.allAppointments.get(1).getDay());
        assertEquals(appointments.get(0).getTime(), Data.allAppointments.get(1).getTime());
        assertEquals(appointments.get(0).getSpecialization(), Data.allAppointments.get(1).getSpecialization());
    }

    //Deze test kijkt of de tijd verwijderd is, als de tijd verwijderd is bij de setup functie, dan zou je i.p.v. bij getWorkingTimes(2).get(2) een 10:00 uur (deze tijd is verwijderd bij de setup) nu een 11:00 uur krijgen
    @Test
    public void checkBeschikbaarheidTijd(){
        Data.allAppointments.clear();
        Data.firstAppointments.clear();
        setup();

        afsprakenController.doctorSelected = doctor;
        afsprakenController.daySelected = afsprakenController.firstDoctorWorkingDays().get(2);
        afsprakenController.timeSelected = Data.doctors.get(0).getWorkingTimes(2).get(2);
        afsprakenController.specializationSelected = afsprakenController.firstDoctorSpecializations().get(1);
        afsprakenController.addButtonClicked();

        assertEquals("11:00", Data.allAppointments.get(2).getTime());
    }

    //Deze test kijkt of de functie checkDoctorSpecialization op de juiste manier werkt
    @Test
    public void checkSpecialisatieChecker(){
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
