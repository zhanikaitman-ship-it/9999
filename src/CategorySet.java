
import java.util.HashSet;
import java.util.Set;

public class CategorySet {

    private final Set<String> categories = new HashSet<>();

    // Добавление категории
    public boolean add(String category) {
        if (category == null || category.trim().isEmpty()) {
            return false;
        }

        return categories.add(category);
    }

    // Удаление категории
    public boolean remove(String category) {
        return categories.remove(category);
    }

    // Проверка существования категории
    public boolean contains(String category) {
        return categories.contains(category);
    }

    // Вывод всех категорий
    public void printAll() {
        System.out.println("\nУникальные категории меню:");

        for (String category : categories) {
            System.out.println("- " + category);
        }
    }
}
