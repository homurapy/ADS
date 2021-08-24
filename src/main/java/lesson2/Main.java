package lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        List<NoteBook> noteBookList = new ArrayList<>();
        String[] brands = new String[]{"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};
        Integer[] odds = new Integer[]{4, 6, 8, 12};
        Integer[] prices = new Integer[]{500, 600, 700, 800, 900, 1000};
        NoteBook[] baseNoteBook = creatorNotebookFabric(5000, brands, odds, prices);
        Arrays.stream(baseNoteBook).forEach(t->System.out.println(t.toString()));
        NoteBook[] noteBooks = sortNoteBook(baseNoteBook, brands);
        Arrays.stream(noteBooks).forEach(t->System.out.println(t.toString()));
    }

    public static NoteBook[] creatorNotebookFabric(Integer quantity, String[] brands, Integer[] odds, Integer[] prices) {
        List<NoteBook> noteBookList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            NoteBook noteBook = new NoteBook(brands[(int) (Math.random() * brands.length)], prices[(int) (Math.random() * prices.length)], odds[(int) (Math.random() * odds.length)]);
            noteBookList.add(noteBook);
        }
        return noteBookList.stream().toArray(NoteBook[]::new);
    }

    public static NoteBook[] sort(NoteBook[] arr) {
        boolean isChange;
        int limit = arr.length;
        do {
            isChange = false;
            limit--;
            for (int i = 0; i < limit; i++) {
                if (arr[i].getPrice() > arr[i + 1].getPrice()) {
                    NoteBook temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isChange = true;
                }
                if (arr[i].getPrice() == arr[i + 1].getPrice()) {
                    NoteBook temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isChange = true;
                }
            }
        } while (isChange);
        return arr;
    }

    public static NoteBook[] sortNoteBook(NoteBook[] arr, String[] brands) {
        List<NoteBook> arr500odd4 = new ArrayList<>();
        List<NoteBook> arr500odd8 = new ArrayList<>();
        List<NoteBook> arr500odd12 = new ArrayList<>();
        List<NoteBook> arr600odd4 = new ArrayList<>();
        List<NoteBook> arr600odd8 = new ArrayList<>();
        List<NoteBook> arr600odd12 = new ArrayList<>();
        List<NoteBook> arr700odd4 = new ArrayList<>();
        List<NoteBook> arr700odd8 = new ArrayList<>();
        List<NoteBook> arr700odd12 = new ArrayList<>();
        List<NoteBook> arr800odd4 = new ArrayList<>();
        List<NoteBook> arr800odd8 = new ArrayList<>();
        List<NoteBook> arr800odd12 = new ArrayList<>();
        List<NoteBook> arr900odd4 = new ArrayList<>();
        List<NoteBook> arr900odd8 = new ArrayList<>();
        List<NoteBook> arr900odd12 = new ArrayList<>();
        List<NoteBook> arr1000odd4 = new ArrayList<>();
        List<NoteBook> arr1000odd8 = new ArrayList<>();
        List<NoteBook> arr1000odd12 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPrice() == 500 && arr[i].getOdd() == 4) {
                arr500odd4.add(arr[i]);
            }
            if (arr[i].getPrice() == 500 && arr[i].getOdd() == 8) {
                arr500odd8.add(arr[i]);
            }
            if (arr[i].getPrice() == 500 && arr[i].getOdd() == 12) {
                arr500odd12.add(arr[i]);
            }
            if (arr[i].getPrice() == 600 && arr[i].getOdd() == 4) {
                arr600odd4.add(arr[i]);
            }
            if (arr[i].getPrice() == 600 && arr[i].getOdd() == 8) {
                arr600odd8.add(arr[i]);
            }
            if (arr[i].getPrice() == 600 && arr[i].getOdd() == 12) {
                arr600odd12.add(arr[i]);
            }
            if (arr[i].getPrice() == 700 && arr[i].getOdd() == 4) {
                arr700odd4.add(arr[i]);
            }
            if (arr[i].getPrice() == 700 && arr[i].getOdd() == 8) {
                arr700odd8.add(arr[i]);
            }
            if (arr[i].getPrice() == 700 && arr[i].getOdd() == 12) {
                arr700odd12.add(arr[i]);
            }
            if (arr[i].getPrice() == 800 && arr[i].getOdd() == 4) {
                arr800odd4.add(arr[i]);
            }
            if (arr[i].getPrice() == 800 && arr[i].getOdd() == 8) {
                arr800odd8.add(arr[i]);
            }
            if (arr[i].getPrice() == 800 && arr[i].getOdd() == 12) {
                arr800odd12.add(arr[i]);
            }
            if (arr[i].getPrice() == 900 && arr[i].getOdd() == 4) {
                arr900odd4.add(arr[i]);
            }
            if (arr[i].getPrice() == 900 && arr[i].getOdd() == 8) {
                arr900odd8.add(arr[i]);
            }
            if (arr[i].getPrice() == 900 && arr[i].getOdd() == 12) {
                arr900odd12.add(arr[i]);
            }
            if (arr[i].getPrice() == 1000 && arr[i].getOdd() == 4) {
                arr1000odd4.add(arr[i]);
            }
            if (arr[i].getPrice() == 1000 && arr[i].getOdd() == 8) {
                arr1000odd8.add(arr[i]);
            }
            if (arr[i].getPrice() == 1000 && arr[i].getOdd() == 12) {
                arr1000odd12.add(arr[i]);
            }

        }
        NoteBook[] sortedList = new NoteBook[arr.length];
        List<NoteBook> noteBooks = new ArrayList<>();
        noteBooks.addAll(sortByName(arr500odd4, brands));
        noteBooks.addAll(sortByName(arr500odd8, brands));
        noteBooks.addAll(sortByName(arr500odd12, brands));
        noteBooks.addAll(sortByName(arr600odd4, brands));
        noteBooks.addAll(sortByName(arr600odd8, brands));
        noteBooks.addAll(sortByName(arr600odd12, brands));
        noteBooks.addAll(sortByName(arr700odd4, brands));
        noteBooks.addAll(sortByName(arr700odd8, brands));
        noteBooks.addAll(sortByName(arr700odd12, brands));
        noteBooks.addAll(sortByName(arr800odd4, brands));
        noteBooks.addAll(sortByName(arr800odd8, brands));
        noteBooks.addAll(sortByName(arr800odd12, brands));
        noteBooks.addAll(sortByName(arr900odd4, brands));
        noteBooks.addAll(sortByName(arr900odd8, brands));
        noteBooks.addAll(sortByName(arr900odd12, brands));
        noteBooks.addAll(sortByName(arr1000odd4, brands));
        noteBooks.addAll(sortByName(arr1000odd8, brands));
        noteBooks.addAll(sortByName(arr1000odd12, brands));
        NoteBook[] books = noteBooks.stream().toArray(NoteBook[]::new);
        return books;
    }

    public static List<NoteBook> sortByName(List<NoteBook> list, String[] brands) {
        List<NoteBook> noteBookList = new ArrayList<>();
        for (int i = 0; i < brands.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getBrand().equals(brands[i])) {
                    noteBookList.add(list.get(j));
                }
            }
        }
        return noteBookList;
    }


}
