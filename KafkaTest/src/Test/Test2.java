package Test;

import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.db.ConnectionFactory;
import com.pay.dto.AccountDto;
import com.pay.dto.Message;

import net.sf.json.JSONObject;

import com.pay.domain.Account;
import com.pay.domain.Payment;
import com.pay.domain.Tradinfo;

public class Test2 {
	private static SqlSession mysession = ConnectionFactory.getSession();

	public static void main(String[] args) throws Exception {

		try {

			// ArrayList<Account> acclist = (ArrayList<Account>)
			// mysession.selectList("com.dao.AccountMapper.selectAll");

			ArrayList<Tradinfo> acclist = (ArrayList<Tradinfo>) mysession.selectList("com.dao.TradinfoMapper.selectAll",
					0);

			Iterator it1 = acclist.iterator();
			while (it1.hasNext()) {

				Tradinfo newtrad = (Tradinfo) it1.next();
				System.out.println(newtrad.getId() + " " + newtrad.getTradCus() + newtrad.getTradNum());

				Payment newpay = new Payment();

				newpay.setBeginTime(newtrad.getTradTime());
				newpay.setEndTime(newtrad.getTradTime());
				newpay.setFlag(0);
				newpay.setPayAccount(newtrad.getTradAccount());
				newpay.setPayCus(newtrad.getTradCus());
				newpay.setPayNum(newtrad.getTradNum());
				newpay.setResult("0");

				mysession.insert("com.dao.PaymentMapper.insert", newpay);
			}

			mysession.commit();

		} finally {
			mysession.close();
		}
	}

}