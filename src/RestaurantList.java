
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RestaurantList {

    private final List<Dish> dishes = new ArrayList<>();

    // Добавление блюда
    public void add(Dish dish) {
        if (dish != null) {
            dishes.add(dish);
        }
    }

    // Получение блюда по индексу
    public Dish get(int index) {
        return dishes.get(index);
    }

    // Получение количества блюд
    public int size() {
        return dishes.size();
    }

    // Получение всего списка
    public List<Dish> getAll() {
        return new ArrayList<>(dishes);
    }

    // Изменение цены блюда по ID
    public boolean updatePrice(int id, double newPrice) {
        if (newPrice < 0) {
            return false;
        }

        for (Dish dish : dishes) {
            if (dish.getId() == id) {
                dish.setPrice(newPrice);
                return true;
            }
        }

        return false;
    }

    // Удаление блюда по ID
    public boolean removeById(int id) {
        Iterator<Dish> iterator = dishes.iterator();

        while (iterator.hasNext()) {
            Dish dish = iterator.next();

            if (dish.getId() == id) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    // Поиск блюда по названию
    public Dish findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Dish dish : dishes) {
            if (dish.getName().equalsIgnoreCase(name)) {
                return dish;
            }
        }

        return null;
    }

    // Фильтрация блюд по максимальной цене
    public List<Dish> filterByMaxPrice(double maxPrice) {
        List<Dish> result = new ArrayList<>();

        if (maxPrice < 0) {
            return result;
        }

        for (Dish dish : dishes) {
            if (dish.getPrice() <= maxPrice) {
                result.add(dish);
            }
        }

        return result;
    }

    // Сортировка блюд по цене
    public void sortByPrice() {
        Collections.sort(
                dishes,
                Comparator.comparingDouble(Dish::getPrice)
        );
    }

    // Перебор с помощью обычного for
    public void printWithFor() {
        System.out.println("\nПеребор обычным for:");

        for (int i = 0; i < dishes.size(); i++) {
            System.out.println(dishes.get(i));
        }
    }

    // Перебор с помощью for-each
    public void printWithForEach() {
        System.out.println("\nПеребор for-each:");

        for (Dish dish : dishes) {
            System.out.println(dish);
        }
    }

    // Перебор с помощью Iterator
    public void printWithIterator() {
        System.out.println("\nПеребор Iterator:");

        Iterator<Dish> iterator = dishes.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
