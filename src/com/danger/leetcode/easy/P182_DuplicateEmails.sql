--编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
--
--示例：
--
--+----+---------+
--| Id | Email   |
--+----+---------+
--| 1  | a@b.com |
--| 2  | c@d.com |
--| 3  | a@b.com |
--+----+---------+
--根据以上输入，你的查询应返回以下结果：
--
--+---------+
--| Email   |
--+---------+
--| a@b.com |
--+---------+
--说明：所有电子邮箱都是小写字母。

-- 方案1
select t.Email from (select Email,count(Email) as number from Person group by Email) t
             where t.number > 1
             
-- 方案2
select Email from Person group by Email having count(Email) > 1

-- 方案3
select distinct p1.Email from Person p1 left join Person p2 on p1.Email = p2.Email
                                        where p1.Id != p2.Id