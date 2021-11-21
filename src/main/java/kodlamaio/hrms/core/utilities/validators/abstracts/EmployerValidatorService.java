package kodlamaio.hrms.core.utilities.validators.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;


public interface EmployerValidatorService{
	public Result isEmployerNull(Employer employer);
	public Result emailCheck(Employer employer);
}
