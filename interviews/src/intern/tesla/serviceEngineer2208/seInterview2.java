package intern.tesla.serviceEngineer2208;

import java.io.*;
import java.util.*;

import java.io.IOException;



public class seInterview2 {
    public static void main(String[] args) {
        //read the data in the CVS, and store in a List
        List<List<String>> data = readCVSFile("alters.cvs");
        //Print the top5 Alters and times
        printTopFiveAlters(data);
        //a) For each VIN in the list, all alerts triggered
        HashMap<String,Set<String>> alterWithVIN = findAlterVIN(data);
        //b) For each alert triggered, the starting and ending timestamp
        HashMap<String,List<String>> alterWithTime = findAlterWithTime(data);
        //a)Total numbers of times all alerts are triggered
        int totalNumber = getTotalAlterNumber(data);
        //b) Percentage of number of times each alert triggered to total number of strings in the list
        HashMap<String,Integer> persentage = getPercentage(data,totalNumber);
    }

    private static HashMap<String, Integer> getPercentage(List<List<String>> data, int totalNumber) {
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        HashMap<String,Integer> times = new HashMap<>();
        for(int i = 0;i<data.size();i++){
            String alter = data.get(i).get(1);
            int alterTimes = Integer.valueOf(data.get(i).get(2));
            times.put(alter, times.getOrDefault(alter,0)+alterTimes);
        }
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(times.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        //put percentage into result
        for (Map.Entry<String, Integer> en : temp.entrySet()) {
            result.put(en.getKey(),en.getValue()/totalNumber);
        }
        return result;
    }

    private static int getTotalAlterNumber(List<List<String>> data) {
        int result = 0;
        for(int i = 0;i<data.size();i++){
            result += Integer.valueOf(data.get(i).get(2));
        }
        return result;
    }

    private static HashMap<String, List<String>> findAlterWithTime(List<List<String>> data) {
        HashMap<String,List<String>> result = new HashMap<>();
        for(int i = 0;i<data.size();i++){
            String alter = data.get(i).get(0);
            String timeStamp = data.get(i).get(2);
            List<String> list = result.get(i);
            String min = Integer.valueOf(result.get(alter).get(0)) > Integer.valueOf(timeStamp) ? timeStamp :result.get(alter).get(0);
            String max = Integer.valueOf(result.get(alter).get(1)) < Integer.valueOf(timeStamp) ? timeStamp :result.get(alter).get(1);
            list.set(0,min);
            list.set(1,max);
            result.put(alter, list);
        }
        return result;
    }

    private static HashMap<String, Set<String>> findAlterVIN(List<List<String>> data) {
        HashMap<String,Set<String>> result = new HashMap<>();
        for(int i = 0;i<data.size();i++){
            String alter = data.get(i).get(1);
            String VIN = data.get(i).get(1);
            Set<String> set = result.get(alter);
            set.add(VIN);
            result.put(alter, set);
        }
        return result;
    }

    static public List<List<String>> readCVSFile(String cvsFile) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(cvsFile))) {
            String line = "";
            while (true) {
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    static public void printTopFiveAlters(List<List<String>> data){
        HashMap<String,Integer> times = new HashMap<>();
        for(int i = 0;i<data.size();i++){
            String alter = data.get(i).get(1);
            int alterTimes = Integer.valueOf(data.get(i).get(2));
            times.put(alter, times.getOrDefault(alter,0)+alterTimes);
        }
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(times.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        int i = 0;
        for (Map.Entry<String, Integer> en : temp.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
            i++;
            if(i >= 5){
                break;
            }
        }
    }
}