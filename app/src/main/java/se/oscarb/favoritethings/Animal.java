package se.oscarb.favoritethings;

public class Animal {


    private int imageId;
    private String name;
    private String description;


    // Konstruktorer
    public Animal () {
        // Kod för ett "standarddjur"/"placeholderdjur"
    }

    public Animal(int imageId, String name, String desc) {
        this.imageId = imageId;
        this.name = name;
        this.description = desc;
    }

    // Instansmetoder
    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }





}
