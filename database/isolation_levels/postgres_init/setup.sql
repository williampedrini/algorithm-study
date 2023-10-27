create table public.account
(
    id         integer,
    owner      character varying(255),
    balance    integer,
    currency   character varying(3),
    created_at timestamp without time zone
);

insert into public.account (id, owner, balance, currency, created_at)
values (1, 'one', 100, 'USD', CURRENT_DATE);

insert into public.account (id, owner, balance, currency, created_at)
values (2, 'two', 100, 'USD', CURRENT_DATE);

insert into public.account (id, owner, balance, currency, created_at)
values (3, 'three', 100, 'USD', CURRENT_DATE);

