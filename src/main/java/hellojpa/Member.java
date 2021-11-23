package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
public class Member {

	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "TEAM_ID")
	private Long teamId;
}

