package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.validators.abstracts.EmployerValidatorService;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService{
	
	EmployerValidatorService employerValidatorService;
	
	@Autowired
	public EmployerManager(UserDao<Employer> userDao, EmployerValidatorService employerValidatorService) 
	{
		super(userDao);
		this.employerValidatorService = employerValidatorService;
	}
	
	public Result add(Employer employer) 
	{
		Result result = BusinessRules.run(
				employerValidatorService.isEmployerNull(employer),
				employerValidatorService.emailCheck(employer));
		
		if (!result.isSuccess()) 
		{
			return result;
		}
		return super.add(employer);
	}

}
