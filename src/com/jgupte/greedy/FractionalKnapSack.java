package com.jgupte.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapSack {
    static class Item {
        Double cost;
        double weight;
        double value;
        String name;

        public Item(double weight, double value, String name) {
            this.cost = value / weight;
            this.weight = weight;
            this.value = value;
            this.name = name;
        }
    }

    double getMaxValue(ArrayList<Item> items, double W) {
        Collections.sort(items, (o1, o2) -> {
            return o2.cost.compareTo(o1.cost);
        });

        double maxValue = 0;
        double totalWeight = 0;

        for (Item item : items) {
            if (totalWeight + item.weight < W) {
                totalWeight += item.weight;
                maxValue += item.weight * item.cost;
            } else {
                double remainingCap = W - totalWeight;
                maxValue += remainingCap * item.cost;
                totalWeight += remainingCap;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        FractionalKnapSack fn = new FractionalKnapSack();
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(4, 12, "item1"));
        items.add(new Item(8, 32, "item2"));
        items.add(new Item(2, 40, "item3"));
        items.add(new Item(6, 30, "item4"));
        items.add(new Item(1, 50, "item5"));

        System.out.println("Max Value: " + fn.getMaxValue(items, 10));
    }

}
