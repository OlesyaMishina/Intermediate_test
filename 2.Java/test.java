
import java.util.Random;
import java.util.stream.IntStream;
public class test {
    public static void main(String[] a) {
        int[] number = new int[] {0, 1,  23, 456, 7890, 12345}; // Числа
        int[] chance = new int[] {0, 50, 1, 1,    1,    10   }; // Количество
        int count = IntStream.of(chance).sum(); // Считаем количество элементов воображаемого массива
        System.out.println(count);
        // Вывод вероятностей:
        for (int i = 0; i < chance.length; i++) {
            System.out.println("Вероятность числа \"" + number[i] + "\":  \t" + (chance[i]*100d/count) + "%");
        }
        
        // Генерация случайного числа
        Random random = new Random();
        for (int randomNumsCount = 0; randomNumsCount < 10; randomNumsCount++) {
            int index = random.nextInt(count); // Выбираем случайный индекс из воображаемого массива
            for (int i = 0; i < chance.length; i++) { // Ищем элемент, которому принадлежит этот индекс
                index -= chance[i];
                if(index < 0) {
                    System.out.println("Случайное число: " + number[i]);
                    break;
                }
            }
        }
    }
}
