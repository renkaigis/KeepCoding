public class Student {
    private int id;
    private String name;
    private boolean male;
    private double account;

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public boolean isMale() {

        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}