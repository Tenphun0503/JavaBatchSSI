# DataBase & Spring

---
## Topic: Database
Use MySQL to build employee and salary table and solve the followings:
```mysql
CREATE TABLE employee (
    EmpId INT NOT NULL,
    FullName VARCHAR(25) NOT NULL,
    ManagerId INT NOT NULL,
    DateOfJoining DATE NOT NULL
);

INSERT INTO employee (EmpId, FullName, ManagerId, DateOfJoining)
VALUES
    (121, 'Jon Snow', 321, '2014-01-31'),
    (321, 'Night King', 986, '2015-01-30'),
    (421, 'Arya Stark', 876, '2016-11-27'),
    (521, 'Sansa Stark', 876, '2017-12-02'),
    (521, 'Sansa Stark', 876, '2017-12-02');
```

```mysql
CREATE TABLE salary (
    EmpId INT NOT NULL,
    Project VARCHAR(5),
    Salary INT NOT NULL
);

INSERT INTO salary (EmpId, Project, Salary)
VALUES (121, 'P1', 8000),
       (321, 'P2', 1000),
       (421, 'P1', 12000),
       (721, 'P3', 6000);
```
1. fetch the count of employees working in project 'P1'.
   ```mysql
   SELECT COUNT(EmpId) 
   FROM mydb.salary 
   WHERE Project='P1';
   ```
2. fetch employee names having salary greater than or equal to 5000 and less than or equal 10000.
   ```mysql
   SELECT FullName 
   FROM mydb.employee 
   WHERE EMPId IN (
     SELECT EmpId 
     FROM mydb.salary 
     WHERE Salary BETWEEN 5000 AND 10000
   );
   ``` 
3. fetch project-wise count of employees sorted by project's count condescending order.
   ```mysql
   SELECT Project, COUNT(EmpId) count 
   FROM mydb.salary 
   GROUP BY Project 
   ORDER BY count DESC;
   ```
4. fetch projects that include more than 1 employee
   ```mysql
   SELECT Project 
   FROM mydb.salary 
   GROUP BY Project 
   HAVING COUNT(EmpId) > 1;
   ```
5. fetch employee names and salary, if employee does not have salary, show salary as 0.
   ```mysql
   SELECT e.FullName, COALESCE(s.Salary, 0) 
   FROM mydb.employee e 
   LEFT JOIN salary s ON e.EmpId = s.EmpId;
   ```
6. fetch all employees whose managers are also in the employee table
   ```mysql
   SELECT * 
   FROM mydb.employee 
   WHERE ManagerId IN (
     SELECT EmpId 
     FROM mydb.employee
   );
   ```
7. fetch duplicate employee name in the employee table
   ```mysql
   SELECT FullName 
   FROM mydb.employee 
   GROUP BY FullName
   HAVING COUNT(*) > 1;
   ```
8. fetch employees who do not have salary
   ```mysql
   SELECT * 
   FROM mydb.employee 
   WHERE EmpId NOT IN (
     SELECT EmpId 
     FROM mydb.salary
   );
   ```
9. fetch current date and current timestamp
   ```mysql
   SELECT CURDATE() date, CURTIME() time;
   ```
10. fetch employee who joined in year 2016
   ```mysql
   SELECT * 
   FROM mydb.employee 
   WHERE YEAR(DateOfJoining) = 2016;
   ```
11. fetch employees and their salary who joined in "January"
   ```mysql
   SELECT e.EmpId, e.FullName, e.ManagerId, e.DateOfJoining, s.salary 
   FROM mydb.employee e
   JOIN salary s on e.EmpId = s.EmpId
   WHERE DATE_FORMAT(e.DateOfJoining, '%M') = 'January'; 
   ```

---
### Topic: Spring
Write a document Service
Implement APIs so that users can `create`/`delete`/`update`/`list`/`get` document(s).  
Please follow `RESTFUL API` design for http method, url path and return code.

A document class will look like:
```java
class Document{
    Integer id;
    String content;
}
```
Additional requirements:
`Create` API should handle the already existing error, and return proper http code.
`Get`/`Delete`/`Update` API should handle the not exist error, and return proper http code.
Use Controller/Service/DAO to separate the logic. In DAO, simply use a HashMap to store the document data.
For `Create` API, the controller should only accept json http content and return proper http code if not json.
