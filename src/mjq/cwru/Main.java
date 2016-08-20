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
            return pq[i].compareTo(pq[j]) < 0;
        }
    }

    public class MaxPQ<Key extends Comparable<Key>> {
        private Key[] pq;
        private int N;

        public MaxPQ(int capacity) {
            pq = (Key[]) new Comparable[capacity];
        }

        public void insert(Key key) {
            pq[N++] = key;
            swim(N - 1);
        }

        public Key delMax() {
            Key max = pq[0];
            exch(pq, 0, --N);
            sink(0);
            pq[N+1] = null;
            return max;
        }

        private void swim(int k) {
            while (k > 1 && less(k / 2, k)) {
                exch(pq, k / 2, k);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k < N) {
                int j = 2 * k;
                if (less(j, j + 1)) j++; // find the larger child to switch
                if (!less(k, j)) break; //it means parent node is larger than both children
                exch(pq, k, j);
                k = j;
            }

        }

        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

    }


}
