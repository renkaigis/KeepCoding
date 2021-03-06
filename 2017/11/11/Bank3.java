public class Bank3 {
    private static ThreadLocal<Integer> account = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public void deposit(int money) {
        account.set(account.get() + money);
    }

    public int getAccount() {
        return account.get();
    }
}
