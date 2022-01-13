package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JpaMain {
	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try{

			Member member1 = new Member();
			member1.setUsername("관리자1");
			em.persist(member1);

			Member member2 = new Member();
			member2.setUsername("관리자2");
			em.persist(member2);

			em.flush();
			em.clear();

			String query = "select locate('de', 'abcdegf') From Member m";

			List<Integer> resultList = em.createQuery(query, Integer.class).getResultList();

			for (Integer s : resultList) {
				System.out.println("s = " + s);
			}

			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

}
