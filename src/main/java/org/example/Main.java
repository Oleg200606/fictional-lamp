package org.example;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static class Employee {
        private String name;
        private int age;
        private int experience;

        public Employee(String name, int age, int experience) {
            this.name = name;
            this.age = age;
            this.experience = experience;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getExperience() {
            return experience;
        }

        public boolean isAdult() {
            return age >= 18;
        }

        public boolean isQuiteExperienced(int requiredExperience) {
            return experience >= requiredExperience;
        }

        public int calculateSalary(int selectedIndex) {
            switch (selectedIndex) {
                case 1:
                    return experience > 7 ? 20000 : 15000;
                case 2:
                    return experience > 10 ? 45000 : 35000;
                case 3:
                    return experience > 12 ? 60000 : 55000;
                default:
                    return 0;
            }
        }

        public String getPosition(int selectIndex) {
            switch (selectIndex) {
                case 1:
                    return "Токарь";
                case 2:
                    return "Фрезерщик";
                case 3:
                    return "Сверльщик";
                default:
                    return "";
            }
        }

        public void printUpdatedInfo(int salary, String post) {
            System.out.println("\nОбновление в анкете:");
            System.out.println("Зарплата: " + salary);
            System.out.println("Должность: " + post);
        }
    }

    public static class Factory {
        public static void selectEmployment(Employee employee) {
            String[] employments = {"Токарный станок", "Фрезерный станок", "Сверлильный станок"};
            System.out.println("Выберите индекс желаемой работы:");
            for (int i = 0; i < employments.length; i++) {
                System.out.println((i + 1) + ": " + employments[i]);
            }
            int selectIndex = scanner.nextInt();
            if (selectIndex >= 1 && selectIndex <= 3) {
                if (employee.isQuiteExperienced(selectIndex == 1 ? 5 : (selectIndex == 2 ? 7 : 10))) {
                    System.out.println("Вы подходите на данную должность!");
                    int salary = employee.calculateSalary(selectIndex);
                    String post = employee.getPosition(selectIndex);
                    employee.printUpdatedInfo(salary, post);
                } else {
                    System.out.println("Сожалеем, но вы не проходите из-за маленького опыта работы");
                }
            } else {
                System.out.println("Некорректный выбор!");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите имя: ");
        String name = scanner.next();
        System.out.println("Введите возраст: ");
        int age = scanner.nextInt();
        System.out.println("Введите опыт работы: ");
        int experience = scanner.nextInt();

        Employee employee = new Employee(name, age, experience);

        System.out.println("\nАнкета персонала:");
        System.out.println("Ваше имя: " + employee.getName());
        System.out.println("Ваш возраст: " + employee.getAge());
        System.out.println("Ваш опыт работы: " + employee.getExperience() + " лет");

        if (employee.isAdult()) {
            Factory.selectEmployment(employee);
        } else {
            System.out.println("Сожалеем, но несовершеннолетние не могут работать на данном заводе");
        }
    }
}