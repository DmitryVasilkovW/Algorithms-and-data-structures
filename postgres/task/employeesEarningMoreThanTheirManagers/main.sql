-- https://leetcode.com/problems/employees-earning-more-than-their-managers/description/

select name as Employee
from employee e1
where salary > (select salary
                from employee e2
                where e2.id = e1.managerid);

select e1.name as Employee
from Employee e1
         join Employee e2 on e1.managerId = e2.id
where e1.salary > e2.salary
  and e1.managerId is not null
