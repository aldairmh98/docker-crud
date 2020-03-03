/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import com.utj.pojo.Alumno;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author aldai
 */
public class Impl {

    private static boolean sayHi(Object x) {
        System.out.println("Hi");
        return true;
    }

    private static int returnSize(String word) {
        return word.length();
    }

    int i = 0;

    public static void main(String[] args) {

        MyFunctionalInterface funI = () -> System.out.println("Hi");
        funI.execute();

        Scanner sc = new Scanner(System.in);

        //Interfaz funcional
        FunctionFun funs = (String saludo) -> {
            System.out.println(saludo);
            return 0;
        };
        funs.doSomething("Hi");

        //Interfaz funcional con referencia de métodos
        FunctionFun fun = Impl::returnSize;
        System.out.println(fun.doSomething("Hello "));

        //INTERFAZ Function con Lambda
        Function<String, Integer> function = (String data) -> {
            return data.length();
        };
        System.out.println(function.apply("HelloWorld"));

        //SUPLIER: No recibe ningún párametro y retorna un dato
        Supplier<LocalDate> s1 = LocalDate::now; //Método por referencia
        LocalDate ld = s1.get();
        Supplier<String> s2 = () -> sc.next(); //LAMBDA
        String data = s2.get();

        //COMSUMER: Recibe párametro y no retorna ningún dato
        Consumer<String> printReverseString = (String dato) -> {
            StringBuilder sb = new StringBuilder(dato);
            System.out.println(sb.reverse());
        };
        printReverseString.accept(data);
        Consumer<Integer> printOppositeInt = (Integer dato) -> {
            System.out.println(-1 * dato); //LAMBDA
        };
        printOppositeInt.accept(2);

        //CREANDO NUESTRA Interfaz Generics
        FunctionIntGeneric<String, Alumno> findAlumno = (String mat) -> {
            return new Alumno();
        };
        try {
            findAlumno.returnAData("S1600");
        } catch (SQLException ex) {
            Logger.getLogger(Impl.class.getName()).log(Level.SEVERE, null, ex);
        }

        FunctionIntGeneric<Integer, ArrayList<Alumno>> findAlumnos = new DAO.DAOAlumno()::readAll;
        try {
            findAlumnos.returnAData(2);
        } catch (SQLException ex) {
            Logger.getLogger(Impl.class.getName()).log(Level.SEVERE, null, ex);
        }

        List list = Arrays.asList(2, 3, 4);
        list.stream().filter(Impl::sayHi);

        //BinaryOperator
        BinaryOperator<String> binary = (String data2, String dos) -> {
            return data2;
        };

        
    }
}
