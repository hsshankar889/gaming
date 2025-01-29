package gaming.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import gaming.dto.player;
public class HibernateLogic {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("gaming");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	public void addObject(player o)
	{
		transaction.begin();
		manager.persist(o);
		transaction.commit();
	}
}
