package cat.uvic.teknos.bandhub.file.repositories;

public class StaticInstanceMethods {
    public static void main(String[] args) {
        var i1 = new StaticInstanceMethods();
        var i2 = new StaticInstanceMethods();
        var i3 = new StaticInstanceMethods();

        i1.incrementCounters();
        i1.incrementCounters();
        i1.incrementCounters();
        i2.incrementCounters();
        i3.incrementCounters();
        i3.incrementCounters();

        i1.printCounter();
        i2.printCounter();
        i3.printCounter();

        StaticInstanceMethods.incrementStaticCounter();
        StaticInstanceMethods.incrementStaticCounter();
        StaticInstanceMethods.incrementStaticCounter();


        StaticInstanceMethods.printStaticCounter();
    }

    int counter;
    static int staticCounter;

    void incrementCounters() {
        counter++;
        incrementStaticCounter();
    }

    static void incrementStaticCounter() {
        staticCounter++;
    }

    void printCounter() {
        System.out.println(counter);
    }

    static void printStaticCounter() {
        System.out.println("Static counter: " + staticCounter);
    }
}
