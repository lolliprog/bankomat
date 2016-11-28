package com.alexandrova;

import java.util.Scanner;

/**
 * Created by Lenovo on 19.11.2016.
 */
public class Atm {
    boolean isPoweredOn = false;
    int moneyCount = 900;
    Card mUserCard;

    void pushMoney() {
        mUserCard.pushMoney();
        showMainMenu();
    }

    void getAllCards() {

    }

    void setCurrentCard() {

    }

    void getMoney() {
//        System.out.println("How much money do you want to get?");
//        Scanner sc = new Scanner(System.in);
//        int line = 0;
//        if (sc.hasNextInt()) {
//            line = sc.nextInt();
//            if (line > moneyCount) {
//                System.out.println("Sorry! It is very cheap ATM. We dont have enough money.");
//                line = 0;
//                System.out.println("Current balance: " + moneyCount + "\n" + "Removed money: " + line);
//            } else {
//                moneyCount = moneyCount - line;
//                System.out.println("Current balance: " + moneyCount + "\n" + "Removed money: " + line);
//            }
//        } else {
//            System.out.println("Enter a number for getting money");
//        }
        mUserCard.getMoney();
        showMainMenu();
    }

    void showMainMenu() {
        System.out.println("\n" + "Choose what do you want:" + "\n"
                + "1. Get money" + "\n"
                + "2. Push money" + "\n"
                + "3. Show balance" + "\n"
                + "4. Show info about card" + "\n"
                + "5. Exit");
    }

    void showBalance() {
        mUserCard.checkBalance();
        showMainMenu();
    }

    boolean checkPassword() {
        System.out.println("Please enter your login: ");
        Scanner scLog = new Scanner(System.in);
        String login = scLog.nextLine();
        if (login.equals("user")) {
            System.out.println("Please enter your password: ");
            Scanner scPas = new Scanner(System.in);
            String password = scPas.nextLine();
            if (password.equals("user")) {
                return true;
            } else {
                System.out.println("Wrong password");
                return false;
            }
        } else {
            System.out.println("Unknown login");
            return false;
        }
    }

    void startProgramm() {
        System.out.println("Hello! ATM on Bogatyrskii prospekt is on and ready to work.");
        boolean incorrectPas = true;
        while (incorrectPas) {
            incorrectPas = !checkPassword();
        }
        mUserCard = new Card(1111, "user", 123, "VISA", 2017, 100, 70);
        showMainMenu();
        while (isPoweredOn == true) {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    getMoney();
                    break;
                case "2":
                    pushMoney();
                    break;
                case "3":
                    showBalance();
                    break;
                case "4":
                    showCardInfo();
                    break;
                case "5":
                    toglePower();
                    break;
                default:
                    System.out.println("Choose correct action");
                    showMainMenu();
            }
        }
    }
    void showCardInfo(){
        mUserCard.showCardInfo();
        showMainMenu();
    }

    void toglePower() {
        if (isPoweredOn == false) {
            isPoweredOn = true;
            startProgramm();
        } else {
            isPoweredOn = false;
        }
    }

    void start() {
        toglePower();
    }

}
