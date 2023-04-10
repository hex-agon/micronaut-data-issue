CREATE TABLE account (
    uuid          uuid                     NOT NULL PRIMARY KEY,
    username      varchar                  NOT NULL,
    email         varchar                  NOT NULL,
    email_status  varchar                  NOT NULL DEFAULT 'UNVERIFIED',
    password      bytea                    NOT NULL,
    registered_at timestamp WITH TIME ZONE NOT NULL DEFAULT NOW()
);