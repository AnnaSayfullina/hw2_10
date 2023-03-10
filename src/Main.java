import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        /**Напишите реализации функционального интерфейса Predicate,
         которые проверяют, является ли число положительным. Если число положительное, то предикат должен возвращать true,
         в противном случае — false.
         Реализуйте Predicate в двух вариантах: через анонимный класс, через лямбду.
         */
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(-3);
        integerList.add(-5);

        for (Integer element : integerList) {
                if(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer element) {
                        return element > 0;
                    }
                }.test(element)) {
                    System.out.println(element);
                }
        }

        Predicate<Integer> predicate = el -> el > 0;
        for (Integer element : integerList) {
            if(predicate.test(element)) {
                System.out.println(element);
            }
        }

        /**Создайте функциональный интерфейс Consumer,
         который принимает на вход имя человека и выводит в консоль приветствие в его адрес.
         Реализуйте его в двух вариантах: через анонимный класс и через лямбду.
         */
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Михаил"));
        personList.add(new Person("Анна"));
        personList.add(new Person("Елена"));
        personList.add(new Person("Егор"));
        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Добрый день, " + person.getName());
            }
        };
        for (Person person: personList){
            consumer.accept(person);
        }

        Consumer<Person> consumer1 = person -> System.out.println("Добрый день, " + person.getName());
        for (Person person: personList){
            consumer1.accept(person);
        }

        /**Реализуйте функциональный интерфейс Function, который принимает на вход вещественное число типа
         Double, а возвращает его округленный вариант типа Long.
         Реализуйте его в двух вариантах: через анонимный класс и через лямбду.
         */
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(15.0);
        doubleList.add(11.5);
        doubleList.add(16.7);
        doubleList.add(29.4);

        for (Double element: doubleList){
            System.out.println(new Function<Double, Long>() {
                @Override
                public Long apply(Double aDouble) {
                    return aDouble.longValue();
                }
            }.apply(element));
        }

        Function<Double, Long> function = d -> d.longValue();
        for (Double element: doubleList){
            System.out.println(function.apply(element));
        }

        /**
         * Напишите Supplier, который возвращает случайное число из диапазона от 0 до 100.
         * Реализуйте его в двух вариантах: через анонимный класс и через лямбду.
         */
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                int a = (int) Math.floor(Math.random()*101);
                return a;
            }
        };
        System.out.println();
        System.out.println(supplier.get());
        System.out.println();

        Supplier<Integer> supplier1 = () -> (int)Math.floor(Math.random()*101);
        System.out.println(supplier1.get());


        Predicate <Integer> predicate1 = a -> a >0;
        Function<Integer, String> function1 = a -> "положительное число " + a;
        Function<Integer, String> function2 = a -> "отрицательное число " + a;
        System.out.println(ternaryOperator(predicate1,function1, function2).apply(-5));
    }
        /**Теперь попрактикуемся в комбинировании нескольких функций в одну сложную конструкцию.
         * Для примера построим следующую комбинацию. Дан предикат condition и две функции:
         ifTrue и ifFalse.
         Напишите метод ternaryOperator, который из предиката и двух функций построит новую функцию,
         возвращающую значение функции ifTrue, если предикат выполнен, а в остальных случаях — ifFalse.
         */
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        Function<T, U> function = t -> {
            if (condition.test(t)){
                return ifTrue.apply(t);
            } else {
                return ifFalse.apply(t);
            }
        };
        return  function;
    }
}