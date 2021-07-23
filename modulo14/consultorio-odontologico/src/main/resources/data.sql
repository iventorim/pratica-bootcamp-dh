INSERT INTO ml_app_consultorio.dentists (id_dentist, address, birth_date, code_mp, dni, email, last_name, name, phone)
VALUES (1, 'Rua dos bobos, Nº 0', '1995-07-13', '123', '123456', 'zeroela@gmail.com', 'Roela', 'Jose', '33333333');
INSERT INTO ml_app_consultorio.dentists (id_dentist, address, birth_date, code_mp, dni, email, last_name, name, phone)
VALUES (2, 'Lugar nenhum', '1995-06-08', '456', '654321', 'zemane@gmail.com', 'Mané', 'José', '999999999');
INSERT INTO ml_app_consultorio.dentists (id_dentist, address, birth_date, code_mp, dni, email, last_name, name, phone)
VALUES (3, 'Algum lugar', '1996-07-08', '222', '152125', 'joao@gmail.com', 'Mamão', 'João', null);

INSERT INTO ml_app_consultorio.diarys (id_diary, ending_time, start_time, dentist_id_dentist)
VALUES (1, '19:00:00', '07:00:00', 1);
INSERT INTO ml_app_consultorio.diarys (id_diary, ending_time, start_time, dentist_id_dentist)
VALUES (2, '19:00:00', '07:00:00', 2);
INSERT INTO ml_app_consultorio.diarys (id_diary, ending_time, start_time, dentist_id_dentist)
VALUES (3, '19:00:00', '07:00:00', 3);

INSERT INTO ml_app_consultorio.patients (id_patient, address, birth_date, dni, email, last_name, name, phone)
VALUES (1, null, null, '444512', 'nenhum@gmail.com', 'Testado', 'Teste', null);
INSERT INTO ml_app_consultorio.patients (id_patient, address, birth_date, dni, email, last_name, name, phone)
VALUES (2, null, null, '444512', 'nenhum@gmail.com', 'Mais', 'Um', null);
INSERT INTO ml_app_consultorio.patients (id_patient, address, birth_date, dni, email, last_name, name, phone)
VALUES (3, null, null, '444512', 'nenhum@gmail.com', 'Mais', 'Dois', null);

INSERT INTO ml_app_consultorio.turn_status (id_turn_status, description, name)
VALUES (1, null, 'CONCLUIDO');
INSERT INTO ml_app_consultorio.turn_status (id_turn_status, description, name)
VALUES (2, null, 'CANCELADO');
INSERT INTO ml_app_consultorio.turn_status (id_turn_status, description, name)
VALUES (3, null, 'PENDENTE');
INSERT INTO ml_app_consultorio.turn_status (id_turn_status, description, name)
VALUES (4, null, 'REPROGRAMADO');

INSERT INTO ml_app_consultorio.turns
    (id_turn, day, diary_id_diary, patient_id_patient, turn_status_id_turn_status, turno_reprogramado_id_turn)
    VALUES (1, '2021-07-22', 1, 1, 1, null);
INSERT INTO ml_app_consultorio.turns
    (id_turn, day, diary_id_diary, patient_id_patient, turn_status_id_turn_status, turno_reprogramado_id_turn)
    VALUES (2, '2021-07-22', 1, 2, 3, null);
INSERT INTO ml_app_consultorio.turns
    (id_turn, day, diary_id_diary, patient_id_patient, turn_status_id_turn_status, turno_reprogramado_id_turn)
    VALUES (3, '2021-07-22', 2, 3, 2, null);
INSERT INTO ml_app_consultorio.turns
    (id_turn, day, diary_id_diary, patient_id_patient, turn_status_id_turn_status, turno_reprogramado_id_turn)
    VALUES (8, '2021-07-23', 3, 3, 4, null);
INSERT INTO ml_app_consultorio.turns
    (id_turn, day, diary_id_diary, patient_id_patient, turn_status_id_turn_status, turno_reprogramado_id_turn)
    VALUES (9, '2021-07-23', 2, 3, 3, 8);