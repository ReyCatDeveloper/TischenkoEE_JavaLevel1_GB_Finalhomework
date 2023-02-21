package lesson1;

import java.util.ArrayList;

public class Course {
    private Barrier[] barriers;
    private String courseName;
    private Boolean[][] resultTable;
    private int[] finalists;

    Course(String courseName, Barrier[] barriers){
        this.courseName = courseName;
        this.barriers = barriers;
    }

    public int[] tryTheBarrier(Team team){
        System.out.printf("Команда %s пытается преодолеть полосу препятствий %s\n\n", team.getTeamName(),courseName);
        System.out.println("ХОД СОРЕВНОВАНИЯ:");
        //ТАБЛИЦА РЕЗУЛЬТАТОВ
        resultTable = new Boolean[team.getTeamMembers().length][barriers.length];

        for(int i = 0; i < team.getTeamMembers().length; i++){
           // System.out.printf("игрок %s пытается преодолеть %s", team.getTeamMembers()[i].getMemberName(),);
            for (int j = 0; j < barriers.length; j++){
                System.out.printf("игрок %s пытается преодолеть %s   ", team.getTeamMembers()[i].getMemberName(),barriers[j].getType().getName());
                //попытка i-участником пересечь j-барьер
                Boolean currentResult = team.getTeamMembers()[i].tryTheBarrier(barriers[j]);
                resultTable[i][j] = currentResult;
                if(currentResult == true){
                    System.out.println("...справился!");
                }else {
                    System.out.println("...неудача");
                }
            }
        }
        System.out.println();

        //ПОИСК ФИНАЛИСТОВ
        int countFinalists = 0;
        //подсчитать финалистов
        for(int i = 0; i < resultTable.length; i++){
            boolean currentMemberWinStatus = true;

            for (int j = 0; j < resultTable[i].length; j++){
                if(resultTable[i][j] == false){
                    currentMemberWinStatus = false;
                    break;
                }
            }
            if(currentMemberWinStatus == true){
                System.out.printf("игрок %s выходит в финал! \n",team.getTeamMembers()[i].getMemberName());
                countFinalists++;
            }else {
                System.out.printf("игрок %s выбывает! \n",team.getTeamMembers()[i].getMemberName());
            }
        }
        System.out.println();

        System.out.println("Количество финалистов: "+countFinalists);

        finalists = new int[countFinalists];
        //записать номера финалистов
         //TODO надо решить проблему с повторяющимися значениями
        int oneOfFinalists = 0;
            for(int i = 0; i < resultTable.length; i++){

                boolean currentMemberWinStatus = true;
                for (int j = 0; j < resultTable[i].length; j++){
                    if(resultTable[i][j] == false){
                        currentMemberWinStatus = false;
                        break;
                    }
                }
                if(currentMemberWinStatus == true){
                //    System.out.printf("игрок %s записывается в финалисты! \n",team.getTeamMembers()[i].getMemberName());
                    finalists[oneOfFinalists] = i;
                    oneOfFinalists++;
                }
            }

            for(int i =0; i < finalists.length;i++){
                System.out.println(finalists[i]);
            }

        return finalists;

    }
}
