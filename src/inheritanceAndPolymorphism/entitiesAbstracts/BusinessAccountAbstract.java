package inheritanceAndPolymorphism.entitiesAbstracts;

import inheritanceAndPolymorphism.entitiesAccount.Account;

public class BusinessAccountAbstract extends AccountAbstract {

    private double loanLimit;

    public BusinessAccountAbstract() {
    }

    public BusinessAccountAbstract(Integer number, String holder, double balance, double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if(amount <= loanLimit) {
            balance += amount - 10.0;
        }
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        balance -= 2.0;
    }
}
