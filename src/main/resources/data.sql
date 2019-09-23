INSERT INTO hospital (id, hospital_name) VALUES (1, 'Government Hospital')
ON DUPLICATE KEY UPDATE  hospital_name = 'Government Hospital';