package lesson2;

public class NoteBook {
    private String model;
    private String brand;
    private Integer price;
    private Integer odd;

    public NoteBook(String brand, Integer price, Integer odd) {
        this.model = "basic";
        this.brand = brand;
        this.price = price;
        this.odd = odd;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOdd() {
        return odd;
    }

    public void setOdd(Integer odd) {
        this.odd = odd;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", odd=" + odd +
                '}';
    }
}
