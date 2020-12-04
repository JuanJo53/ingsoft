package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.BillRequest;
import bo.ucb.edu.ingsoft.model.Bill;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BillDao {
    public Bill detailsByBillId(Integer billId);
    public void newBill(Bill bill);
    public List<BillRequest> getBills(Integer userid);
}
