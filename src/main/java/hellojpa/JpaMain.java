package hellojpa;

import java.util.List;
import java.util.Set;

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
			member.setUsername("member1");
			member.setHomeAddress(new Address("homeCity", "street", "10000"));

			member.getFavoriteFoods().add("치킨");
			member.getFavoriteFoods().add("족발");
			member.getFavoriteFoods().add("피자");

			member.getAddressesHistory().add(new AddressEntity("old1", "street", "10000"));
			member.getAddressesHistory().add(new AddressEntity("old2", "street", "10000"));

			em.persist(member);

			em.flush();
			em.clear();

			System.out.println("================= START =================");
			//Member findMember = em.find(Member.class, member.getId());

			// findMember.setHomeAddress(new Address("newCity",
			// 	findMember.getHomeAddress().getStreet(),
			// 	findMember.getHomeAddress().getZipcode())
			// );

			// 치킨 -> 한식
			// findMember.getFavoriteFoods().remove("치킨");
			// findMember.getFavoriteFoods().add("한식");

			// findMember.getAddressesHistory().remove(new Address("old1", "street", "10000"));
			// findMember.getAddressesHistory().add(new Address("newCity1", "street", "10000"));

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
