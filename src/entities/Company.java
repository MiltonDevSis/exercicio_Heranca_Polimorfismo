package entities;

public class Company extends TaxPayer{

    private Integer numberOfEmployees;

    public Company(){
        super();
    }

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        if(numberOfEmployees <= 10){
            //ate 10 funcionarios
            return getAnualIncome() * 16 / 100;
        }
        return getAnualIncome() * 14 / 100;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return this.getName()
                +": $ "+ String.format("%.2f",this.tax());
    }
}
