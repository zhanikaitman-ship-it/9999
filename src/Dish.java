
import java.util.Objects;

public class Dish {
    private int id;
    private String name;
    private String category;
    private double price;

    public Dish(int id, String name, String category, double price) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID должен быть положительным.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название блюда не может быть пустым.");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Категория не может быть пустой.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной.");
        }

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым.");
        }
        this.name = name;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Категория не может быть пустой.");
        }
        this.category = category;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Блюдо{id=" + id
                + ", название='" + name
                + "', категория='" + category
                + "', цена=" + String.format("%.2f", price) + " тг}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dish)) {
            return false;
        }

        Dish other = (Dish) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
