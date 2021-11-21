package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.services.jFakeMernisService;

@Component
public class jMernisAdapter implements CheckService{

	@Override
	public Result check(String nationalityId, String firstName, String lastName, String birthYear) {
		jFakeMernisService fakeMernisService = new jFakeMernisService();
		if (!fakeMernisService.checkUser(nationalityId, firstName, lastName, birthYear)) 
		{
			return new ErrorResult("Kullanıcı gerçek değil.");
		}
		
		return new SuccessResult();
		
	}



}
