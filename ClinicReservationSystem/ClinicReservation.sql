DROP DATABASE IF EXISTS clinic_reservation_db;

CREATE DATABASE clinic_reservation_db;
USE clinic_reservation_db;

CREATE TABLE STUDENT (
	student_id INT AUTO_INCREMENT PRIMARY KEY,
	first_Name VARCHAR(50) NOT NULL,
	last_Name VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	contact_number VARCHAR(15) NOT NULL UNIQUE,
	age TINYINT UNSIGNED NOT NULL,
	program VARCHAR(50) NOT NULL,
	year_level TINYINT UNSIGNED NOT NULL,
    
    CONSTRAINT u_name UNIQUE (first_name, last_name)
);

CREATE TABLE FACILITATOR(
	facilitator_id INT AUTO_INCREMENT PRIMARY KEY,
	first_Name VARCHAR(50) NOT NULL,
	last_Name VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	contact_number VARCHAR(15) NOT NULL UNIQUE,
	department VARCHAR(50) NOT NULL,
    
    CONSTRAINT u_name UNIQUE (first_name, last_name)
);

CREATE TABLE NURSE(
	nurse_id INT AUTO_INCREMENT PRIMARY KEY,
	first_Name VARCHAR(50) NOT NULL,
	last_Name VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	contact_number VARCHAR(15) NOT NULL UNIQUE,
    
    CONSTRAINT u_name UNIQUE (first_name, last_name)
);

CREATE TABLE SUBJECT(
	subject_id VARCHAR(15) PRIMARY KEY,
	subject_description VARCHAR(100) NOT NULL
);

CREATE TABLE CLASS(
	class_id VARCHAR(10) PRIMARY KEY,
	facilitator_id INT,
	subject_id VARCHAR(15),
    
    CONSTRAINT fl_facilitator_id FOREIGN KEY (facilitator_id) REFERENCES FACILITATOR(facilitator_id),
    CONSTRAINT fl_subject_id FOREIGN KEY (subject_id) REFERENCES SUBJECT(subject_id)
);

CREATE TABLE ENROLLMENT(
	enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
	student_id INT,
	class_id VARCHAR(10),
    
    CONSTRAINT fl_student_id FOREIGN KEY (student_id) REFERENCES STUDENT(student_id),
    CONSTRAINT fl_class_id FOREIGN KEY (class_id) REFERENCES CLASS(class_id)
);

CREATE TABLE ACTIVITY(
	activity_id INT AUTO_INCREMENT PRIMARY KEY,
	activity_name VARCHAR(50) NOT NULL,
	activity_location VARCHAR(100) NOT NULL,
	start_date DATE NOT NULL,
	start_time TIME NOT NULL,
	end_date DATE NOT NULL,
	end_time TIME NOT NULL
);

CREATE TABLE CLEARANCE(
	clearance_id INT AUTO_INCREMENT PRIMARY KEY,
	enrollment_id INT,
	activity_id INT,
	nurse_id INT DEFAULT -1,
	physician_first_name VARCHAR(50),
    physician_last_name VARCHAR(50),
	evaluated_date DATE,
	evaluated_time TIME,
	status VARCHAR(8) DEFAULT 'PENDING',
	rejection_reason VARCHAR(100),
    
	CONSTRAINT fl_enrollment_id FOREIGN KEY (enrollment_id) REFERENCES ENROLLMENT(enrollment_id),
    CONSTRAINT fl_activity_id FOREIGN KEY (activity_id) REFERENCES ACTIVITY(activity_id),
    CONSTRAINT fl_nurse_id FOREIGN KEY (nurse_id) REFERENCES NURSE(nurse_id),
    CONSTRAINT c_status CHECK (status IN ('APPROVED', 'REJECTED', 'PENDING'))
);

INSERT INTO STUDENT
	(first_name, last_name, email, contact_number, age, program, year_level)
VALUES
    ('Maiero', 'Achademi', 'machademi@addu.edu.ph', '0938 676 7676', 18, 'Education', 1),
    ('Miste', 'Terbist', 'mterbist@addu.edu.ph', '0932 222 2222', 35, 'Finances', 1),
    ('Charley', 'Kurth', 'ckurth@addu.edu.ph', '0933 287 6542', 31, 'Political Science', 3),
    ('Hasu', 'N\'meeku', 'hnmeeku@addu.edu.ph', '0934 221 2222', 18, 'Fine Arts', 1),
    ('Joo-Jisu', 'Kaison', 'jkaison@addu.edu.ph', '0933 829 3392', 20, 'History', 4),
    ('Mohnki', 'de Lufee', 'mdelufee@addu.edu.ph', '0933 283 9238', 20, 'Civil Engineering', 2),
    ('Aeta', 'Duriyuji', 'aduriyuji@addu.edu.ph', '0938 293 8239', 18, 'Nursing', 1),
    ('Song', 'Ohku', 'sohku@addu.edu.ph', '0935 283 9248', 19, 'Nursing', 1),
    ('Veree', 'Te', 'vtee@addu.edu.ph', '0987 423 2323', '20', 'History', 1),
    ('Matthew', 'Patthew', 'mpatthew@addu.edu.ph', '0967 675 4367', 35, 'Mathematics', 1);

