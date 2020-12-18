package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.BillDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.BillRequest;
import bo.ucb.edu.ingsoft.model.Bill;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BillBl {
    private BillDao billDao;
    private TransactionDao transactionDao;

    @Autowired
    public BillBl(BillDao billDao, TransactionDao transactionDao) {
        this.billDao = billDao;
        this.transactionDao = transactionDao;
    }

    public Bill detailsByBillId(Integer billId) {
        return billDao.detailsByBillId(billId);
    }


    public BillRequest createBill(Integer userid, Integer projectid, Integer planid, Integer cardid, BillRequest billRequest, Transaction transaction) {
        validationBill(billRequest);
        Bill bill = new Bill();

        bill.setUserId(userid);
        bill.setProjectsId(projectid);
        bill.setPaymentPlanId(planid);
        bill.setCardId(cardid);
        bill.setBuyDate(new Date());
        bill.setBillingAddress(billRequest.getBillingAddress());
        bill.setCountry(billRequest.getCountry());
        bill.setCity(billRequest.getCity());
        bill.setStatus(1);

        bill.setTransaction(transaction);
        billDao.newBill(bill);

        return billRequest;
    }

    public List<BillRequest> getBill(Integer userid) {
        return billDao.getBills(userid);
    }


    private void validationBill(BillRequest billRequest) {
        String regex_address = "[A-Za-zÁÉÍÓÚáéíóúñÑ#0-9 ]{0,50}";
        Pattern pattern = Pattern.compile(regex_address);
        Matcher matcher = pattern.matcher(billRequest.getBillingAddress());
        if (!matcher.matches()) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Dirección de envio incorrecto.");
        }

        String regex_country = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]{0,}";
        Pattern pattern_country = Pattern.compile(regex_country);
        Matcher matcher_country = pattern_country.matcher(billRequest.getCountry());
        if (!matcher_country.matches() || billRequest.getCountry().length() > 20 || billRequest.getCountry().length() < 4) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "País incorrecto.");
        }

        Matcher matcher_city = pattern_country.matcher(billRequest.getCity());
        if (!matcher_city.matches() || billRequest.getCity().length() > 20 || billRequest.getCity().length() < 4) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Ciudad incorrecta.");
        }
    }

}
