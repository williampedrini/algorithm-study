## READ_COMMITTED Isolation Level

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

### Verify the content of account table

This will be used as the base data for comparison. Execute it on both of them.

```
select * from account;
```

### Update account data on T1

Update the content of an account on the Transaction1.

```
update account set balance = balance - 10 where id = 1 returning *;
```

### Verify the content of account table

On the Transaction1 side it is supposed to have the balance decreased by 10.

On the Transaction2 side it is supposed to still have the same balance value.

This is happening due to the fact that we are using the READ COMMITTED isolation level.

In this isolation level it is not possible one transaction see the results of another, unless it was committed.  

```
select * from account where id = 1;
```

### Commit the changes

```
commit;
```

### Verify the content of account table

Now that the transaction has been committed, the transaction 2 is able to see it. 

Which will remove the Dirty Read problem mentioned above.

However, it will not solve the issue related to Phantom rows on T2.  

```
select * from account where id = 1;
```