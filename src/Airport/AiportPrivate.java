/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airport;

import Companies.Company;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Landazuri
 */
public class AiportPrivate extends Aiport{
    
    private ArrayList<String> listOfBusiness = new ArrayList<>();
    private int numberBusiness;

    public AiportPrivate(char id, String name, String city, String country) {
        super(id, name, city, country);
    }

    public AiportPrivate(char id, String name, String city, String country, ArrayList<Company> companies, ArrayList<String> business) {
        super(id, name, city, country, companies);
        this.listOfBusiness = business;
        this.numberBusiness = listOfBusiness.size();
    }

    public ArrayList<String> getListOfBusiness() {
        return listOfBusiness;
    }

    public void setListOfBusiness(ArrayList<String> listOfBusiness) {
        this.listOfBusiness = listOfBusiness;
    }

    public int getNumberBusiness() {
        return numberBusiness;
    }

    public void setNumberBusiness(int numberBusiness) {
        this.numberBusiness = numberBusiness;
    }
    
    
    public void insertBusiness(ArrayList<String> business){
        this.listOfBusiness = business;
        this.numberBusiness = listOfBusiness.size();
    }
    
    public void insertBusine(String business){
        this.listOfBusiness.add(business);
    }

    @Override
    public String toString() {
        return "AiportPrivate{" + "listOfBusiness=" + listOfBusiness + ", numberBusiness=" + numberBusiness + '}';
    }
    
    
    
}
