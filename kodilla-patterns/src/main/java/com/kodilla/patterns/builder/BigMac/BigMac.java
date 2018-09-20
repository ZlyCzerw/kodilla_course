package com.kodilla.patterns.builder.BigMac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {

    private final String bun;
    private final int burgers;
    private final List<String> ingredients;


    private BigMac(String bun, int burgers, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.ingredients = ingredients;
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun='" + bun + '\'' +
                ", burgers='" + burgers + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class BigMacBuilder{

        private String bun;
        private int burgers;
        private List<String> ingredients = new ArrayList<>();

        public static final String WITHSESAME = "With sesame";
        public static final String CLEAN = "Without sesame";
        public static final String STANDARD = "Standard";
        public static final String ISLANDS = "1000 Islands";
        public static final String BBQ = "barbecue";

        public BigMacBuilder bun(String bun) {
            if (bun.equals(WITHSESAME)||bun.equals(CLEAN)) {
                this.bun = bun;
            }else {
                throw new IllegalStateException("takich bułek nie ma w ofercie");
            }
            return this;
        }

        public BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder ingredients(String ingredient) {
            if (ingredient.equals(ISLANDS)||ingredient.equals(BBQ)||ingredient.equals(STANDARD)) {
                this.ingredients.add(ingredient);
            }else {
                throw new IllegalStateException("takich bułek nie ma w ofercie");
            }
            return this;
            }

         public BigMac build(){
            return new BigMac(bun,burgers,ingredients);
         }


    }
}
