import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        System.out.println("Вас приветствует список покупок!");

        int listLength = 3; //начальная длина массива
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
                /* Динамическое расширение массива для списка покупок.
                   Если массив заполнен, создается новый с длинной х2.*/
                if (productCount >= shoppingList.length) {
                    listLength *= 2;
                    String[] newShoppingList = new String[listLength];
                    for (int i = 0; i < shoppingList.length; i++) {
                        newShoppingList[i] = shoppingList[i];
                    }
                    shoppingList = newShoppingList;
                }
                System.out.println("Введите товар для добавления в список покупок.");
                String productName = scanner.next();
                /* Проверка наличия дубликата товара в массиве */
                boolean isDuplicate = false;
                for (int i = 0; i < productCount; i++) {
                    if (shoppingList[i].equals(productName)) {
                        isDuplicate = true;
                        System.out.println("Товар " + productName + " уже есть в списке под номером " + (i + 1));
                        break;
                    }
                }
                if (!isDuplicate) {
                    shoppingList[productCount] = productName;
                    productCount++;
                    System.out.println("Товар " + productName + " добавлен в список под номером " + productCount);
                }

            } else if (actionNumber == 2) { //показать список
                if (productCount == 0) {
                    System.out.println("Список покупок пуст.");
                }
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
