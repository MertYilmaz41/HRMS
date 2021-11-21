package kodlamaio.hrms.core.utilities.validators.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.constants.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validators.abstracts.EmployerValidatorService;
import kodlamaio.hrms.core.utilities.validators.abstracts.UserValidator;
import kodlamaio.hrms.entities.concretes.Employer;

@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService{

	@Override
	public Result isEmployerNull(Employer employer) 
	{
		String companyName = employer.getCompanyName();
		String webAddress = employer.getWebAddress();
		String phoneNumber = employer.getPhoneNumber();
		
		if (
				companyName == null ||
				companyName.isBlank() ||
				webAddress == null ||
				webAddress.isBlank() ||
				phoneNumber == null ||
				phoneNumber.isBlank()) 
		{
			return new ErrorResult(Messages.notNull);
		}

		return super.isUserNull(employer);
		
	}

	@Override
	public Result emailCheck(Employer employer) 
	{
		
		 String email = employer.getEmail();
	     String webAdress = employer.getWebAddress();
	     String domain = webAdress.split("www.")[1];
	     
	      if(domain.equals(email.split("@")[1]))
	      {
	            return new SuccessResult();
	      }
	      
	      return new ErrorResult(Messages.domainNotEqual);
	}

}
