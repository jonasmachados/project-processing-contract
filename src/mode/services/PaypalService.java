package mode.services;

import domain.entities.Contract;

public class PaypalService implements OnlinePaymentService {

    @Override
    public double payment(Double amount) {
        amount += amount + 2 / 100;
        return amount;
    }

    @Override
    public double interest(Double amount, Integer months) {

        amount += amount / months;
        amount += (amount + months)/ 100;

        return amount;
    }

}
