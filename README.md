# anzTest
## ANZ-TechCD-JavaEE-Developer-Question-C

### Documentation

    This projec bulid restFul with springMVC+spring+mybatis on maven.
    I denfinition the return type for this api
    example:{"code":200,"message":null,"data":[{"id":"1".....},{"id":"2"....}]}
    {"code":500,"message":"name must be not null ","data":null}
    This return type throws the exception to user.
    
 ###requirements

 1.Retrieve all the departments
    http://ip:port/ANTTEST/v1/department   method="get"
 2.Retrieve one department by departmentId
    http://ip:port/ANTTEST/v1/department?id=1   method="get"
 3.Retrieve the sub-departments of this department
    http://ip:port/ANTTEST/v1/department?parentDepartment=1   method="get"
 4.Retrieve all the employees that belong to this department
    http://ip:port/ANTTEST/v1/department?id=1   method="get" 
 5.Update this department
    http://ip:port/ANTTEST/v1/department/{id}   method="put"
 6.Remove this department
    http://ip:port/ANTTEST/v1/department/{id}   method="del"
 7.Retrieve all the employees
    http://ip:port/ANTTEST/v1/employee   method="get"
 8.Retrieve one employee by employeeId
  http://ip:port/ANTTEST/v1/employee?id=1   method="get"
 9.Retrieve the department of this employee
   http://ip:port/ANTTEST/v1/department?manager=1   method="get"
 10.Update this employee
 http://ip:port/ANTTEST/v1/employee/{id}   method="put"
 11.Remove this employee
  http://ip:port/ANTTEST/v1/employee/{id}   method="del"
 12.Create a new department as a sub-department of a given department
  http://ip:port/ANTTEST/v1/department?parentDepartment=1....   method="post"
 13.Create a new employee in a given department
   http://ip:port/ANTTEST/v1/employee?idapUserName=1....   method="post"
