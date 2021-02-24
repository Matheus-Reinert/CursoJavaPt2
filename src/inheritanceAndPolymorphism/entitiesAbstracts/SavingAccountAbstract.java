package inheritanceAndPolymorphism.entitiesAbstracts;

import inheritanceAndPolymorphism.entitiesAccount.Account;

public class SavingAccountAbstract extends AccountAbstract {

    private double interestRate;

    public SavingAccountAbstract() {
        super();
    }

    public SavingAccountAbstract(Integer number, String holder, double balance, double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }
}
