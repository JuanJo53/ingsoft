package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.DonationDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.DonationRequest;
import bo.ucb.edu.ingsoft.model.Donation;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DonationBl {
    private DonationDao donationDao;
    private TransactionDao transactionDao;

    @Autowired
    public DonationBl(DonationDao donationDao, TransactionDao transactionDao){
        this.donationDao = donationDao;
        this.transactionDao = transactionDao;
    }

    public Donation detailsByDonationId(Integer donationId){
        return donationDao.detailsByDonationId(donationId);
    }

    public DonationRequest createDonation(Integer userid, Integer projectid, Integer cardid, DonationRequest donationRequest, Transaction transaction){
        Donation donation = new Donation();

        donation.setUserId(userid);
        donation.setProjectsId(projectid);
        donation.setCardId(cardid);
        donation.setDonationDate(new Date());
        donation.setAmount(donationRequest.getAmount());
        donation.setStatus(1);

        donation.setTransaction(transaction);
        donationDao.newDonation(donation);

        return donationRequest;
    }

    public List<DonationRequest> getDonation(Integer userid){
        return donationDao.getDonations(userid);
    }
}
