import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mtc.app.entity.User;
import com.mtc.app.util.HIbernateUtil;

public class test {

	public static void main(String[] args) {
		
	SessionFactory sessionFactory = HIbernateUtil.getSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	User user = session.get(User.class,"john@gmail.com");
	
	System.out.println("name" + user.getFirstName());
	
	session.close();
	
	sessionFactory.close();
	
	
	}

}
