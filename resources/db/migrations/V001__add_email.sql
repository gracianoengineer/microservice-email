CREATE TABLE IF NOT EXISTS email
(
    email_id uuid not null,
    email_body text not null,
    email_from varchar(255) not null,
    email_to varchar(255) not null,
    owner_ref varchar(255) not null,
    send_date_email timestamp without time zone,
    status_email integer,
    subject varchar(255) not null,
    CONSTRAINT email_pkey PRIMARY KEY (email_id)
)