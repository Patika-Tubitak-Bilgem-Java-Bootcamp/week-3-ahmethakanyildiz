package insurance;

import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance(String name, double price, Date startDate, Date finishDate) {
        super(name, price, startDate, finishDate);
    }

    @Override
    public void calculate() {

    }
}