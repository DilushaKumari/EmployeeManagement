
##Employee Management System 
[MIT LICENSE](LICENSE)


###Steps  
1.  Clone the application
    [https://github.com/DilushaKumari/EmployeeManagement.git]()

2.  Change mysql username and password in application.properties file.
   *       src/resources/application.properties
   *        spring.datasource.username=root
            spring.datasource.password=1234
    
3.Run the Project using maven

4.Check the Rest APIs Using follows.
*      GET   http://localhost:8080/api/v1/employees
       GET   http://localhost:8080/api/v1/employees/{id}
       POST  http://localhost:8080/api/v1/employees
       PUT   http://localhost:8080/api/v1/employees/{id}
       DELETE http://localhost:8080/api/v1/employees/{id}
       
       You can use followings for  departments  and dependents.
       
       http://localhost:8080/api/v1/dependents
       http://localhost:8080/api/v1/departments



 
 
    


