import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        System.out.println("Вас приветствует список покупок!");

        int listLength = 8;
        String[] shoppingList = new String[listLength];
        int productCount = 0; // переменная для подсчёта добавленных товаров
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) { //добавить товар
                if (productCount <= shoppingList.length) {
                    System.out.println("Введите товар для добавления в список покупок.");
                    String productName = scanner.next();
                    shoppingList[productCount] = productName;
                    productCount++;
                    System.out.println("Товар " + productName + " добавлен в список под номером " + productCount);
                } else {
                    System.out.println("Список заполнен! Отложите покупку до следующего раза.");
                }
            } else if (actionNumber == 2) { //показать список
                for (int i = 0; i < productCount; i++) {
                    System.out.println((i + 1) + ". " + shoppingList[i]);
                }
            } else if (actionNumber == 3) { //очистить список
                productCount = 0;
                System.out.println("Список покупок теперь пуст.");
            } else if (actionNumber == 4) { //завершить работу
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}
