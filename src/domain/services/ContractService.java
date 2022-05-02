package domain.services;

import domain.entities.Contract;
import domain.entities.Installment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class ContractService {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private OnlinePaymentService paymentService;

    //CONSTRUCTOR
    public ContractService() {
    }

    //CONSTRUCTOR
    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) throws ParseException {

        for (int i = 1; i <= months; i++) {

            Calendar cal = Calendar.getInstance();
            cal.setTime(contract.getDate());
            cal.add(Calendar.MONTH, i);
            Date dateInst = cal.getTime();
            
            double amount = contract.getTotalValue() / months;        

            double pPayment = 0;
            double pinterest = 0;

            pinterest = paymentService.interest(amount, i);
            pPayment = paymentService.payment(pinterest);

            contract.getInstallment().add(new Installment(dateInst, pPayment));

        }

    }

}
