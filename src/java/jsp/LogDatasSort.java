//Kovács Zoltán
package jsp;

import java.util.ArrayList;
import java.util.Collections;

public class LogDatasSort {
  public static ArrayList<String[]> sort(ArrayList<String[]> list, String data, String dir) {
    if(data.equals("time")) {
      if(dir.equals("asc")) {
        Collections.sort(list,(o1, o2) -> {
          return o1[0].compareTo(o2[0]);
        });
      }
      if(dir.equals("desc")) {
        Collections.sort(list,(o1, o2) -> {
          return o2[0].compareTo(o1[0]);
        });
      }
    }
    if(data.equals("user")) {
      if(dir.equals("asc")) {
        Collections.sort(list,(o1, o2) -> {
          return o1[1].compareTo(o2[1]);
        });
      }
      if(dir.equals("desc")) {
        Collections.sort(list,(o1, o2) -> {
          return o2[1].compareTo(o1[1]);
        });
      }
    }
    if(data.equals("type")) {
      if(dir.equals("asc")) {
        Collections.sort(list,(o1, o2) -> {
          return o1[2].compareTo(o2[2]);
        });
      }
      if(dir.equals("desc")) {
        Collections.sort(list,(o1, o2) -> {
          return o2[2].compareTo(o1[2]);
        });
      }
    }
    return list;
  }
}
