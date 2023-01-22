public interface OperationStorage {
    Operation[] findAll();
    void save (Operation operation);
}
