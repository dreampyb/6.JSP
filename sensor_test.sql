INSERT INTO sensor_table(cds) VALUES(?);
# 가장 마지막(최근)의 센서값을 출력하는 쿼리
select MAX(NO) FROM sensor_table;

SELECT cds FROM sensor_table WHERE NO =(select MAX(NO) FROM sensor_table);

SELECT cds FROM sensor_table WHERE NO =(select MAX(NO) FROM sensor_table;