package inheritanceAndPolymorphism.entitiesTax;

public class LegalPerson extends Tax {

    Integer employeeNumber;

    public LegalPerson() {
    }

    public LegalPerson(String name, double annualIncome, Integer employeeNumber) {
        super(name, annualIncome);
        this.employeeNumber = employeeNumber;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public double totalTax() {

        double value = 0;

        if (getEmployeeNumber() > 10) {
            value = getAnnualIncome() * 0.14;
        } else {
            value = getAnnualIncome() * 0.16;
        }
        return value;
    }
}
