/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportProyect;

import Airport.Aiport;
import Airport.AiportPrivate;
import Airport.AiportPublic;
import Airport.Flight;
import Companies.Company;
import Passangers.Passanger;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian Landazuri
 */
public class main {
    
     
    
    static Scanner cin = new Scanner(System.in);
    static ArrayList<Aiport> aiports = new ArrayList<Aiport>();
    
    
    public static void main(String[] args) {
 
        
        insertDataAirport(aiports);
        mainMenu();
     
    
}
    
    public static void insertDataAirport(ArrayList<Aiport> airport ){
      
      char id = 65;
      ArrayList<String> business = new ArrayList<>();
      business.add("EmpresaOne");
      business.add("EmpresaTwo");
        
      airport.add(new AiportPublic(8000000,id,"Mitad del mundo", "Quito", "Ecuador"));
      airport.get(0).insertCompany(new Company(id,"Tame"));
      airport.get(0).insertCompany(new Company(id,"Aerogal"));
      airport.get(0).getCompany("Tame").insertFlight(new Flight(id, "Quito", "Guayaquil", 100, 200));
      airport.get(0).getCompany("Aerogal").insertFlight(new Flight(id, "Cuenca", "Loja", 150, 100));
      airport.get(0).getCompany("Aerogal").getFlight(id).insertPassanger(new Passanger(id, "Sebastian", "1234LDU", "Ecuatoriano"));
      
      airport.add(new AiportPrivate(id, "Privates aerolines", "New York", "U.S.A"));
      airport.get(1).insertCompany(new Company(id, "AirUSA"));
      ((AiportPrivate)airport.get(1)).insertBusiness(business);
      airport.get(1).getCompany("AirUSA").insertFlight(new Flight(id, "Cuenca", "Loja",170.25f, 250));
      airport.get(1).getCompany("AirUSA").getFlight(id).insertPassanger(new Passanger(id, "Melissa", "MeliPass", "Argentina"));
      
         
    }
    

    public static void mainMenu(){
        int option = 0;
        String nameAirport;
        String nameCompany;
        String hometown;
        String arrivalCity;
        Aiport airpotExist;
        Company companyExist;
        
        
        do{
            
            option = Integer.parseInt(JOptionPane.showInputDialog("\t\t\tMENU"
            +"\n1) Ver Aeropuertos Gestionados"
            +"\n2) Ver Empresas (Privado) o Subvencion (Publico)"
            +"\n3) Lista de compañias"
            +"\n4) Lista de Vuelos por Compañia"
            +"\n5) Listar posibles Vuelos de Origen a Destino"
            +"6) SALIR"));
            
            switch(option){
                
                case 1:       
                    showDataAiports(aiports);
                    break;
                    
                case 2: 
                    collaborators(aiports);
                    break;
                    
                case 3: 
                    nameAirport = JOptionPane.showInputDialog("Digite el nombre del Aeropuerto: ");                 
                    airpotExist=findAirport(nameAirport,aiports);
                    
                    if(airpotExist == null){
                        JOptionPane.showMessageDialog(null, "El aeropuerto no existe");
                    }else{
                        showCompanies(airpotExist);
                    }    
                        
                    break;
                    
                case 4: 
                    nameAirport = JOptionPane.showInputDialog("Digite el nombre del Aeropuerto: ");
                        
                    airpotExist = findAirport(nameAirport,aiports);
                    
                    if(airpotExist == null){
                        JOptionPane.showMessageDialog(null, "El aeropuerto no existe");
                    }else{
                        nameCompany = JOptionPane.showInputDialog("Digite el nombre de la compañia: ");
                        
                        companyExist = airpotExist.getCompany(nameCompany);
                        
                        if(companyExist == null){
                            JOptionPane.showMessageDialog(null,"La compañia no existe" );
                        }else{
                            showFlights(companyExist);
                        }
                    }  
                    break;
                    
                case 5: 
                        
                        hometown = JOptionPane.showInputDialog("Digite una Ciudad Origen: ");
                        arrivalCity = JOptionPane.showInputDialog("Digite una Ciudad de Destino: ");
                       
                        showHometownArrivalFlights(hometown, arrivalCity, aiports);
                    break;
                    
                case 6: 
                    break;
                    
                default : JOptionPane.showMessageDialog(null, "Opcion incorrecta");
            }
            
            
        }while(option!=6);
    }
    
    
    public static void showDataAiports(ArrayList<Aiport> airports){
        for(int i=0;i<airports.size();i++){

            if(airports.get(i) instanceof AiportPrivate){
                JOptionPane.showMessageDialog(null,"Aeropuerto Privado" 
                +"\nID: "+airports.get(i).getId()
                +"\nNombre: "+airports.get(i).getName()
                +"\nCiudad: "+airports.get(i).getCity()
                +"\nPais: "+airports.get(i).getCountry());
            }else{
                 JOptionPane.showMessageDialog(null,"Aeropuerto Publico" 
                +"\nID: "+airports.get(i).getId()
                +"\nNombre: "+airports.get(i).getName()
                +"\nCiudad: "+airports.get(i).getCity()
                +"\nPais: "+airports.get(i).getCountry());
            }
        }
    }
    
