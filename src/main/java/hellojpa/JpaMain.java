package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

public class JpaMain {
	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try{

			Member member = new Member();
			member.setUsername("hello");
			member.setHomeAddress(new Address("city", "street", "1000"));
			member.setWorkPeriod(new Period());

			em.persist(member);

			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void printMember(Member member){
		System.out.println("member = " + member);
	}

	private static void printMemberAndTeam(Member member) {
		String username = member.getUsername();
		System.out.println("username = " + username);

		Team team = member.getTeam();
		System.out.println("team = " + team.getName());
	}
}
