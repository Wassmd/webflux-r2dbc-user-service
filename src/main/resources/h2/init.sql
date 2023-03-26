create table users (
    id bigint auto_increment,
    name varchar(50),
    balance double precision,
    primary key (id)
);

create table user_transaction (
    id bigint auto_increment,
    user_id bigint,
    amount double precision,
    transaction_date timestamp,
    foreign key (user_id) references users(id)

);

-- update  users set balance = balance - 500 where id = 1 and balance >= 200