package products;

public interface IProductOptions<T> {

    default void getInfoAboutAnyProduct() {
        System.out.println(this);
    }
}
