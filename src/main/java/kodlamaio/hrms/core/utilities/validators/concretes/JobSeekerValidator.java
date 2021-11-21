package kodlamaio.hrms.core.utilities.validators.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.constants.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validators.abstracts.JobSeekerValidatorService;
import kodlamaio.hrms.core.utilities.validators.abstracts.UserValidator;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Component
public class JobSeekerValidator extends UserValidator implements JobSeekerValidatorService{

	@Override
	public Result isJobSeekerNull(JobSeeker jobSeeker) 
	{
		String firstName = jobSeeker.getFirstName();
		String lastName = jobSeeker.getLastName();
		String nationalityId = jobSeeker.getNationalityId();
		String birthYear = jobSeeker.getBirthYear();
		
		if (	firstName == null || 
				firstName.isBlank() ||
				lastName == null ||
				lastName.isBlank() ||
				nationalityId == null ||
				nationalityId.isBlank() ||
				birthYear == null ||
				birthYear.isBlank()
			) 
			
		{
			return new ErrorResult(Messages.notNull);
		}
		
		
		return super.isUserNull(jobSeeker);
	}

	@Override
	public Result nationalIdIsValid(String nationalityId) 
	{
		if (nationalityId.length() == 11) 
		{
			return new SuccessResult();
		}
		
		return new ErrorResult(Messages.nationalIdNotValid);
	}

}
