package entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual(){
        super();
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        if(getAnualIncome() < 20000){
            return getAnualIncome() * 15 / 1000;
        }else if (getAnualIncome() > 20000 && getHealthExpenditures() == 0.0){
            return getAnualIncome() * 25 / 100;
        }
        return (getAnualIncome() * 25 / 100) - (getHealthExpenditures() * 50 / 100);
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public String toString() {
        return this.getName()
                +": $ "+String.format("%.2f",this.tax());
    }
}
