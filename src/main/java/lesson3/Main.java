package lesson3;

import lesson3.deque.Deque;
import lesson3.deque.DequeImpl;
import lesson3.queue.PriorityQueueImpl;
import lesson3.queue.Queue;
import lesson3.queue.QueueImpl;

public class Main {
    public static void main(String[] args) {
        Integer[] example1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        Integer[] example2 = new Integer[]{1, 2, 4, 5, 6};
        Integer[] example3 = new Integer[]{};
//        System.out.println("Result " + findSkipElement(example1));
//        System.out.println("Result " + findSkipElement(example2));
//        System.out.println("Result " + findSkipElement(example3));
        testDeque();

    }

    public static int findSkipElement(Integer[] arrays) {
        int start = 0;
        int end = arrays.length - 1;
        int base = 1;

        if (arrays.length == 0) {
            return 1;
        } else {
            Integer count = arrays.length;

            for (int i = 0; i < count; i++) {
                base = (start + end) / 2;
                if (arrays[base] == arrays[base - 1] + 2) {
                    break;
                } else if (arrays[base] == base + 1) {
                    start = base + 1;
                } else
                    end = base - 1;
            }
            return arrays[base - 1] + 1;
        }
    }

    private static void testDeque() {
        Deque<Integer> deque = new DequeImpl<>(7);
        System.out.println("add element: " + deque.insertRight(34));
        System.out.println("add element: " + deque.insertRight(12));
        System.out.println("add element: " + deque.insertRight(20));
        System.out.println("add element: " + deque.insertRight(16));
        System.out.println("add element: " + deque.insertRight(14));
        System.out.println("add element: " + deque.insertRight(17));
        deque.display();
        System.out.println("add element: " + deque.insertLeft(23));

        deque.display();
        System.out.println("remove: " + deque.removeLeft());
        System.out.println("remove: " + deque.removeRight());
        deque.display();

    }
}
