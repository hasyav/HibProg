import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtc.app.entity.User;
import com.mtc.app.util.HIbernateUtil;

public class TestAdd {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HIbernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		User user = new User("hasya@gmail.com","123","hasya","durga","123","123456");

		//		to perform non select DB operations we use transactions
		Transaction transaction=session.getTransaction();

		transaction.begin();

				session.save(user);

		transaction.commit();

		session.close();

		sessionFactory.close();









	}

}
