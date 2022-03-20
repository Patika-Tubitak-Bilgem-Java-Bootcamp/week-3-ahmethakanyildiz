import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Aynı isimde iki takım olamaz, BAY adında takım eklenemez.");
        int teamCount;
        String str;

        while(true){
            System.out.print("Takım sayısını giriniz: ");
            str=sc.next();
            try{
                teamCount = Integer.parseInt(str);
                if(teamCount<=1) System.out.println("Geçersiz girdi!");
                else break;
            }catch(Exception e){
                System.out.println("Geçersiz girdi!");
            }
        }

        List<String> teamList= new ArrayList<>();

        for(int i=0;i<teamCount;i++){
            while(true){
                System.out.print((i+1)+". Takım: ");
                str = sc.next();
                str=str.substring(0,1).toUpperCase()+str.substring(1).toLowerCase();
                if(teamList.contains(str)) System.out.println("Bu takım daha önceden eklenmiş!");
                else break;
            }
            teamList.add(str);
        }

        if(teamCount%2==1){
            teamList.add("BAY");
            teamCount++;
        }

        List<String> randomTeamList = new ArrayList<>();

        while (0 < teamList.size()) {
            int index = (int)(Math.random()*teamList.size());
            randomTeamList.add(teamList.get(index));
            teamList.remove(teamList.get(index));
        }

        teamList = randomTeamList;

        int round = teamCount-1;
        int matchPerRound = teamCount/2;

        LinkedHashMap<Integer, ArrayList<ArrayList<String>>> rounds = new LinkedHashMap<>();

        for (int i=0; i<round; i++) {
            rounds.put(i, new ArrayList<ArrayList<String>>());
        }

        for (int i=0; i<round; i++) {
            ArrayList<String> home = new ArrayList<>();
            ArrayList<String> away = new ArrayList<>();

            for (int j=0; j<matchPerRound; j++) {
                home.add(teamList.get(j));
                away.add(teamList.get((teamCount - 1) - j));
            }

            rounds.get(i).add(home);
            rounds.get(i).add(away);

            List<String> newTeamList = new ArrayList<>();

            newTeamList.add(teamList.get(0));
            newTeamList.add(teamList.get((teamCount - 1)));

            for (int j=1; j<teamList.size() - 1; j++) {
                newTeamList.add(teamList.get(j));
            }

            teamList = newTeamList;
        }

        System.out.println("===========Fikstür===========");

        for (int i=0; i<round*2; i++) {
            System.out.println((i + 1) + ". Hafta---------------------");
            for (int j=0; j<matchPerRound; j++) {
                if (i < round) {
                    System.out.println(rounds.get(i).get(0).get(j) + " vs " +  rounds.get(i).get(1).get(j));
                } else {
                    System.out.println(rounds.get(i-round).get(1).get(j) + " vs " +  rounds.get(i-round).get(0).get(j));
                }
            }
        }
    }
}
