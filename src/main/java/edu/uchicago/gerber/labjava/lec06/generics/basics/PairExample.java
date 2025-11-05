package edu.uchicago.gerber.labjava.lec06.generics.basics;

public class PairExample<F, S> {

        private F first;
        private S second;

        public PairExample(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public S getSecond() {
            return (S) first;
        }

        public void setSecond(S second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }


}
