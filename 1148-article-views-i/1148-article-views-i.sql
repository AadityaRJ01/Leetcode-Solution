# Write your MySQL query statement below
SELECT DISTINCT V.author_id as id
FROM Views V
WHERE author_id=viewer_id
ORDER BY id;