StudentManagement

To run this project on your local system download jdk and an IDE that supports java.
Create a new project and don't forget to include mysql-connector in the "libraries" section of the project.

Also Install MySql in case you don't have it.

Run MySql on your system and execute the following query in MySql command line client:
Create database student;
create table register(
id int Primary key,
f_name char(25),
l_name char(25),
password varchar(8));

The above provided script will help you in creating the required database and table along with the required columns.

Now, just change the password in the java source code file to your MySql's one.