INSERT INTO FACILITATOR
	(first_name, last_name, email, contact_number, department)
VALUES
    ('Toh', 'Masite', 'jibarra@addu.edu.ph', '0938 101 1337', 'NSTP'),
    ('Sohk', 'Gratis', 'mclara@addu.edu.ph', '0935 123 4567', 'Social Sciences'),
    ('Aries', 'Thoth\'ll', 'athothll@addu.edu.ph', '0936 232 2312', 'Philosophy'),
    ('Konfu', 'Shius', 'kshius@addu.edu.ph', '0937 293 2392', 'Nursing'),
    ('Mikaela', 'Jello', 'mjello@addu.edu.ph', '0932 293 2389', 'FYSF');

INSERT INTO NURSE
	(first_name, last_name, email, contact_number)
VALUES
    ('Hepokra', 'Tikoth', 'htikoth@addu.edu.ph', '0932 991 2212'),
    ('Lobo', 'Temmi', 'ltenmi@addu.edu.ph', '0932 238 2392'),
    ('Medi', 'Kalmapraktis', 'mkalmapraktis@addu.edu.ph', '0933 823 2378'),
    ('Gregory', 'House', 'ghouse@addu.edu.ph', '0938 483 934');

INSERT INTO SUBJECT
	(subject_id, subject_description)
VALUES
    ('NSTP 2', 'NATIONAL SERVICE TRAINING PROGRAM - CIVIC WELFARE TRAINING SERVICE 2'),
    ('GE 2110', 'READINGS IN PHILIPPINE HISTORY'),
    ('FYSF 2', 'FIRST YEAR SOCIAL FORMATION 2'),
    ('N 1001', 'FUNDAMENTALS OF NURSING'),
    ('GE 1103', 'INTRODUCTION TO PHILOSOPHICAL METHOD');

INSERT INTO CLASS
	(class_id, facilitator_id, subject_id)
VALUES
    ('18-049', 1, 'NSTP 2'),
    ('16-057', 2, 'GE 2110'),
    ('17-110', 5, 'FYSF 2'),
    ('5-123', 4, 'N 1001'),
    ('15-117', 3, 'GE 1103');

INSERT INTO ENROLLMENT
	(enrollment_id, student_id, class_id)
VALUES
    (1, 1, '18-049'),
    (2, 2, '18-049'),
    (3, 3, '16-057'),
    (4, 4, '16-057'),
    (5, 5, '15-117'),
    (6, 6, '15-117'),
    (7, 7, '17-110'),
    (8, 8, '17-110'),
    (9, 9, '18-049'),
    (10, 10, '18-049');
    
INSERT INTO ACTIVITY
	(activity_name, activity_location, start_date, start_time, end_date, end_time)
VALUES
    ('Community Service', 'Barangay Mudiang', '2026-10-24', '09:00:00', '2026-10-24', '11:30:00'),
    ('Museum Visitation', 'Museo Dabawenyo', '2026-10-28', '09:00:00', '2026-10-28', '13:00:00'),
    ('Retreat', 'St. Ignatius Spirituality Center', '2026-10-24', '08:00:00', '2026-10-25', '15:00:00'),
    ('Hospital Visitation', 'San Pedro Hospital', '2026-10-25', '10:00:00', '2026-10-25', '18:00:00'),
    ('Philosophy Seminar', 'Abreeza', '2026-10-25', '10:00:00', '2026-10-25', '12:00:00');

INSERT INTO CLEARANCE
	(enrollment_id, activity_id, nurse_id, physician_first_name, physician_last_name, evaluated_date, evaluated_time, status, rejection_reason)
VALUES
    (1, 1, 1, 'King', 'Jongung', '2026-10-22', '14:22:22', 'APPROVED', null),
    (2, 1, 1, 'Hosei-ri', 'Zhal', '2026-10-23', '13:24:35', 'REJECTED', 'Forged clearance'),
    (3, 5, 3, 'Sarge', 'Urie', '2026-10-23', '15:32:11', 'REJECTED', 'Check-up from a year ago'),
    (4, 2, 4, 'Mao', 'Mow', '2026-10-22', '09:26:17', 'APPROVED', null),
    (5, 2, 3, 'Donna', 'Eldthramp', '2026-10-23', '16:23:44', 'REJECTED', 'Unregistered physician'),
    (6, 3, 4, 'Perhz', 'Suwir', '2026-10-22', '10:11:12', 'APPROVED', null),
    (7, 4, null, null, null, null, null, 'PENDING', null),
    (8, 4, 4, 'Juan', 'Piz', '2026-10-24', '12:12:12', 'APPROVED', null),
    (9, 1, 4, 'Whir', 'Gonady', '2026-10-22', '15:40:23', 'REJECTED', 'Student\'s twin substituted during Evaluation'),
    (10, 1, null, null, null, null, null, 'PENDING', null);

SHOW TABLES;
SELECT * FROM STUDENT;
SELECT * FROM FACILITATOR;
SELECT * FROM NURSE;
SELECT * FROM SUBJECT;
SELECT * FROM CLASS;
SELECT * FROM ENROLLMENT;
SELECT * FROM ACTIVITY;
SELECT * FROM CLEARANCE;

