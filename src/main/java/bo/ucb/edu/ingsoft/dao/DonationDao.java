package bo.ucb.edu.ingsoft.dao;
import bo.ucb.edu.ingsoft.dto.DonationRequest;
import bo.ucb.edu.ingsoft.model.Donation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonationDao {
    public Donation detailsByDonationId(Integer donationId);
    public void newDonation(Donation donation);
    public List<DonationRequest> getDonations(Integer userid);

}
