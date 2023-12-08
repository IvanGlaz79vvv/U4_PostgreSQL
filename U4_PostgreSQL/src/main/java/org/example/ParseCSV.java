package org.example;

import org.apache.commons.collections.list.TreeList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseCSV {
      static HashMap<Integer, Object> map = new HashMap<>();

    public Map<Integer, Object> getParseCSV(String br) throws IOException, FileNotFoundException {
        List<String> list = new TreeList();
        String[] str = new String[0];

        list = new TreeList(Arrays.asList(br.split(";"))); //загоняем в массив
//            System.out.println("list: \n" + list.toString());
        for (int i = 0; i < list.size(); i++) {
//                System.out.println(k + " = " + list.get(k));
            map.put(i, list.get(i));
        }
        return map;
    }
}

