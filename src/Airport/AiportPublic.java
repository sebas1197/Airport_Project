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
public class AiportPublic extends Aiport{
    
    private float subsidy;

    public AiportPublic(char id, String name, String city, String country) {
        super(id, name, city, country);
    }

    public AiportPublic(float subsidy, char id, String name, String city, String country, ArrayList<Company> companies) {
        super(id, name, city, country, companies);
        this.subsidy = subsidy;
    }

    public AiportPublic(float subsidy, char id, String name, String city, String country) {
        super(id, name, city, country);
        this.subsidy = subsidy;
    }

    public float getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(float subsidy) {
        this.subsidy = subsidy;
    }

    @Override
    public String toString() {
        return "AiportPublic{" + "subsidy=" + subsidy + '}';
    }
    
    
    
}
