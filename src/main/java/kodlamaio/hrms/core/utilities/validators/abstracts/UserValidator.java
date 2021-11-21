package kodlamaio.hrms.core.utilities.validators.abstracts;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.abstracts.User;


@Component
public abstract class UserValidator {
	
	public Result isUserNull(User user) 
	{
		String email = user.getEmail();
		String password = user.getPassword();
		
		if (email == null || email.isBlank() || password == null || password.isBlank()) 
		{
			return new ErrorResult();
		}
		
		return new SuccessResult();
	}

}
