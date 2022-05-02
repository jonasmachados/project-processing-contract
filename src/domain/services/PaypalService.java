package domain.services;

import domain.entities.Contract;

public class PaypalService implements OnlinePaymentService {

    @Override
    public double payment(Double amount) {
        double div = amount * 0.02;
        amount = amount + div;
        return amount;
    }

    @Override
    public double interest(Double amount, Integer months) {
        double div = (amount + months) / 100 * months;
        amount = amount + div;
        return amount;
    }

}
