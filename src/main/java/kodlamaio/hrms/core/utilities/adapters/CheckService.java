package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.core.utilities.results.Result;

public interface CheckService{
	Result check(String nationalityId, String firstName, String lastName, String birthYear);
}