    public static void collaborators(ArrayList<Aiport> airports){
        
        ArrayList<String> business = new ArrayList<>();
        
        for(int i=0;i<airports.size();i++){
              if(airports.get(i) instanceof AiportPrivate){
                  business = ((AiportPrivate)airports.get(i)).getListOfBusiness();
                  JOptionPane.showMessageDialog(null, "Aeropuerto Privado " + airports.get(i).getName()
                  +"\nEmpresas: ");
                  
                  for (String busines : business) {
                      JOptionPane.showMessageDialog(null,busines);
                  }
              }else{
                  JOptionPane.showMessageDialog(null,"Aeropuerto Publico "+airports.get(i).getName() 
                  +"\nSubvencion: "+((AiportPublic)airports.get(i)).getSubsidy());
              }
           }
        }
    
    public static Aiport findAirport(String nameAirport, ArrayList<Aiport> airports){
        boolean found=false;
        int i=0;
        Aiport airportFound = null;
        
        while((!found) && (i<airports.size())){
            if(nameAirport.equals(airports.get(i).getName())){
                found = true;
                airportFound = airports.get(i);
            }
            i++;
        }
        return airportFound;
    }
    
    public static void showCompanies(Aiport airport){
        JOptionPane.showMessageDialog(null, "Las compañias del aeropuerto "+airport.getName()+" son: ");
        
        for(int i=0;i<airport.getNumberCompany();i++){
            JOptionPane.showMessageDialog(null,airport.getCompany(i).getName() );
        }
    }
    
    public static void showFlights(Company company){
            JOptionPane.showMessageDialog(null, "\nLos vuelos de la compañia "+company.getName()+" son: ");
            Flight flight;
            
        for(int i=0;i<company.getNumberFlight();i++){
            flight=company.getFlight(i);
            JOptionPane.showMessageDialog(null,"ID: "+flight.getId()
            +"Ciudad Origen: "+flight.getHometown()
            +"Ciudad Destino: "+flight.getArrivalCity()
            +"Precio: "+flight.getPrice());
        }
    }
    
    
    public static Flight[] findFlightsHometownArrival(String hometown, String arrivalCity, ArrayList<Aiport> airports){
        
        Flight flight;
        int accountant=0;
        int x=0;
        Flight listFlight [];
        
        for(int i=0;i<2;i++){
            for(int j=0;j<airports.get(i).getNumberCompany();j++){
                for(int k=0;k<airports.get(i).getCompany(j).getNumberFlight();k++){
                    flight=airports.get(i).getCompany(j).getFlight(k);
                    
                    if(hometown.equals(flight.getHometown()) && arrivalCity.equals(flight.getArrivalCity())){
                        accountant++;
                    }
                }
            }
        }
        
        listFlight = new Flight[accountant];
        
          for(int i=0;i<2;i++){
            for(int j=0;j<airports.get(i).getNumberCompany();j++){
                for(int k=0;k<airports.get(i).getCompany(j).getNumberFlight();k++){
                    flight=airports.get(i).getCompany(j).getFlight(k);
                    
                    if(hometown.equals(flight.getHometown()) && arrivalCity.equals(flight.getArrivalCity())){
                        listFlight [x] = flight;
                        x++;
                    }
                }
            }
        }
          
          return listFlight;
        
    }
    
    public static void showHometownArrivalFlights(String hometown, String arrivalCity,ArrayList<Aiport> airports ){
        Flight flights [];
        flights = findFlightsHometownArrival(hometown, arrivalCity, airports);
        
        if(flights.length==0){
            System.out.println("\nNO EXISTEN VUELOS EN ESA RUTA");
        }else{
            System.out.println("\nLos vuelos encontrados en esa ruta son: ");
            
            for (Flight flight : flights) {
                System.out.println("\n\tID: " + flight.getId());
                System.out.println("\tCiudad de Origen: " + flight.getHometown());
                System.out.println("\tCiudad de Destino: " + flight.getArrivalCity());
                System.out.println("\tPrecio: " + flight.getPrice() + "\n");
            }
        }
        
        
        
    }
    
  }
    
















