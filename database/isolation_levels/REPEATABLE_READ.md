## REPEATABLE_READ Isolation Level

```
docker-compose up
```

```
docker exec -it postgres_study psql -U postgres -d postgres
```

```
show transaction isolation level;
```

### Create two new transactions

It will be necessary to have two terminal sessions to do it.

``
begin;
``

### Set isolation level

This command will set the isolation level to repeatable read, since the default of postgres is READ_COMMITTED. Execute it on both of them.

```
set transaction isolation level repeatable read;
```

### Verify the content of account table

This will be used as the base data for comparison. Execute it on both of them.

```
select * from account;
```

### Update account data on T1

Update the content of an account on the Transaction1.

```
update account set balance = balance - 10 where id = 1 returning *;
commit;
```

### Verify the content of account table

On the Transaction1 side it is supposed to have the balance decreased by 10.

On the Transaction2 side it is supposed to still have the same balance value.

This is happening due to the fact that we are using the READ COMMITTED isolation level.

In this isolation level it is not possible one transaction see the results of another, even if it was committed.  

```
select * from account where id = 1;
```

### Case #1: Try to update the content of account on T2

Perform an update on T2 side using the same account and see what happens.   

An error `ERROR:  could not serialize access due to concurrent update` should appear.

It means that the T2 will not be able to update it, unless it restarts the transaction.

```
update account set balance = balance - 10 where id = 1 returning *;
commit;
```

### Case #2: Try to insert content on account table

Perform the insertion of a new account on both transactions.

Once committed, both account will appear on the account table, since this isolation type does not avoid serialization phenomena.

```
insert into public.account (id, owner, balance, currency, created_at) values (4, 'forth', 100, 'USD', CURRENT_DATE);
commit;
select * from account;
```