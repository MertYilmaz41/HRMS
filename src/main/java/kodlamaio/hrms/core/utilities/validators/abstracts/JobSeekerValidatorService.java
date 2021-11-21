package kodlamaio.hrms.core.utilities.validators.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerValidatorService {
	public Result isJobSeekerNull(JobSeeker jobSeeker);
	public Result nationalIdIsValid(String nationalityId);
}
