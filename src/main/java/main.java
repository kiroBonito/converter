import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System;
import java.lang.Integer;
import java.util.Scanner;

public class main {
    public static void show() {
        System.out.println(
                "1. Введите сумму которую хотите переести" + '\n' +
                "2. Показать операции соверенные ранее " + '\n'


        );
    }
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введит путь до файла JSON");
        String fileName = scanner.nextLine();
        operations.fileName = fileName;
        System.out.println("Введите базовую валюту из которой хотите перевести");
        String baseValute = scanner.nextLine();
        System.out.println("Введите  валюту в которую хотите перевести");
        String desireValute = scanner.nextLine();

                show();
                System.out.println("Выберите действие \n");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        float currentPoint = scanner.nextFloat();
                        new operations(baseValute, desireValute, currentPoint);
                        break ;
                    }
                    case 2: {
                        operations.watchOperations();
                        break ;
                    }

                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            }


    }

