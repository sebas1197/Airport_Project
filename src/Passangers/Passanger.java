/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Passangers;

/**
 *
 * @author Sebastian Landazuri
 */
public class Passanger {
    
   private char id;
   private String name;
   private String passport;
   private String nationality;

    public Passanger(char id, String name,String passport, String nationality) {
        this.id = id;
        this.name = name;
        this.passport = passport;
        this.nationality = nationality;
    }

    public char getId() {
        return id;
    }

    public String getName() {
        return name;
    }

     public String getPassport() {
        return passport;
    }
     
    public String getNationality() {
        return nationality;
    }

    public void setId(char id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
   
    
    
}
