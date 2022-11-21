import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static int difficulty = 3;

    public static void main(String[] args) {

        int operationId = 99;
        List<Integer> operations = new ArrayList<>();
        Collections.addAll(operations, 1, 2, 0);

        do {
            System.out.println("\n\nДобро пожаловать в игру \"Горячо-Холодно\"! \n\n1. Начать игру \n2. Изменить настройки \n0. Выход");
            Scanner input = new Scanner(System.in);

            try {
                operationId = input.nextInt();
                if (!operations.contains(operationId) ) {
                    System.out.println("\033[0;31m" + "Введите число, соответствующее необходимому действию" + "\033[0m");
                    continue;
                }
                if (operationId == 0) System.exit(0);

            } catch (InputMismatchException err) {
                System.out.println("\033[0;31m" + "Введите цельное число (int)!" + "\033[0m");
                continue;
            }

            switch (operationId) {
                case 1: {
                    game();
                    System.out.println("\nСпасибо за игру!");
                    break;
                }
                case 2: {
                    settings();
                    System.out.println("\nНастройки сохранены!");
                    break;
                }
            }

        } while (operationId != 0);
    }

    public static void game(){
        int numberOfTries = 0, maxValue = 0, generatedNumber, suggestedNumber, distance = 0;

        switch (difficulty) {
            case 1: {
                numberOfTries = 28; //x2 tries
                maxValue = 100;
                distance = 50;
                break;
            }
            case 2: {
                numberOfTries = 18; //+4 extra tries
                maxValue = 100;
                distance = 50;
                break;
            }
            case 3: {
                numberOfTries = 20; //hardcore 2^n tries
                maxValue = 1000;
                distance = 500;
                break;
            }
        }

        generatedNumber = ThreadLocalRandom.current().nextInt(0, maxValue + 1);
        System.out.println("\nAI загадало число от 0 до " + maxValue + "\nВаша задача - угадать это число за " + numberOfTries + " попыток!\n");

        for (int count = 0; count < numberOfTries; count++){
            System.out.println("\nВведите предполагаемое число\n(Введите \"-1\" для завершения игры)");
            Scanner input = new Scanner(System.in);

            try {
                suggestedNumber = input.nextInt();
                if (suggestedNumber == -1) {
                    System.out.println("\nИгра досрочно завершена.");
                    return;
                }
                else if (maxValue < suggestedNumber || suggestedNumber <= 0) {
                    System.out.println("\n\033[0;31m" + "Введите число в рамках от 0 до "+ maxValue + "!\033[0m");
                  //  count--;
                    continue;
                }
            } catch (InputMismatchException err) {
                System.out.println("\033[0;31m" + "Введите цельное число (int)!" + "\033[0m");
               // count--;
                continue;
            }

            if (suggestedNumber != generatedNumber){
                int newDistance = Math.abs(suggestedNumber - generatedNumber);
                if (newDistance <= distance){
                    System.out.println("\nГорячо! Осталось " + (numberOfTries-(count+1)) + " попыток.");
                } else {
                    System.out.println("\nХолодно! Осталось " + (numberOfTries-(count+1)) + " попыток.");
                }
                distance = newDistance;
            } else {
                System.out.println("\nВы угадали! Загаданное число: " + generatedNumber + ". Вам понадобилось " + (count+1) + " попыток.");
                return;
            }
        }

        System.out.println("\nКонец игры! Вы израсходовали все " + numberOfTries + " попыток. Загаданное число: " + generatedNumber);
    }

    public static void settings(){

    }
}