CREATE database HibernateDB;

CREATE TABLE student (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE post (
	id INT NOT NULL AUTO_INCREMENT,
	post_content VARCHAR(255) NOT NULL,
	student_id INT NOT NULL,
	PRIMARY KEY(postId),
    FOREIGN KEY (student_id) REFERENCES student(id)
);
