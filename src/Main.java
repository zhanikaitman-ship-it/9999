
public class Main {

    public static void main(String[] args) {

        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ РЕСТОРАНОМ ===");

        // 1. Создание меню
        RestaurantList menu = new RestaurantList();

        menu.add(new Dish(1, "Бешбармак", "Основное блюдо", 4500));
        menu.add(new Dish(2, "Цезарь", "Салат", 3200));
        menu.add(new Dish(3, "Лагман", "Основное блюдо", 2800));
        menu.add(new Dish(4, "Чай", "Напиток", 700));

        System.out.println("\nРазмер меню: " + menu.size());
        System.out.println("Блюдо с индексом 0: " + menu.get(0));

        // 2. Изменение цены блюда
        menu.updatePrice(3, 3000);

        System.out.println("\nПосле изменения цены лагмана:");
        System.out.println(menu.findByName("Лагман"));

        // 3. Удаление блюда
        menu.removeById(4);
        System.out.println("Размер меню после удаления чая: " + menu.size());

        // 4. Три способа перебора списка
        menu.printWithFor();
        menu.printWithForEach();
        menu.printWithIterator();

        // 5. Сортировка по цене
        menu.sortByPrice();

        System.out.println("\nМеню после сортировки:");
        menu.printWithForEach();

        // 6. Фильтрация блюд по цене
        System.out.println("\nБлюда стоимостью не выше 3500 тг:");

        for (Dish dish : menu.filterByMaxPrice(3500)) {
            System.out.println(dish);
        }

        // 7. LinkedList — история действий
        java.util.LinkedList<String> history =
                new java.util.LinkedList<>();

        history.addFirst("Открыто меню");
        history.addLast("Добавлены блюда");
        history.addLast("Изменена цена лагмана");

        System.out.println("\nИстория действий:");
        System.out.println("Первое действие: " + history.getFirst());
        System.out.println("Последнее действие: " + history.getLast());

        System.out.println("Удалено действие: " + history.removeFirst());
        System.out.println("Оставшаяся история: " + history);

        // 8. HashSet — уникальные категории
        CategorySet categorySet = new CategorySet();

        System.out.println("\nДобавление категории «Напиток»: "
                + categorySet.add("Напиток"));

        System.out.println("Повторное добавление «Напиток»: "
                + categorySet.add("Напиток"));

        categorySet.add("Салат");
        categorySet.add("Основное блюдо");

        System.out.println("Есть категория «Салат»? "
                + categorySet.contains("Салат"));

        categorySet.remove("Напиток");
        categorySet.printAll();

        // 9. Проверка equals() и hashCode()
        java.util.HashSet<Dish> uniqueDishes =
                new java.util.HashSet<>();

        uniqueDishes.add(
                new Dish(10, "Плов", "Основное блюдо", 2500)
        );

        uniqueDishes.add(
                new Dish(10, "Плов-дубликат", "Основное блюдо", 2600)
        );

        System.out.println("\nКоличество блюд с одинаковым ID: "
                + uniqueDishes.size());

        // 10. HashMap — заказы ресторана
        OrderMap orders = new OrderMap();

        orders.addOrReplace(
                101, "Айгерим — Бешбармак, 4500 тг"
        );

        orders.addOrReplace(
                102, "Данияр — Цезарь, 3200 тг"
        );

        System.out.println("\nЗаказ №101: " + orders.get(101));

        System.out.println("Существует заказ №102? "
                + orders.containsKey(102));

        // Повторный ключ заменяет старое значение
        orders.addOrReplace(
                101, "Айгерим — Бешбармак и чай, 5200 тг"
        );

        System.out.println("Обновлённый заказ №101: "
                + orders.get(101));

        orders.printAll();

        // 11. Удаление заказа
        orders.remove(102);

        System.out.println("Заказ №102 существует? "
                + orders.containsKey(102));

        System.out.println("\n=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
    }
}
