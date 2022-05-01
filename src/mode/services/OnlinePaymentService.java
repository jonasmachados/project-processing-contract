package mode.services;

import domain.entities.Contract;

public interface OnlinePaymentService {

    double payment(Double amount);
    
    double interest(Double amount, Integer months);

}
