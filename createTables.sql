drop table resident;
drop table staff;
drop table admin;
drop table login;
drop table resident_att;
drop table staff_att;
drop table menu;
drop table resident_payment_details;
drop table paid;
drop table refund;
drop table complaint;
drop table messbill;

create table resident(ID varchar(15) primary key,mobile_no varchar(10) not null, email_id varchar(255) unique not null, acc_no varchar(20), room_no int, full_name varchar(30) not null);

create table staff(ID varchar(15) primary key,mobile_no varchar(10) not null, email_id varchar(255) unique not null, acc_no varchar(20), salary int, full_name varchar(30) not null);

create table admin(ID varchar(15) primary key,email_id varchar(255),full_name varchar(30) not null);

create table login(username varchar(15) primary key, password varchar(30));

create table resident_att(r_id varchar(15) ,on_date date not null default current_date, breakfast varchar(5), lunch varchar(5), snacks varchar(5), dinner varchar(5), meals_skipped int, foreign key(r_id) references resident(ID) on delete cascade, primary key(r_id, on_date) );

create table staff_att(s_id varchar(15),on_date date not null default current_date, breakfast varchar(5), lunch varchar(5), snacks varchar(5), dinner varchar(5), meals_eaten int, foreign key(s_id) references staff(ID) on delete cascade, primary key(s_id, on_date) );

create table menu(day int primary key, breakfast varchar(255), lunch varchar(255), snacks varchar(255), dinner varchar(255), costpermeal int);

create table resident_payment_details(payment_no serial primary key,r_id varchar(15),payment_date date not null, amount_paid int, foreign key(r_id) references resident(ID) on delete cascade );

create table paid(s_id varchar(15),paid_date date not null default current_date, salary_paid int, foreign key(s_id) references staff(ID) on delete cascade, primary key(s_id,paid_date) );

create table refund(refund_id serial primary key,r_id varchar(15),refund_amount int,foreign key(r_id) references resident(ID)on delete cascade );

create table complaint (user_id varchar(15) ,name varchar(40),complaint varchar(255),status varchar(20) default null);

create table messbill (id serial primary key, netSalaryPaid int, netPaymentGot int, netMessBill int);