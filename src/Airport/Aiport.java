
package Airport;

import Companies.Company;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Landazuri
 */


public class Aiport {
 
    private char id;
    private String name;
    private String city;
    private String country;
    private ArrayList<Company> listOfCompanies = new ArrayList<>();
    private int numberCompany;
    
    public Aiport(char id, String name, String city, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.numberCompany = 0;
    }
    
    public Aiport(char id, String name, String city, String country,ArrayList<Company> companies) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.listOfCompanies = companies;
        this.numberCompany = companies.size(); 
    }

    
    public char getId() {
        return id;
    } 

    public int getNumberCompany() {
        return numberCompany;
    }
    
    public void setId(char id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNumberCompany(int numberCompany) {
        this.numberCompany = numberCompany;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Company> getListOfCompanies() {
        return listOfCompanies;
    }

    public void setListOfCompanies(ArrayList<Company> listOfCompanies) {
        this.listOfCompanies = listOfCompanies;
    }

    public void insertCompany(Company company){
        listOfCompanies.add(company);
        numberCompany++;
    }
   
    public Company getCompany(int i){
        return listOfCompanies.get(i);
    }
    
    public Company getCompany(String name){
        boolean found = false;
        int i = 0;
        Company companyFound = null;
        
        while((found == false) && (i < listOfCompanies.size())){
            if(name.equals(listOfCompanies.get(i).getName())){
                found = true;
                companyFound = listOfCompanies.get(i);
            }
            i++;
        }
        return companyFound;
    }

    @Override
    public String toString() {
        return "Aiport{" + "id=" + id + ", name=" + name + ", city=" + city + ", country=" + country + ", listOfCompanies=" + listOfCompanies + ", numberCompany=" + numberCompany + '}';
    }
    
    
    
}
