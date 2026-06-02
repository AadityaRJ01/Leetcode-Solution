# Write your MySQL query statement below
SELECT E1.unique_id,E2.name
FROM Employees E2
LEFT JOIN EmployeeUNI E1
ON E1.id=E2.id;