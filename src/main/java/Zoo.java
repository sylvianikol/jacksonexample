import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.*;

public class Zoo {

    private Animal animal;

    public Zoo() {
    }

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat"),
    })
    public static class Animal {
        private String name;

        public Animal() {
        }

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonTypeName("dog")
    public static class Dog extends Animal {
        private double barkVolume;

        public Dog() {
        }

        public Dog(String name) {
            super(name);
        }

        public double getBarkVolume() {
            return barkVolume;
        }

        public void setBarkVolume(double barkVolume) {
            this.barkVolume = barkVolume;
        }
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {

        boolean likesCream;
        public int lives;

        public Cat() {
        }

        public Cat(String name) {
            super(name);
        }

        public boolean isLikesCream() {
            return likesCream;
        }

        public void setLikesCream(boolean likesCream) {
            this.likesCream = likesCream;
        }

        public int getLives() {
            return lives;
        }

        public void setLives(int lives) {
            this.lives = lives;
        }
    }
}
