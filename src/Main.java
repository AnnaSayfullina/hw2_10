import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    }
}