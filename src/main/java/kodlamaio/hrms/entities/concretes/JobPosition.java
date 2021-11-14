package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="job_positions")
public class JobPosition{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	@Column(name="job_position_name")
	private String jobPositionName;
	
	public JobPosition() 
	{
		
	}

	public JobPosition(int id, int jobSeekerId, String jobPositionName) {
		super();
		this.id = id;
		this.jobSeekerId = jobSeekerId;
		this.jobPositionName = jobPositionName;
	}
}