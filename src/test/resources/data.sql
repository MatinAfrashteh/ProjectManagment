-- INSERT EMPLOYEES			
insert into employee (id, fname, lname, email) values (nextval('employee_seq'), 'John', 'Warton', 'warton@gmail.com');
insert into employee (id, fname, lname, email) values (nextval('employee_seq'), 'Mike', 'Lanister', 'lanister@gmail.com');
insert into employee (id, fname, lname, email) values (nextval('employee_seq'), 'Steve', 'Reeves', 'Reeves@gmail.com');
insert into employee (id, fname, lname, email) values (nextval('employee_seq'), 'Ronald', 'Connor', 'connor@gmail.com');
insert into employee (id, fname, lname, email) values (nextval('employee_seq'), 'Jim', 'Salvator', 'Sal@gmail.com');
insert into employee (id, fname, lname, email) values (nextval('employee_seq'), 'Peter', 'Henley', 'henley@gmail.com');
insert into employee (id, fname, lname, email) values (nextval('employee_seq'), 'Richard', 'Carson', 'carson@gmail.com');
insert into employee (id, fname, lname, email) values (nextval('employee_seq'), 'Honor', 'Miles', 'miles@gmail.com');
insert into employee (id, fname, lname, email) values (nextval('employee_seq'), 'Tony', 'Roggers', 'roggers@gmail.com');

-- INSERT PROJECTS			
insert into project (projectid, name, stage, description) values (nextval('project_seq'), 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');
insert into project (projectid, name, stage, description) values (nextval('project_seq'), 'New Employee Budget',  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted');
insert into project (projectid, name, stage, description) values (nextval('project_seq'), 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
insert into project (projectid, name, stage, description) values (nextval('project_seq'), 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into employee_project (employee_id, project_id) (select e.id, p.projectid from employee e, project p where e.lname ='Warton' AND p.name = 'Large Production Deploy');
insert into employee_project (employee_id, project_id) (select e.id, p.projectid  from employee e, project p where e.lname ='Warton' AND p.name = 'New Employee Budget');
insert into employee_project (employee_id, project_id) (select e.id, p.projectid  from employee e, project p where e.lname ='Warton' AND p.name = 'Office Reconstruction');
insert into employee_project (employee_id, project_id) (select e.id, p.projectid  from employee e, project p where e.lname ='Reeves' AND p.name = 'Large Production Deploy');
insert into employee_project (employee_id, project_id) (select e.id, p.projectid  from employee e, project p where e.lname ='Warton' AND p.name = 'New Employee Budget');
insert into employee_project (employee_id, project_id) (select e.id, p.projectid  from employee e, project p where e.lname ='Warton' AND p.name = 'Improve Intranet Security');
insert into employee_project (employee_id, project_id) (select e.id, p.projectid  from employee e, project p where e.lname ='Henley' AND p.name = 'Office Reconstruction');
insert into employee_project (employee_id, project_id) (select e.id, p.projectid  from employee e, project p where e.lname ='Henley' AND p.name = 'Improve Intranet Security');