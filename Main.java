import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

sealed class Parent permits Child,Child2{
    int variableParent = 10;
}
non-sealed class Child extends Parent{
    int variableChild = 20;
}
final class Child2 extends Parent{
    int variableChild2 = 30;
}
class Content implements AutoCloseable{
    public Content(){
        System.out.println("created");
    }
    public void display(){
        System.out.println("Content");
    }
    public void close(){
        System.out.println("Clear");
    }
}
class Content2 implements AutoCloseable{
    public Content2(){
        System.out.println("created2");
    }
    public void display(){
        System.out.println("Content2");
    }
    public void close(){
        System.out.println("Clear2");
    }
}




public class Main implements JavaPrivate{
    @Override
    public void multiply(int a, int b) {
        System.out.println("Answer by abstract method");
        System.out.println(a * b);
    }





    public static void main(String[] args) {

        System.out.println("---------------record----------------");
        record  Person(String name,String age){
            static  int counter;
            static void incrementCounter(){
                counter++;
            }
            Person{
                incrementCounter();
            }
        };
        Person person = new Person("Mainuddin Rizvi","22");
        Person person1 = new Person("Tom Cruise", "60");
        System.out.println(person.equals(person1));
        System.out.println(Person.counter);

        System.out.println("----------------repeat-strip-isBlank-indent-transform-stripIndent-translateEscapes-formatted string");

        String string = "\tHello Mainuddin Rizvi ";
        System.out.println(string.repeat(3));
        System.out.println(string);
        System.out.println(string.strip());
        System.out.println(string.isBlank());
        System.out.println(string.indent(10));
        String str = string.transform((s-> new StringBuilder(s).reverse().toString()));
        System.out.println(str);
















        System.out.println("-----------Unmodifiable stream-------");
        List<Integer> intList = Stream.of(3,4,2,5,4,6,7).filter(e->e%2!=0).collect(Collectors.toUnmodifiableList());
        System.out.println(intList);











        Content content = new Content();
        Content2 content2 = new Content2();
        try(content;content2){
            content.display();
            content2.display();
        }















        List<Integer> list = Arrays.asList(3,4,2,6,7,8,9);
        System.out.println("--------------use Of Method-----------");
        System.out.println(List.of(1,4,2,3,6));
        System.out.println(Set.of(4,2,3,5,6));
        System.out.println(Map.of(1,"one",2,"Two"));











        System.out.println("-----------Optional into stream-------------------------");
        list.stream().filter(i->i>3).findFirst().stream().mapMulti((number,consumer)->IntStream.rangeClosed(1,10)
                        .forEach(e->consumer.accept(e*number)))
                        .forEach(System.out::println);








        System.out.println("-----------ifPresentOrElse-------------------------");
        list.stream().filter(i->i>3).findFirst().ifPresentOrElse(System.out::println,()->System.out.println("Not Present"));

















        System.out.println("--------iterator------");
        IntStream.iterate(0,i->i<20,i->i+3).forEach(System.out::println);


        System.out.println("-----closedRange---------");
        IntStream.rangeClosed(1,5).forEach(System.out::println);




        System.out.println("-----takeWhile-----");
        list.stream().takeWhile(e->e%2==0).forEach(System.out::println);

        System.out.println("------Drop While------");
        list.stream().dropWhile(e->e%2==0).forEach(System.out::println);
        System.out.println("---------------------------------");
        JavaPrivate javaPrivate = new Main();
        javaPrivate.multiply(4,5);
        javaPrivate.addition(6,3);
    }
}