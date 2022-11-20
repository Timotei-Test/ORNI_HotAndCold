import java.util.*;

public class Main {
    public static void main(String[] args) {
//ha
        int operationId = 99;
        int firstNumber = 0, secondNumber = 0, result = 0;
        List<Integer> operations = new ArrayList<>();
        Collections.addAll(operations, 1, 2, 3, 4, 0);

        do {
            System.out.println("\n\nВыберите действие: \n 1. Сложение \n 2. Вычитание \n 3. Умножение \n 4. Деление \n 0. Выход");
            Scanner input = new Scanner(System.in);

            try {
                operationId = input.nextInt();
                if (!operations.contains(operationId) ) {
                    System.out.println("\033[0;31m" + "Введите число, соответствующее необходимому действию" + "\033[0m");
                    continue;
                }
                if (operationId == 0) System.exit(0);

                System.out.println("Введите первое число");
                firstNumber = input.nextInt();

                System.out.println("Введите второе число");
                secondNumber = input.nextInt();
            } catch (InputMismatchException err) {
                System.out.println("\033[0;31m" + "Введите цельное число (int)!" + "\033[0m");
                continue;
            }

            switch (operationId){
                case 1:{
                    result = firstNumber + secondNumber;
                    System.out.println("Результат сложения: " + result);
                    break;
                }
                case 2:{
                    result = firstNumber - secondNumber;
                    System.out.println("Результат вычитания: " + result);
                    break;
                }
                case 3:{
                    result = firstNumber * secondNumber;
                    System.out.println("Результат умножения: " + result);
                    break;
                }
                case 4:{
                    try {
                        result = firstNumber / secondNumber;
                        System.out.println("Результат деления: " + result);
                        break;
                    } catch (ArithmeticException err) {
                        System.out.println("\033[0;31m" + "Нельзя делить на 0!" + "\033[0m");
                        break;
                    }

                }
            }

        } while (operationId != 0);

    }


}