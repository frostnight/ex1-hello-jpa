package hellojpa;

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

			Member member1 = new Member();
			member1.setUsername("member1");
			em.persist(member1);

			em.flush();
			em.clear();

			Member refMember = em.getReference(Member.class, member1.getId());
			System.out.println("refMember = " + refMember.getClass());
			Hibernate.initialize(refMember);

			tx.commit();
		} catch(Exception e){
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
