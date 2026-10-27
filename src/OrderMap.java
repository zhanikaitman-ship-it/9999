
import java.util.HashMap;
import java.util.Map;

public class OrderMap {

    private final Map<Integer, String> orders = new HashMap<>();

    // Добавление заказа или обновление существующего
    public void addOrReplace(int orderId, String description) {
        if (orderId <= 0) {
            System.out.println("Ошибка: номер заказа должен быть положительным.");
            return;
        }

        if (description == null || description.trim().isEmpty()) {
            System.out.println("Ошибка: описание заказа не может быть пустым.");
            return;
        }

        orders.put(orderId, description);
    }

    // Получение заказа по номеру
    public String get(int orderId) {
        return orders.get(orderId);
    }

    // Удаление заказа
    public boolean remove(int orderId) {
        return orders.remove(orderId) != null;
    }

    // Проверка наличия заказа
    public boolean containsKey(int orderId) {
        return orders.containsKey(orderId);
    }

    // Вывод всех заказов через entrySet()
    public void printAll() {
        System.out.println("\nЗаказы ресторана:");

        for (Map.Entry<Integer, String> entry : orders.entrySet()) {
            System.out.println(
                    "Заказ №" + entry.getKey() +
                            ": " + entry.getValue()
            );
        }
    }
}
