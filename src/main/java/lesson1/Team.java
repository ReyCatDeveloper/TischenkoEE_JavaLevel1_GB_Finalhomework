package lesson1;

public class Team {

    private String teamName;
    private Member[] teamMembers;

    Team(String teamName, Member[] teamMembers){
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public Member[] getTeamMembers() {
        return teamMembers;
    }

    public void getFinalistMemberInfo(int[] numbersOfFinalists){ //1 и 3
        for (int i = 0; i < numbersOfFinalists.length; i++){
            if(numbersOfFinalists[i] <= teamMembers.length) {
                teamMembers[numbersOfFinalists[i]].getMemberInfo();
            }else {
                System.out.println("Игрока с таким номером нет!");
            }
        }
    }

    public void getTeamMembersInfo() {
        System.out.println("Информация о команде "+ teamName);
        for (int i = 0; i < teamMembers.length; i++){
            teamMembers[i].getMemberInfo();
        }
        System.out.println();
    }

    public String getTeamName() {
        return teamName;
    }
}
