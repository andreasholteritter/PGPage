create sequence hibernate_sequence start with 1 increment by 1;


create table category (id bigint generated by default as identity, name varchar(128) not null, primary key (id));
create table match_stats (id bigint generated by default as identity, defeats integer not null check (defeats>=0), victories integer not null check (victories>=0), user_username varchar(255) not null, primary key (id));
create table quiz (id bigint generated by default as identity, first_answer varchar(128) not null, fourth_answer varchar(128) not null, index_of_correct_answer integer not null check (index_of_correct_answer>=0 AND index_of_correct_answer<=3), question varchar(128) not null, second_answer varchar(128) not null, third_answer varchar(128) not null, sub_category_id bigint not null, primary key (id));
create table sub_category (id bigint generated by default as identity, name varchar(128) not null, parent_id bigint not null, primary key (id));
create table user_roles (user_username varchar(255) not null, roles varchar(255));
create table users (username varchar(255) not null, enabled boolean not null, password varchar(255) not null, primary key (username));
alter table category add constraint UK_46ccwnsi9409t36lurvtyljak unique (name);
alter table quiz add constraint UK_rnmswl6u0o5dwjq14nm5248je unique (question);
alter table match_stats add constraint FK4t4a8c1ploau9vfknu3t6tl7d foreign key (user_username) references users;
alter table quiz add constraint FKwqtq0m711iiym2m781dqr6n4 foreign key (sub_category_id) references sub_category;
alter table sub_category add constraint FKlqrv1aj0pon999jbi5esfpe4k foreign key (parent_id) references category;
alter table user_roles add constraint FKs9rxtuttxq2ln7mtp37s4clce foreign key (user_username) references users;