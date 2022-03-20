package insurance;

import java.util.Date;

public class HealthInsurance extends Insurance{
    public HealthInsurance(String name, double price, Date startDate, Date finishDate) {
        super(name, price, startDate, finishDate);
    }

    @Override
    public void calculate() {

    }
}
