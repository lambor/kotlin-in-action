package ch06;

import java.util.List;

/**
 * Created by dcnh on 17-5-27.
 */
public class CollectionUtils {
   public static List<String> uppercaseAll(List<String> source) {
      for(int i=0;i<source.size();i++) {
         source.set(i,source.get(i).toUpperCase());
      }
      return source;
   }
}
