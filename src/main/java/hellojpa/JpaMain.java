package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try{
			// 영속
			Member member = em.find(Member.class, 150L);
			member.setName("ZZZZ");

			//em.persist(member);

			if (member.getName().equals("ZZZZ")) {
				em.persist(member);
			}

			System.out.println("=========================");

			tx.commit();
		} catch(Exception e){
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
