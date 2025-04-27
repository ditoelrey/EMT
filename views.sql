
CREATE MATERIALIZED VIEW accommodations_by_host AS
SELECT host_id, COUNT(*) as accommodation_count
FROM accommodation
GROUP BY host_id;

CREATE MATERIALIZED VIEW hosts_by_country AS
SELECT
    c.name AS country_name,
    COUNT(h.id) AS host_count
FROM
    host h
        JOIN
    country c ON h.country_id = c.id
GROUP BY
    c.name;