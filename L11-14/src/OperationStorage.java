import java.util.List;
public interface OperationStorage {

    void save (Operation operation) throws Exception;

    List<Operation> findAll() throws Exception;;
}
