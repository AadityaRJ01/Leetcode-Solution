# Write your MySQL query statement below
-- SELECT name AS Customers
-- FROM Customers
-- WHERE id NOT IN (
--     SELECT customerId
--     FROM Orders
-- );

SELECT C.name AS Customers
FROM Customers C
LEFT JOIN Orders O
ON C.id=O.customerID
WHERE O.customerId IS NULL;