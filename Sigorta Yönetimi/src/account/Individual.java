package account;

import insurance.*;

import java.util.ArrayList;
import java.util.Date;

public class Individual extends Account{
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurancePolicy(String name, double price, Date startDate, Date finishDate, int type) {
        ArrayList<Insurance> list = this.getInsuranceList();
        if(type==1){
            HealthInsurance i = new HealthInsurance(name,price,startDate,finishDate);
            list.add(i);
            this.setInsuranceList(list);
        }
        else if(type==1){
            CarInsurance i = new CarInsurance(name,price,startDate,finishDate);
            list.add(i);
            this.setInsuranceList(list);
        }
        else if(type==1){
            ResidenceInsurance i = new ResidenceInsurance(name,price,startDate,finishDate);
            list.add(i);
            this.setInsuranceList(list);
        }
        else{
            TravelInsurance i = new TravelInsurance(name,price,startDate,finishDate);
            list.add(i);
            this.setInsuranceList(list);
        }
    }
}
