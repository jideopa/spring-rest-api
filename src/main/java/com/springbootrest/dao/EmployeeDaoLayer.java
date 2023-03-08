package com.springbootrest.dao;

import com.springbootrest.model.EmployeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDaoLayer extends JpaRepository<EmployeRecord,Integer> {

/*
    List<EmployeRecord> findByEmployeeCountry(String employeeCountry);

    List<EmployeRecord> findByEmployeeName(String employeeName);
    List<EmployeRecord> findByIdGreaterThan(int i);


    @Query("from EmployeRecord WHERE employeeCountry=?1 order by employeeName")
    List<EmployeRecord>findByCountrySorted(String employeeCountry);
*/

}
