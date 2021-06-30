/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airport;

import Passangers.Passanger;

/**
 *
 * @author Sebastian Landazuri 
 */
public class Flight {
    
    private char id;
    private String hometown;
    private String arrivalCity;
    private float price;
    private int numberMaxPassangers;
    private int numberActualPassangers;
    private Passanger listOfPassangers [];

    public Flight(char id, String hometown, String arrivalCity, float price, int numberMaxPassangers) {
        this.id = id;
        this.hometown = hometown;
        this.arrivalCity = arrivalCity;
        this.price = price;
        this.numberMaxPassangers = numberMaxPassangers;
        this.numberActualPassangers = 0;
        this.listOfPassangers = new Passanger[numberMaxPassangers];
    }

    public char getId() {
        return id;
    }

    public String getHometown() {
        return hometown;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public float getPrice() {
        return price;
    }

    public int getNumberMaxPassangers() {
        return numberMaxPassangers;
    }

    public int getNumberActualPassangers() {
        return numberActualPassangers;
    }

    public Passanger[] getListOfPassangers() {
        return listOfPassangers;
    }

    public void setId(char id) {
        this.id = id;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setNumberMaxPassangers(int numberMaxPassangers) {
        this.numberMaxPassangers = numberMaxPassangers;
    }

    public void setNumberActualPassangers(int numberActualPassangers) {
        this.numberActualPassangers = numberActualPassangers;
    }

    public void setListOfPassangers(Passanger[] listOfPassangers) {
        this.listOfPassangers = listOfPassangers;
    }
    
    
    public void insertPassanger(Passanger passanger){
        listOfPassangers[numberActualPassangers] = passanger;
        numberActualPassangers++;
    }
    
    
    public Passanger findPassanger(int i){
        return listOfPassangers[i];
    }
    
    public Passanger findPassanger(String passport){
        boolean found = false;
        int i = 0;
        Passanger passangerFound = null;
        
        while((found == false) && (i < listOfPassangers.length)){
            if(passport.equals(listOfPassangers[i].getPassport())){
                found = true;
                passangerFound = listOfPassangers[i];
            }
            i++;
        }
        return passangerFound;
    }
    
    
}
