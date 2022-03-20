package insurance;

import java.util.Date;

public class TravelInsurance extends Insurance{
    public TravelInsurance(String name, double price, Date startDate, Date finishDate) {
        super(name, price, startDate, finishDate);
    }

    @Override
    public void calculate() {

    }
}