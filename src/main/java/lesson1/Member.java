package lesson1;

public class Member {
    //основное имя
    private String memberName;
    //Фамилия
    private String lastName;
    //Отчество
    private String secondName;
    private int limitRun;
    private int limitSwim;

    //возраст
    private int age;

    public Member(String memberName, String lastName, String secondName, int age, int limitRun, int limitSwim){
        this.memberName =memberName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.age = age;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
    }
    public Member(String memberName, String lastName, int age, int limitRun, int limitSwim){
        this.memberName =memberName;
        this.lastName = lastName;
        this.age = age;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
    }

    public Boolean tryTheBarrier(Barrier barrier){
        if(barrier.getType() == Barrier.BarrierType.runOnGround){
            return run(barrier.getDistance());

        } else if (barrier.getType() == Barrier.BarrierType.swimInWater) {
            return swim(barrier.getDistance());
        }

        return false;
    }

    Boolean run(int distance){
        if(distance <= limitRun){
            return true;
        }

        return false;
    }
    Boolean swim(int distance){
        if(distance <= limitSwim){
            return true;
        }

        return false;
    }


    public void getMemberInfo(){
        if (secondName == null || secondName == ""){
            System.out.printf("%s %s. Возраст: %s\n", memberName, lastName, age);
        }else {
            System.out.printf("%s %s %s. Возраст: %s\n", memberName, lastName, secondName, age);
        }


    }
    public String getMemberName(){
        return memberName;
    }

}
