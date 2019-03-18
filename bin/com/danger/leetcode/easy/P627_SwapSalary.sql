--Given a table salary, such as the one below, 
--that has m=male and f=female values. 
--Swap all f and m values (i.e., change all f values to m and vice versa) 
--with a single update query and no intermediate temp table.
update salary s set s.sex=if(s.sex='m','f','m');
-- or UPDATE salary SET sex = CASE WHEN sex = 'm' THEN 'f' ELSE 'm' END