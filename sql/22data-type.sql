-- mariaDB INT - java int
--         DEC -      double
--     VARCHAR -      String
--        DATE -      Timestamp(LocalDate)
--    DATETIME -      Timestamp(LocalDateTime)


use mydb1;
CREATE TABLE my_table12 (
    int_col INT,
    dec_col DEC(10,2),
    str_col VARCHAR(10),
    date_col DATE,
    date_time_col DATETIME
);

SELECT * FROM my_table12;