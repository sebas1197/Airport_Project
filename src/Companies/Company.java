/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Companies;

import Airport.Flight;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Landazuri 
 */
public class Company {
    
    private char id;
    private String name;
    private ArrayList<Flight> listOfFlights = new ArrayList<>();
    private int numberFlight = 0;

    public Company(char id, String name) {
        this.id = id;
        this.name = name;    
    }
    
    public Company(char id, String name,ArrayList<Flight> flight) {
        this.id = id;
        this.name = name;    
        listOfFlights = flight;
        numberFlight = flight.size();
    }

    public char getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberFlight() {
        return numberFlight;
    }
    
    
    public ArrayList<Flight> getListOfFlights() {
        return listOfFlights;
    }

    public void setId(char id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListOfFlights(ArrayList<Flight> listOfFlights) {
        this.listOfFlights = listOfFlights;
    }

    public void setNumberFlight(int numberFlight) {
        this.numberFlight = numberFlight;
    }
    
    
    
    public void insertFlight(Flight flight){
        listOfFlights.add(flight);
        numberFlight++;
    }
    
    public Flight getFlight(int i){
        return listOfFlights.get(i);
    }
    
    public Flight getFlight(char id){
        boolean found = false;
        int i = 0;
        Flight flightFound = null;
        
        while((found == false) && (i < listOfFlights.size())){
            if(id == listOfFlights.get(i).getId()){
                found = true;
                flightFound = listOfFlights.get(i);
            }
            i++;
        }
        return flightFound;
    }
    
    
}
