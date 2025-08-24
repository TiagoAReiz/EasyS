package Easys.Easys.Core.Model;

public class Service {
    private String name;
    private String description;
    private double price;
    private String category;
    private double duration;
    private int rating;
    private Professional provider;
    private String location;
    private String contact;
    private String image;

    public String getName() {
        return name;
    }
    public Service() {
    }
    public Service(String name, String description, double price, String category, double duration, int rating,
            Professional provider, String location, String contact, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.duration = duration;
        this.rating = rating;
        this.provider = provider;
        this.location = location;
        this.contact = contact;
        this.image = image;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public Professional getProvider() {
        return provider;
    }
    public void setProvider(Professional provider) {
        this.provider = provider;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
}
