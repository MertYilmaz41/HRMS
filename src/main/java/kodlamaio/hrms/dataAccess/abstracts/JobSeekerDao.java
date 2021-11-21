package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends UserDao<JobSeeker>{
	
	Optional<JobSeeker> findByNationalIdentity(String nationalityId);
}
