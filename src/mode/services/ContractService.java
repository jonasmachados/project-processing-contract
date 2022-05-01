package mode.services;

import domain.entities.Contract;
import domain.entities.Installment;
import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePaymentService paymentService;

    //CONSTRUCTOR
    public ContractService() {
    }

    //CONSTRUCTOR
    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(contract.getDate());

        double pPayment = 0;
        double pinterest = 0;

        double total = 0;
        for (int i = 0; i < 10; i++) {

            cal.add(Calendar.DAY_OF_MONTH, i);
            Date dateInst = cal.getTime();
            pinterest = paymentService.interest(contract.getTotalValue(), i);
            pPayment = paymentService.payment(pinterest);

            contract.getInstallment().add(new Installment(dateInst, (double) i));

        }

    }

}
