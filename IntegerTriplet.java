public class IntegerTriplet implements Comparable<IntegerTriplet> {
    protected Integer first;
    protected Integer second;
    protected Integer third;

    public IntegerTriplet(Integer first, Integer second, Integer third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int compareTo(IntegerTriplet o) {
        if (!this.first().equals(o.first()))
            return this.first() - o.first();
        else if (!this.second().equals(o.second()))
            return this.second() - o.second();
        else
            return this.third() - o.third();
    }

    public Integer first() { return first; }
    public Integer second() { return second; }
    public Integer third() { return third; }
}
