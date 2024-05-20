package com.alura_challenge_2.main;

import com.alura_challenge_2.modulo.API;
import com.alura_challenge_2.modulo.Dates;
import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int choice;
        Gson gson = new Gson();

        System.out.println("¡Bienvenido a tu convertidor de divisas de confianza! En nuestra aplicación, encontrarás");
        System.out.println("más de 160 tasas de conversión actualizadas para que siempre obtengas el valor exacto en");
        System.out.println("cualquier transacción. Ya sea que estés planeando un viaje, realizando compras internacionales");
        System.out.println("o gestionando tus finanzas, estamos aquí para facilitarte el cambio de divisas de manera rápida");
        System.out.println("y precisa.");

        do {
            System.out.println("""
                    
                    
                    **************************************************************************************************************
                                    
                    1. Conocer el valor de las tasas de conversión de una
                       divisa frente a todas los demás.
                                    
                    2. Conocer el valor de cambio de una divisa frente a
                       otra divisa.
                       
                    3. Salir
                                   
                    **************************************************************************************************************
                    """);
            choice = teclado.nextInt();
            teclado.nextLine();

            if (choice == 1) {
                String base = "latest/";
                System.out.println("¿cuál es la divisa?");
                String firstExchangeRate = teclado.nextLine();
                String url = base + firstExchangeRate;

                try {
                    API api = new API(url);
                    String jsonResponse = api.getJson();
                    Dates consersionRate = gson.fromJson(jsonResponse, Dates.class);
                    System.out.println(consersionRate.conversion_rates());

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (choice == 2) {
                String base = "pair/";
                System.out.println("De:");
                String firstExchangeRate = teclado.nextLine();
                System.out.println("A: ");
                String secondExchangeRate = teclado.nextLine();
                String url = base + firstExchangeRate + "/" + secondExchangeRate;

                try {
                    API api = new API(url);
                    String jsonResponse = api.getJson();
                    Dates consersionRate = gson.fromJson(jsonResponse, Dates.class);
                    System.out.println("La tasa de conversión de la divisa es: " + consersionRate.conversion_rate());
                    System.out.println("Cuanto deseas convertir");
                    choice = teclado.nextInt();
                    double coins = choice * consersionRate.conversion_rate();
                    System.out.println("Es un total de: " + coins + " " + secondExchangeRate + ".");

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (choice != 3) {
                System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        } while (choice != 3);
        System.out.println("Gracias por usar nuestra aplicacinó, espero que te haya sido de ayuda.");
        teclado.close();

    }
}