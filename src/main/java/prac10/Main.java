package prac10;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> nam=new ArrayList<>();
        ArrayList<ArrayList<Integer>>allMarks=new ArrayList<>();
        ArrayList<Double> avgs=new ArrayList<>();
        ArrayList<Boolean>failing=new ArrayList<>();
        try{
            BufferedReader buffy= Files.newBufferedReader(Paths.get("students.txt"));
            String line;
            while ((line=buffy.readLine())!=null){
                line=line.trim();
                if (line.isEmpty())continue;
                String[]parts=line.split("\\s+");
                int firgradein=-1;
                for (int i=0;i< parts.length;i++){
                    if (parts[i].matches("\\d+")){
                        firgradein=i;
                        break;
                    }
                }
                String name="";
                for (int i=0;i<firgradein;i++){
                    name +=parts[i];
                    if (i<firgradein-1) name+="";
                }
                ArrayList<Integer> marks=new ArrayList<>();
                for (int i=firgradein;i< parts.length;i++){
                    marks.add(Integer.parseInt(parts[i]));
                }
                int sum=0;
                boolean hasfail=false;
                for (int m:marks){
                    sum +=m;
                    if (m<4)hasfail=true;
                }
                double avg=(double) sum/marks.size();

                nam.add(name);
                allMarks.add(marks);
                avgs.add(avg);
                failing.add(hasfail);
            }
        }catch (Exception e){
            System.out.println("file not readen: "+e.getMessage());
        }
        try {
            PrintWriter priwi=new PrintWriter(Files.newBufferedWriter(Paths.get("output.txt")));
            priwi.println("name,marks,avg,failing");
            for (int i=0;i<nam.size();i++){
                String marksstr="";
                for (int m:allMarks.get(i)){
                    marksstr += m+" ";
                }
                marksstr=marksstr.trim();
                priwi.println(nam.get(i)+","+marksstr+","+String.format("%.2f", avgs.get(i))+","+failing.get(i));
            }
            priwi.close();
            System.out.println("output.txt created");
        }catch (Exception e){
            System.out.println("writing error: "+e.getMessage());
        }
    }

}
