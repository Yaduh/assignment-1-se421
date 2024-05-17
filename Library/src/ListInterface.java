import java.util.List;

public interface ListInterface<T> {
    void addEntity(T entity);
    void removeEntity(T entity);
    T getEntityById(int id);
    List<T> getEntityList();
}