package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;

@Primary
@Service
public class UserManager<T extends User> implements UserService<T>{

	 private final UserDao<T> userDao;
	
	@Autowired
	public UserManager(UserDao<T> userDao) 
	{
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<T>> getAll() 
	{
		return new SuccessDataResult<List<T>>
		(this.userDao.findAll(),"Data listlendi");
	}

	@Override
	public Result add(T user) 
	{
		Result result = BusinessRules.run
				(isEmailExist(user.getEmail())
				);
		
		
		if (result.isSuccess()) 
		{
			userDao.save(user);
			return new SuccessResult(Messages.userAdded);
		}
		return result;
	}
	
	
	private Result isEmailExist(String email) 
	{
		if (userDao.findByMail(email).isPresent()) 
		{
			return new ErrorResult(Messages.emailExist);
		}
		return new SuccessResult();
	}
}
