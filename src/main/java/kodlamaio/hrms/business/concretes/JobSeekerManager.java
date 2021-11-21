package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.adapters.CheckService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.constants.Messages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validators.abstracts.JobSeekerValidatorService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager extends UserManager<JobSeeker> implements JobSeekerService{

	private final JobSeekerDao jobSeekerDao;
	private final JobSeekerValidatorService jobSeekerValidatorService;
	private final CheckService checkService;
	
	@Autowired
	public JobSeekerManager(UserDao<JobSeeker> userDao, JobSeekerValidatorService jobSeekerValidatorService,CheckService checkService) {
		super(userDao);
		jobSeekerDao = (JobSeekerDao) userDao;
		this.jobSeekerValidatorService = jobSeekerValidatorService;
		this.checkService = checkService;
		
	}

	public Result add(JobSeeker jobSeeker) 
	{
		Result result = BusinessRules.run(
				jobSeekerValidatorService.isJobSeekerNull(jobSeeker),
				jobSeekerValidatorService.nationalIdIsValid(jobSeeker.getNationalityId()),
				checkService.check(jobSeeker.getNationalityId(),jobSeeker.getFirstName(),jobSeeker.getLastName(),jobSeeker.getBirthYear()),
				isNationalityIdExist(jobSeeker.getNationalityId())
				);
				
		if (!result.isSuccess()) 
		{
			return result;
		}
		
		return super.add(jobSeeker);
	}

	private Result isNationalityIdExist(String nationalityId) 
	{
		if (jobSeekerDao.findByNationalIdentity(nationalityId).isPresent()) 
		{
			return new ErrorResult(Messages.nationalIdentityExist);
		}
		return new SuccessResult();
	}
	
}
