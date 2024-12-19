package ru.gb.lesson1.task2;


import ru.gb.lesson1.task2.interfaces.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PetSoft
 * @date 18.12.2024 22:46
 */
public class Cart<T extends Food> {
    //region Fields
    private final ArrayList<T> foodStuffs;
    private final UMarket market;
    private final Class<T> clazz;
    //endregion

    //region Constructor
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        this.foodStuffs = new ArrayList<>();
    }
    //endregion

    //region Methods
    public void cartBalancingV3() {
        boolean proteins = false;
//        boolean[] proteins = {false};
        boolean fats = false;
        boolean carbohydrates = false;

//        foodStuffs.stream()
//                .filter(food -> {
//                    if (!proteins && food.getProteins())
//                    return  ;
//                });
    }

    public void cartBalancingV2() {
        boolean[] proteins = {false};
        boolean[] fats = {false};
        boolean[] carbohydrates = {false};

        foodStuffs.forEach(food -> {
            if(!proteins[0] && food.getProteins())
                proteins[0] = true;
            else if (!fats[0] && food.getFats())
                fats[0] = true;
            else if (!carbohydrates[0] && food.getCarbohydrates())
                carbohydrates[0] = true;
        });

        if (proteins[0] && fats[0] && carbohydrates[0]) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        boolean[] flag = {true};
        market.getThings(Food.class)
                .forEach(thing -> {
                    if (flag[0]) {
                        if (!proteins[0] && thing.getProteins()) {
                            proteins[0] = true;
                            foodStuffs.add((T) thing);
                        } else if (!fats[0] && thing.getFats()) {
                            fats[0] = true;
                            foodStuffs.add((T) thing);
                        } else if (!carbohydrates[0] && thing.getCarbohydrates()) {
                            carbohydrates[0] = true;
                            foodStuffs.add((T) thing);
                        }
                        if (proteins[0] && fats[0] && carbohydrates[0]) {
                            flag[0] = false;
                        }
                    }
                });
        if (proteins[0] && fats[0] && carbohydrates[0])
            System.out.println("Корзина уже сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
    }

    public void cartBalancing() {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        for (var food : foodStuffs) {
            if (!proteins && food.getProteins())
                proteins = true;
            else if (!fats && food.getFats())
                fats = true;
            else if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
        }

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        for (var thing : market.getThings(Food.class)) {
            if (!proteins && thing.getProteins()) {
                proteins = true;
                foodStuffs.add((T) thing);
            } else if (!fats && thing.getFats()) {
                fats = true;
                foodStuffs.add((T) thing);
            } else if (!carbohydrates && thing.getCarbohydrates()) {
                carbohydrates = true;
                foodStuffs.add((T) thing);
            }
            if (proteins && fats && carbohydrates) {
                break;
            }
        }

        if (proteins && fats && carbohydrates)
            System.out.println("Корзина уже сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
    }

    public void printFoodStuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodStuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(),
                    food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "1ет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    public Collection<T> getFoodStuffs() {
        return foodStuffs;
    }
    //endregion
}
























