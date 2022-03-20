package insurance;

import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(String name, double price, Date startDate, Date finishDate) {
        super(name, price, startDate, finishDate);
    }

    @Override
    public void calculate() {

    }
}