package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
      ToyStore store = new ToyStore();
      store.addToy(1, "Mishka", 10, 15);
      store.addToy(2, "Sukuna", 23, 40);
      store.addToy(3, "Godgi", 15, 25);
      store.setToyWeight(1,10);

      store.play();
        try {
            store.getPrizeToys();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}