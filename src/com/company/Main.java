package com.company;

import java.util.Scanner;

public class Main {

    public static  double getNumber(double xInFunction){
        double number = 0;
        System.out.println("Ввести число - 1" +
                "\nВвести x - 2 ");
        Scanner in = new Scanner(System.in);
        int menu = in.nextInt();
        if(menu == 1 ){
            number = in.nextInt();
        }
        else if (menu == 2){
            number = xInFunction;
        }
        else {
            System.out.println("Неправильна команда! Введіть знову.");
            number = getNumber(xInFunction);
        }
        return number;
    }

    public static double createFunction(double xInFunction, double function){
        String menu;
        System.out.println("Введіть потрібний вам знак: " +
                "\nЩоб закінчити ввід введіть .");
        Scanner in = new Scanner(System.in);
        menu = in.nextLine();
        double number = 0;
        if(menu.equals("+")) {
            function += getNumber(xInFunction);
            function = createFunction(xInFunction,function);
        }
        else if(menu.equals("-")){
            function -= getNumber(xInFunction);
            function = createFunction(xInFunction,function);
        }
        else if(menu.equals("*")){
            function *= getNumber(xInFunction);
            function = createFunction(xInFunction,function);
        }
        else if(menu.equals("/")){
            function /= getNumber(xInFunction);
            function = createFunction(xInFunction,function);
        }
        return function;
    }

    public static double createFunction(double xInFunction){
        int menu = 0;
        double number = 0;
        double function = 0;
        System.out.println("Введіть потрібну вам команду: " +
                "\n 1 - ввести перше число" +
                "\n 2 - вказати х");
        Scanner in = new Scanner(System.in);
        menu = in.nextInt();
        if(menu == 1) {
            System.out.print("Введіть число: ");
            number = in.nextInt();
            function += createFunction(xInFunction, number);
        }
        else if(menu == 2){
            function = xInFunction;
            function += createFunction(xInFunction, number);

        }
        return function;
    }

    public static double calculateIntegral(double start, double finish,
                                           double height, double blocksAmount){

        double step = (finish - start)/blocksAmount;
        double result = 0;
        double x = 0;
        x = createFunction(finish - start);

        for (int i = 2; i <= blocksAmount; i++) {
            double area = 0;
            if (Math.sin(x + i * step) < height) {
                area = Math.sin(x+i*step)  * step;
            }
            else {
                area = 0.1 * step;
            }
            result += area;
        }

        return -result;
    }

    public static void main(String[] args) {
        double start = 0;
        double finish = Math.PI/2;
        double height = 100;
        double blocksAmount = 1000;
        double step = (finish - start)/blocksAmount;
        double result = 0;


        for (int i = 1; i <= blocksAmount; i++) {
            double area = 0;
            if (Math.sin(start + i * step) < height) {
                area = Math.sin(5+(start + i * step)) * step;
            }
            else {
                area = 0.1 * step;
            }
            result += area;
        }
        System.out.println(result);
        result = calculateIntegral(start, finish, height,blocksAmount);
        System.out.println(result);
    }
}
