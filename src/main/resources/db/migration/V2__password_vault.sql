create table pass_vault (
    id BIGSERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL ,
    url TEXT NOT NULL,
    name TEXT NOT NULL,
    identity TEXT NOT NULL,
    password TEXT NOT NULL ,
    created_at TIMESTAMP
);


ALTER TABLE pass_vault ADD CONSTRAINT user_id_pass_vault_fk FOREIGN KEY (user_id) REFERENCES users(id) ;

