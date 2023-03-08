package com.springbootrest.controller;

import com.springbootrest.dao.EmployeeDaoLayer;
import com.springbootrest.model.EmployeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeController {


    @Autowired
    EmployeeDaoLayer employeeDaoLayer;


    @PostMapping(path = "/addEmployee", consumes = "application/json")
    public EmployeRecord addEmployee(@RequestBody EmployeRecord employeRecord){
        /*EmployeRecord employeRecord = new EmployeRecord();
        employeRecord.setId(id);
        employeRecord.setEmployeeCountry(employeeCountry);
        employeRecord.setEmployeeName(employeeName);*/
        System.out.println(employeRecord);
        employeeDaoLayer.save(employeRecord);

        return employeRecord;
    }


   /* @RequestMapping("getID")
    public ModelAndView getEmployeeID(@RequestParam int id){
      EmployeRecord employeRecord =employeeDaoLayer.findById(id).orElse(new EmployeRecord());
        System.out.println(employeeDaoLayer.findById(id).orElse(new EmployeRecord()));
        System.out.println(employeeDaoLayer.findByEmployeeCountry("canada"));
        System.out.println(employeeDaoLayer.findByIdGreaterThan(4));
        System.out.println(employeeDaoLayer.findByCountrySorted("canada"));
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("ShowID.jsp");
        modelAndView.addObject(employeRecord);

        return modelAndView;
    }
*/
    @GetMapping("/employee")
    @ResponseBody
    public List<EmployeRecord> getAllEmployee(){



        return employeeDaoLayer.findAll();
    }

    // we can specific the content type
    @RequestMapping(path = "/employee/5" )
    @ResponseBody
    public String getEmployee5(){



        return employeeDaoLayer.findById(5).toString();
    }


    //create a wild card method
    @RequestMapping(path = "/employee/{id}")
    @ResponseBody
    public Optional<EmployeRecord> getEmployee(@PathVariable int id){



        return employeeDaoLayer.findById(id);
    }


    @DeleteMapping("/employee/{id}")
    public String deleteRecord(@PathVariable int id){

        EmployeRecord record = employeeDaoLayer.getReferenceById(id);

        employeeDaoLayer.delete(record);


        return "Delete deleted " + id + record;

    }

    @PutMapping(path = "/employee", consumes = "application/json")
    public EmployeRecord updateOrAddEmployee(@RequestBody EmployeRecord employeRecord){
        System.out.println(employeRecord);
        employeeDaoLayer.save(employeRecord);

        return employeRecord;
    }




}
