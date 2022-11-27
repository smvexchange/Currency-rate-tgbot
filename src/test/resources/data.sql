create table incomes
(
    id      INTEGER not null,
    chat_id INTEGER not null,
    income  INTEGER not null
);

create table spend
(
    id      INTEGER not null,
    chat_id INTEGER not null,
    spend   INTEGER not null
);

create table active_chat
(
    id      INTEGER not null,
    chat_id INTEGER not null
);

INSERT INTO spend (id, chat_id, spend) VALUES (1, 12345, 4000);
INSERT INTO incomes (id, chat_id, income) VALUES (1, 12345, 3000);
INSERT INTO active_chat (id, chat_id) VALUES (1, 12345);
