package org.example;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.IOException;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }


    public void addToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void setToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void play() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        Random random = new Random();
        double randomWeight = random.nextDouble() * totalWeight;
        Toy prizeToy = null;
        for (Toy toy : toys) {
            if (randomWeight < toy.getWeight()) {
                prizeToy = toy;
                break;
            }
            randomWeight -= toy.getWeight();
        }
        if (prizeToy != null && prizeToy.getQuantity() > 0) {
            prizeToys.add(prizeToy);
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
        }
    }



    public void getPrizeToys() throws IOException{
        if(prizeToys.size() > 0){
         Toy prizeToy = prizeToys.remove(0);
            FileWriter writer = new FileWriter("priz_toy.txt", true);
            writer.write(prizeToy.getId() + ", " + prizeToy.getName() + "\n");
            writer.close();
        }
    }
}

