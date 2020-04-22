INSERT INTO users(id, email, password, name) values
(1,'johncaboclo@hotmail.com', 'admin', 'Admin'),
(2,'johncaboclo@gmail.com', 'john', 'john'),
(3,'johncaboclo1@gmail.com', 'john1', 'john'')

insert into posts(id, title, content, created_on, updated_on) values
(1,'Introducing SpringBoot', 'SpringBoot is awesome', '2020-04-17', null),
(2,'Securing Web Applications', 'This post will show how to use SpringSecuriry', '2020-04-17', null),
(3,'Introducing Spring Social', 'Developing Web Social Applications using Spring Social', '2020-04-17', null)

insert into comments(id, post_is, name, email, content, created_on, updated_on) values
(1,1, 'john','johncaboclo1@gmail','this is cool', '2020-04-17',null),
(2,1, 'joseph', 'john@gmail','Thanks for awesome tips', '2020-04-17',null),
(3,2, 'Giorge','giorge@gmail','Nice Post buddy', '2020-04-17',null)



