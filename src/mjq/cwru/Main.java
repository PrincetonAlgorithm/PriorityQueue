package mjq.cwru;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    public class Key {
    }

    public static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public class UnorderedMaxPQ<Key extends Comparable<Key>> {
        private Key[] pq;   //pq[i] ith element on pq
        private int N = 0;      //number of elements on pq

        public UnorderedMaxPQ(int capacity) {
            pq = (Key[]) new Comparable[capacity];
        }

        public void insert(Key key) {
            pq[N++] = key;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public Key delMax() {
            int max = 0;
            for (int i = 0; i < N; i++) {
                if (less(max, i)) max = i;
            }

            exch(pq, max, N - 1);
            return pq[--N];
        }

        private boolean less(int i, int j) {
            if (pq[i].compareTo(pq[j]) < 0)
                return true;
            else return false;
        }
    }

    


}
