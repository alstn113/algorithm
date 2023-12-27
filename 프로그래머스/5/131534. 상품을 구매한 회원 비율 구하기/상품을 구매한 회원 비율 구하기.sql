SELECT
    YEAR(OS.SALES_DATE) AS YEAR,
    MONTH(OS.SALES_DATE) AS MONTH,
    COUNT(DISTINCT UI.USER_ID) AS PUCHASED_USERS,
    ROUND(COUNT(DISTINCT UI.USER_ID) / (
        SELECT COUNT(*)
        FROM USER_INFO
        WHERE JOINED LIKE "2021-%"
    ),1) AS PUCHASED_RATIO
FROM USER_INFO AS UI
JOIN ONLINE_SALE AS OS
ON UI.USER_ID = OS.USER_ID
WHERE UI.JOINED LIKE "2021-%"
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH
