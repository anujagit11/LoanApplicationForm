package com.finalpro.appform.repo;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.finalpro.appform.model.CarLoanApplication;

@Repository
public interface AppFormRepository extends CrudRepository<CarLoanApplication, Integer>
{

	

}
