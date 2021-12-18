package hellojpa;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class Period {

	LocalDateTime startDate;
	LocalDateTime endDate;

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
}
