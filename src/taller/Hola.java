/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author aldai
 */
public class Hola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // MAP
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        List square = number.stream().map(x -> x * x).collect(Collectors.toList());

        System.out.println(number.stream().reduce(0, (a, s) -> (a>s)? a:s));
        
        System.out.println(square);

        //FILTER
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List result = names.stream().filter(n -> n.contains("le")).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(result);

        //SORTED
        List result_sorted = names.stream().sorted().collect(Collectors.toList());
        
        String s = names.stream().reduce("", (antecesor,sucesor)-> antecesor+sucesor );
        System.out.println("My colorado: "+s);
        
        
        System.out.println(result_sorted);

        System.out.println("");
        names.stream().forEach(System.out::println);
    }

}
