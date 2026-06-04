SELECT
    Score,
    (
        SELECT COUNT(DISTINCT Score)
        FROM Scores
        WHERE Score >= s.Score
    ) AS `rank`
FROM Scores s
ORDER BY Score DESC;