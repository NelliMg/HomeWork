package map.service;

import map.model.Faculty;
import map.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapService {
    public static Map<Object,Integer> getMap(List students){
        HashMap<Object,Integer> map= new HashMap<Object,Integer>();
        for( Object student:students){
            if(!map.containsKey(student)){
                map.put(student,1);
            }else{
                map.put(student,map.get(student)+1);
            }
        }
        return map;
    }

    public static void printMap(Map map){
        Set<Map.Entry<Object,Integer>> set= map.entrySet();
        for(Map.Entry<Object,Integer> student:set){
            System.out.println(student.getKey()+ "  "+student.getValue());
        }
    }

    public static Map getEnumMap(List<Student> students) {
        HashMap<Faculty,Integer> map= new HashMap<Faculty,Integer>();
        for( Student student:students){
            if(!map.containsKey(student.getFaculty())){
                map.put(student.getFaculty(),1);
            }else{
                map.put(student.getFaculty(),map.get(student.getFaculty())+1);
            }
        }
        return map;
    }
}
