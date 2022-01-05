

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите выражение с двумя переменными в интервале 1-10 либо I-X. Между переменными и знаком операции обязательно ставьте пробел");
        String inputString = sc.nextLine();
        System.out.println(calc(inputString));

    }


    public static String calc(String inputString) throws Exception {
        String[] arr = inputString.split(" ");
        if (arr.length > 3) {
            throw new Exception("Выражение введено не корректно, либо слишком много переменных.");
        }
        if (arr.length < 3) {
            throw new Exception("Выражение введено не корректно, либо слишком мало переменных. Не забывайте ставить пробел между переменной и знаком операции");
        }

        String x = arr[0].trim();
        String y = arr[1].trim();
        String z = arr[2].trim();

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        String result2;


        try {
            num1 = Integer.parseInt(x);
            num2 = Integer.parseInt(z);
            if (num1>=1 && num1<=10 && num2>=1 && num2 <=10){
                result = calculated(num1, num2, y);
                result2 = Integer.toString(result);
                return result2;
            }
            else {
                throw new Exception("Введенные переменные выходят из интервала от 1 до 10");
            }
        }

        catch (NumberFormatException e) {

            num1 = romanToNumber(x);
            num2 = romanToNumber(z);
            if (num1>=1 && num1<=10 && num2>=1 && num2 <=10){
                result = calculated(num1, num2, y);
                if (result > 1) {
                    result2 = convertNumToRoman(calculated(num1, num2, y));
                    return result2;
                }
                else if (result < 1) {
                    throw new Exception("Результат выражения римских чисел не может быть меньше I");

                }
            }

        }

        return "";


    }


    public static int calculated (int num1, int num2, String op){
        int result = 0;

        switch (op) {

            case ("+"):

                result = num1 + num2;

                break;

            case ("-"):

                result = num1 - num2;



                break;

            case ("*"):

                result = num1 * num2;




                break;

            case ("/"):


                result = num1 / num2;

                break;
            default:
                throw new IllegalArgumentException("Знак операции не распознан. Введите только +,-,*,/");
        }
        return result;
    }

    private static int romanToNumber (String roman) throws Exception {

        switch (roman){
            case ("I"):
                return 1;

            case ("II"):
                return 2;

            case ("III"):
                return 3;

            case ("IV"):
                return 4;

            case ("V"):
                return 5;

            case ("VI"):
                return 6;

            case ("VII"):
                return 7;

            case ("VIII"):
                return 8;

            case ("IX"):
                return 9;

            case ("X"):
                return 10;


        }


        throw new Exception("Переменные не распознаны. Введите переменные в интервале I-X или 1-10");
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;

    }
}
