import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
public class parser {
    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
          ? null 
          : (s.substring(0, s.length() - 1));
    }

    public static ArrayList<ArrayList<String>> ratings() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        
        Scanner sc = new Scanner(new File("customer_ratings.xls"), "UTF-8");

        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 4; j++) {
            sc.next();
        } 

        String s1, s2;
        while (sc.hasNext()) {
            ArrayList<String> inner = new ArrayList<String>(3);
            sc.next();
            s1 = sc.next();
            inner.add(s1);
            
            inner.add(sc.next());
            sc.next();
            s2 = sc.next();
            s2 = removeLastChar(s2);
            inner.add(s2);
            /*
            Pair p = new Pair (s1,s2);
            if(!IDtitle.contains(p)) {
                arrList.add(inner);
                IDtitle.add(p);
            }
            */
            arrList.add(inner);
        }

        sc.close();
        return arrList;
    }

    public static ArrayList<ArrayList<String>> titles() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(new File("titles.xls"), "UTF-8");
        
        sc.nextLine();
        
        String s1;
        while (sc.hasNextLine()) {      
            String s = sc.nextLine();   
            
            Scanner chopper = new Scanner(s);   
            chopper.useDelimiter("\\t");
            while(chopper.hasNext())
            {
            ArrayList<String> inner = new ArrayList<String>(8);
            chopper.next();
            inner.add(chopper.next());
            inner.add(chopper.next());
            inner.add(chopper.next());
            chopper.next();
            chopper.next();
            inner.add(chopper.next());
            inner.add(chopper.next());
            inner.add(chopper.next());
            inner.add(chopper.next());
            s1 = chopper.next();
            // s1 = removeLastChar(s1);
            inner.add(s1);
            if(inner.get(1).equals("videoGame") || inner.get(1).equals("tvEpisode"))
            {
                break;
            }
            System.out.println(inner);
            arrList.add(inner);
            
            }
        }
        
        sc.close();
        return arrList;
        /*
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(new File("titles.xls"), "UTF-8");
        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 10; j++) {
            sc.next();
        }

        
        String s1;
        while (sc.hasNext()) {            
            ArrayList<String> inner = new ArrayList<String>(8);
            sc.next();
            inner.add(sc.next());
            inner.add(sc.next());
            inner.add(sc.next());
            sc.next();
            sc.next();
            inner.add(sc.next());
            inner.add(sc.next());
            inner.add(sc.next());
            inner.add(sc.next());
            s1 = sc.next();
            s1 = removeLastChar(s1);
            inner.add(s1);

            arrList.add(inner);
        }
        
        sc.close();
        return arrList;*/
    }

    public static ArrayList<ArrayList<String>> principals() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(new File("principals.xls"), "UTF-8");
        
        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 5; j++) {
            sc.next();
        }
        
        String s1, category;
        while (sc.hasNext()) {
            ArrayList<String> inner = new ArrayList<String>(5);
            // skip dummy
            sc.next();

            // title id, nconst, category, job, character
            inner.add(sc.next());
            inner.add(sc.next());


            // if category, remove everything but director, actress, actor, self, and composer
            category = sc.next();
            if (!(category.equals("director") || category.equals("actor") 
                                              || category.equals("actress") 
                                              || category.equals("self")
                                              || category.equals("composer"))) {
                sc.next();
                sc.next();
                continue;
            }
            inner.add(category);
            
            inner.add(category);
            inner.add(sc.next());
            s1 = sc.next();
            s1 = removeLastChar(s1);
            s1 = s1.replace("\"", "\'");
            inner.add(s1);

            // add inner list to outer list
            arrList.add(inner);
        }
        
        sc.close();
        return arrList;
    }

    public static ArrayList<ArrayList<String>> names() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(new File("names.xls"), "UTF-8");
        
        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 5; j++) {
            sc.next();
        }
        
        String s1;
        while (sc.hasNext()) {
            ArrayList<String> inner = new ArrayList<String>(3);
            // skip dummy
            sc.next();

            // nconst, primaryName, birthyear, deathyear, primaryprofession
            inner.add(sc.next());
            inner.add(sc.next());
            sc.next();
            sc.next();

            // primaryprofession needs to be altered maybe
            s1 = sc.next();
            inner.add(s1);

            // add inner list to outer list
            arrList.add(inner);
        }
        
        sc.close();
        return arrList;
    }

    public static ArrayList<ArrayList<String>> crew() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(new File("crew.xls"), "UTF-8");
        
        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 3; j++) {
            sc.next();
        }
        
        String s1;
        while (sc.hasNext()) {
            ArrayList<String> inner = new ArrayList<String>(3);
            // skip dummy
            sc.next();

            // add data to inner list
            inner.add(sc.next());
            inner.add(sc.next());
            s1 = sc.next();
            // s1 = removeLastChar(s1);
            inner.add(s1);

            // add inner list to outer list
            System.out.println(inner);
            arrList.add(inner);
        }
        
        sc.close();
        return arrList;
    }

    public static void main(String[] args) throws Exception {
        // ArrayList<ArrayList<String>> arrList = ratings();
        // ArrayList<ArrayList<String>> arrList = titles();
        ArrayList<ArrayList<String>> arrList = principals();
        // ArrayList<ArrayList<String>> arrList = names();
        // ArrayList<ArrayList<String>> arrList = crew();
        
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
        
        
    }
}