import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class javaStreams14 {

    //Count the number of names starting with alphabet A in the list
    @Test
   public void Regular()
    {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Atanu");
        names.add("Rahul");
        names.add("Anup");
        names.add("sujoy");
        names.add("Anil");
        int count =0;
        for(int i=0;i<names.size();i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }
        }
            System.out.println(count);
        }
//Stream function
@Test
        public void regular(){
    ArrayList<String> name = new ArrayList<String>();
    name.add("Sujoy");
    name.add("Subhas");
    name.add("Atrt");
    name.add("Subhra");

    Long c = name.stream().filter(s -> s.startsWith("S")).count();
    System.out.println(c);
}

//More Short way
    @Test
    public void regular2(){
       long d= Stream.of("Amit","Riju","Suman","Anil").filter(s ->
        {s.startsWith("A");
        return true;

    }).count();
        System.out.println(d);

        //Print all the name of the array list
Stream.of("Sumi","Rupa","Shibam","Sayan","Atanu").filter(s -> s.length()>4).forEach(s ->System.out.println(s));

}

       //Map Function // Print names which have last later y with uppercase
@Test
    public void regular3(){
        Stream.of("Ayan","Sanjay","Amit","Atanu").filter(s -> s.endsWith("y")).map(s ->s.toUpperCase()).forEach(s ->System.out.println(s));

        //Print names which have first letter as a with uppercase and sorted
      Stream.of("pzjush","Milan","pobert","jimmy").filter(z -> z.startsWith("p")).sorted().map(z ->z.toUpperCase()).forEach(z ->System.out.println(z));

      //Merging two different array list and Print
    List<String>  list1= Arrays.asList("Ayan","Sanjay","Amit","Atanu");
    List<String> list2= Arrays.asList("pzjush","Milan","pobert","jimmy");
    Stream<String> list3 =Stream.concat(list1.stream(),list2.stream());
    list3.sorted().forEach(s ->System.out.println(s));
}

//Check Name Match in the list or not return true or false
    @Test
        public void regular4(){
        List<String> lists = Arrays.asList("Ayan","Sanjay","Amit","Atanu");
       boolean flag = lists.stream().anyMatch(s -> s.equalsIgnoreCase("Ayan"));
       System.out.println(flag);
        Assert.assertTrue(flag);

    }

}




