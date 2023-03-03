# Check if data is inserted correctly
select * from accounts;

# Fetch user with accountId
select name, account_id from accounts;

# Check if account exists
select * from accounts where account_id = "ckTV56axff";

# Check account balance
select balance from accounts where account_id = "ckTV56axff";

# Withdraw from account
update accounts set balance = balance - 500 where account_id = "ckTV56axff";

# Deposit into account
update accounts set balance = balance + 500 where account_id = "fhRq46Y6vB";