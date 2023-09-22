//Task4
interface AccountService {

    Account findAccountByOwnerId(long id);

    long countAccountsWithBalanceGreaterThan(long value);
}
    class AccountServiceImpl implements AccountService
    {
        private Account[] accounts;

        public AccountServiceImpl(Account[] accounts)
        {
            this.accounts=accounts;
        }

        @Override
        public Account findAccountByOwnerId(long id) {

            for (int i = 0; i < accounts.length; i++)
            {   if(accounts[i].getOwner().getId()==id){
                return accounts[i];
            }

            }
                 return null;
        }

        @Override
        public long countAccountsWithBalanceGreaterThan(long value) {
            int count = 0;
            for (int i =0; i<accounts.length;i++)
            {
                if(accounts[i].getBalance() > value) {
                    count++;

                }
                }
            return count;
            }
        }

class Main{
    public static void main(String[] args) {
        User u1 = new User(1L,"Razvan","Dumitrescu");
        User u2 = new User(2L,"Andrei","Borza");

        Account [] accounts = new Account[2];
        accounts[0] = new Account(10L, 500L,u1);
        accounts[1] = new Account(20L, 100L,u2);

        AccountServiceImpl service = new AccountServiceImpl(accounts);
        System.out.println(service.findAccountByOwnerId(2L));
        System.out.println(service.countAccountsWithBalanceGreaterThan(550L));
    }
}

class Account {

    private long id;
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }
    @Override
    public String toString() {
        return "id: " +id + " balance: "+balance + " owner: " + owner.getFirstName();
    }
}

class User {

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

