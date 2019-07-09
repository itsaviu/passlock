create table users (
    id BIGSERIAL PRIMARY KEY,
    username TEXT NOT NULL,
    password TEXT NOT NULL,
    verified BOOLEAN default false,
    email_id TEXT NOT NULL ,
    mobile_number TEXT,
    created_at TIMESTAMP
);


ALTER TABLE users ADD CONSTRAINT username_users_uk UNIQUE (username);

ALTER TABLE users ADD CONSTRAINT email_id_users_uk UNIQUE (email_id);
