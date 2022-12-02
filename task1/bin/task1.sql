create database employee1;
use employee1;
create table employeedata(employeeId varchar(36) primary key,firstName varchar(20) not null,MiddleName varchar(20) not null,lastName varchar(20) not null,fullname varchar(60),emailId varchar(30) not null,education varchar(20) not null,mobileNumber varchar(12) not null,dateOfBirth varchar(12) not null,gender varchar(10) not null,address1 varchar(60) not null,address2 varchar(60) not null,pincode varchar(6) not null,City varchar(20) not null,State varchar(20) not null,jobDesignation varchar(20) not null,jobRole varchar(25) not null,joiningDate varchar(30) default '01/03/2022 10:00:00 AM' ,Salary varchar(10) not null,PerAnnum varchar(12) not null);
describe employeedata;
insert into employeedata(employeeId,firstName,MiddleName,lastName,fullName,emailId,education,mobileNumber,dateofbirth,gender,address1,address2,pincode,City,State,jobDesignation,jobRole,Salary,PerAnnum) values(UUID(),'Vinoth','Kumar','PG',concat(firstName,MiddleName,lastname),'vinoth@gmail.com','B.E','9598978574',Date_format(19920310,'%d.%m.%Y'),'Male','3/50 good street usilai ','usilai(PO) Usilampatti(Tk) Madurai (DT)','629545','Madurai','Tamilnadu','UI developer','React','30000',concat(salary*12/100000, if(salary*12>100000,'LPA','KPA')));
create table employeedata(employeeId varchar(36) primary key,firstName varchar(20) not null,MiddleName varchar(20) not null,lastName varchar(20) not null,fullname varchar(60),emailId varchar(30) not null,education varchar(20) not null,mobileNumber varchar(12) not null,dateOfBirth varchar(12) not null,gender varchar(10) not null,address1 varchar(60) not null,address2 varchar(60) not null,pincode varchar(6) not null,City varchar(20) not null,State varchar(20) not null,jobDesignation varchar(20) not null,jobRole varchar(25) not null,joiningDate varchar(30) default '01/03/2022 10:00:00 AM' ,Salary varchar(10) not null,PerAnnum varchar(12) not null);
select * from employee1.employeedata;
truncate table employeedata;


