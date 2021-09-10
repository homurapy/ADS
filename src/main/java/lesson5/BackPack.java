package lesson5;

import java.util.*;

public class BackPack {
    private Integer capacity;
    private List<Item> itemList;

    public BackPack(Integer capacity) {
        this.capacity = capacity;
        this.itemList = new ArrayList<>();
    }


    private Integer calcTotalPrice(Set<Item> itemsTest) {
        Integer total = 0;
        for (Item item : itemsTest) {
            total += item.getPrice();
        }
        return total;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> putToBackPack(List<Item> items) {
        Integer max = 0;

        itemList.addAll(selectBackPack(items, capacity));
        return itemList;
    }

    private List<Item> selectBackPack(List<Item> items, Integer cap) {
        Integer max = 0;
        List<Item> forSelectList = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            Set<Item> selected = new HashSet<>();
            List<Item> tempList = items;
            Item tempItem = items.get(i);
            if (tempItem.getWeight() <= cap && cap > 0) {
                List<Item> wer = tempList;
                if (!selected.contains(tempItem)) {
                    selected.add(tempItem);
                }
                selected.addAll(selectBackPack(tempList, cap - tempItem.getWeight()));
                if (calcTotalPrice(selected) > max) {

                    forSelectList.clear();
                    forSelectList.addAll(selected);
                    max = calcTotalPrice(selected);
                }
            }
        }
        return forSelectList;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {
        BackPack backPack = new BackPack(5);
        Item item1 = new Item("Смартфон", 1200, 1);
        Item item2 = new Item("Умные часы", 1800, 2);
        Item item3 = new Item("Ноутбук", 5000, 4);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        backPack.putToBackPack(items);
        backPack.itemList.forEach(t -> System.out.println(t));
        backPack.itemList.clear();
    }

}



