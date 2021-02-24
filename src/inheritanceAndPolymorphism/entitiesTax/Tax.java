package inheritanceAndPolymorphism.entitiesTax;

public abstract class Tax {

    private String name;
    private double annualIncome;

    public Tax(){
    }

    public Tax(String name, double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    @Override
    public String toString() {
        return    name
                + " $ "
                + String.format("%.2f",totalTax());
    }

    public abstract double totalTax();

}
