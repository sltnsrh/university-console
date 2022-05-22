## University console app :man_student:
This is a simple console app that imitates some chatbot for university. 
It supports 5 types of requests.
These requests allow you to give some info about university departments, and their employees 
and do a search by employees.

_____________________
:pushpin: **3-tier architecture:**<br />

* Controller - Presentation layer;<br />
* Service - Application layer;<br />
* Repository - Data access layer.

:pushpin: **Technologies:**

* Java 17
* Spring Boot
* Maven
* Lombok
* H2 Database
* Spring Data JPA

:pushpin:**Available commands:**
1. Who is head of department {department_name}
2. Show {department_name} statistics
3. Show the average salary for the department {department_name}
4. Show count of employee for {department_name}
5. Global search by {template}  

_Following commands are case- and whitespace-insensitive._

**You can use the available department names from the DB for the above commands:**
1. Economics
2. Philosophy
3. Mathematics
4. Ecological
5. Historical

**The following names will also be available in the database for global search:**
1. John Richard
2. Roy Chan
3. Bob Alison
4. Claudia Jackson
5. Tonny Clinton
6. Juli Boson

:pushpin: **To start to use:**<br />
Run main class or run command `mvn package` from IDE for generating .jar file to
 run in your console. 