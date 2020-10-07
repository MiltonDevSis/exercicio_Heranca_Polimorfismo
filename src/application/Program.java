package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.println("Enter the numbers of tax payers: ");
        int n = entrada.nextInt();
        for(int i = 1; i <= n; i++){
            System.out.println("Tax payer #"+(i)+" data!");
            System.out.println("Individual or Company (i/c)?");
            char carac = entrada.next().charAt(0);
            if(carac == 'i'){
                System.out.println("Name:");
                String name = entrada.next();
                System.out.println("Anual Income:");
                Double anualIncomeIndividual = entrada.nextDouble();
                System.out.println("Health expenditures");
                Double healthExpenditures = entrada.nextDouble();
                Individual individual = new Individual(name, anualIncomeIndividual, healthExpenditures);
                list.add(individual);
            }else if(carac == 'c'){
                System.out.println("Name:");
                String nameCompany = entrada.next();
                System.out.println("Anual Income:");
                Double anualIncomeCompany = entrada.nextDouble();
                System.out.println("Number of Employees:");
                Integer employees = entrada.nextInt();
                Company company = new Company(nameCompany, anualIncomeCompany, employees);
                list.add(company);
            }else{
                System.out.println("Entidade não encontrada");
                i = -1;
                System.out.println();
            }
        }
        for (TaxPayer tp: list){
            System.out.println(tp);
        }
        System.out.println();
        Double sum = 0.0;
        for (TaxPayer tp: list){
            sum += tp.tax();
        }
        System.out.println("Total Taxes: $ " + String.format("%.2f", sum));
        entrada.close();
    }
}
