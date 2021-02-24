package inheritanceAndPolymorphism.entitiesTax;

public class PhysicalPerson extends Tax{

    public double healthExpenses;

    public PhysicalPerson() {

    }

    public PhysicalPerson(String name, double annualIncome, double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public double totalTax() {
        double value = 0;

         if(getAnnualIncome() < 20000 && getHealthExpenses() > 0) {
             value = getAnnualIncome() * 0.15 - (getHealthExpenses() * 0.5);
        } if (getAnnualIncome() > 20000 && getHealthExpenses() > 0) {
            value = (getAnnualIncome() * 0.25) - (getHealthExpenses() * 0.5);
        }
        return value;
    }
}
