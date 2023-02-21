package lesson1;

import static lesson1.Barrier.BarrierType.runOnGround;
import static lesson1.Barrier.BarrierType.swimInWater;

public class Barrier {
    private BarrierType type;
    private int distance;

    static class BarrierType{
        private String name;
        BarrierType(String name){this.name = name;}

        public String getName() {
            return name;
        }

        static  final BarrierType runOnGround = new BarrierType("беговое препятствие");
        static final BarrierType swimInWater = new BarrierType("водное препятствие");
    }

    public static final Barrier groundBarrier = new Barrier(runOnGround, 7000);
    public static final Barrier waterBarrier = new Barrier(swimInWater, 300);




    public Barrier(BarrierType type, int distance){
        this.type = type;
        this.distance = distance;
    }

    public BarrierType getType() {
        return type;
    }

    public int getDistance() {
        return distance;
    }
}
