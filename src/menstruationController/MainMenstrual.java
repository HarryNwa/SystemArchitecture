package menstrualService;

import menstrualData.repository.MenstruationRepositoryImpl;

import javax.swing.*;

import java.time.LocalDate;
import java.util.*;

import static java.lang.System.exit;


import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MainMenstrual {
    private final List<Date> periodStartDates = new ArrayList<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private int userInput;
    private Scanner keyBoard = new Scanner(System.in);

    MenstruationRepositoryImpl menstruationRepository = new MenstruationRepositoryImpl();

    public static void main(String[] args) {

        MainMenstrual main = new MainMenstrual();


        LocalDate startDate = LocalDate.parse("2023-09-22");
        LocalDate nextFlowDate = startDate.plusDays(14);
        System.out.println(nextFlowDate);



        main.welcomePage();
    }

    public void welcomePage() {
        userInput = Integer.parseInt((String) prompt("""
                HELLO! WELCOME!!
                                
                You can check your: 
                                
                                
                1. Menstrual safe period
                                    
                2. Ovulation
                                    
                3. Menstrual flow
                                
                4. Circle Length
                
                5. Exit"""));
        switch (userInput) {
            case 1 -> safePeriod();
            case 2 -> ovulation();
            case 3 -> menstrualFlow();
            default -> exit(0);
        }
    }

    public SimpleDateFormat date() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    public void menstrualFlow() {
        Date inputDate = null;

        while (inputDate == null) {
            String userInput = (String) prompt("Enter the last day of your flow (yyyy-MM-dd): ");

            try {
                inputDate = menstruationRepository.findEndFlow(date().parse(userInput));
                display("Hi dear, you can expect your next flow on " + inputDate);
                welcomePage();

            } catch (ParseException e) {
                display("Invalid date format. Please use yyyy-MM-dd.");
            }
        }

    }

    public void ovulation() {
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ovulation = null;

        while (ovulation == null) {
            String userInput = (String) prompt("Enter the last day of your period (yyyy-MM-dd): ");

            try {
                ovulation = menstruationRepository.findSafePeriodStart(newDateFormat.parse(userInput));
                display("Hi dear, your ovulation starts on: " + ovulation);
                welcomePage();

            } catch (ParseException e) {
                display("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    public void safePeriod() {
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date endPeriod = null;
        Date startPeriod = null;

        while (endPeriod == null && startPeriod == null) {
            String userInput = (String) prompt("Enter the last day of your period (yyyy-MM-dd): ");

            try {
                startPeriod = menstruationRepository.findSafePeriodStart(newDateFormat.parse(userInput));
                endPeriod = menstruationRepository.findSafePeriodEnd(newDateFormat.parse(userInput));
                display("Hi dear, your safe period starts on: " + startPeriod + " and ends on " + endPeriod);
                welcomePage();

            } catch (ParseException e) {
                display("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    public String prompt(String message){
        return JOptionPane.showInputDialog(message);
    }
    public void display(String message){
        JOptionPane.showMessageDialog(null, message);
    }

}
