package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.BillDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.BillRequest;
import bo.ucb.edu.ingsoft.model.Bill;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

}
