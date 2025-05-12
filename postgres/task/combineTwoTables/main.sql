-- https://leetcode.com/problems/combine-two-tables/description/

select p.firstname,
       p.lastname,
       a.city,
       a.state

from person as p
         left join address as a on p.personid = a.personid
