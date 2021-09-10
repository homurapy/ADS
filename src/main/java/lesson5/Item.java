package lesson5;

public class Item {
    private String name;
    private Integer price;
    private Integer weight;

    public Item(String name, Integer price, Integer weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
    public Item(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
