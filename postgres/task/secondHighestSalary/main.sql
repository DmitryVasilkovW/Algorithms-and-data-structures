-- https://leetcode.com/problems/second-highest-salary/description/

select (select distinct salary as SecondHighestSalary
        from employee
        order by salary desc
        limit 1 offset 1)