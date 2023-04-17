package by.tms.storage;

import by.tms.entity.Operation;
import by.tms.entity.OperationType;
import by.tms.util.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcOperationStorage implements OperationStorage {
    private static JdbcOperationStorage instance;
    private final List<String> tables = new ArrayList<>();
    private static final String SELECT_USER_OPERATIONS = " where userid = ?";
    private static final String WRITE_OPERATION = " (num1, type, num2, result, userid) values (?, ?, ?, ?, ?)";

    private JdbcOperationStorage() {
        tables.add("operation_sum");
        tables.add("operation_sub");
        tables.add("operation_mul");
        tables.add("operation_div");
    }

    public static JdbcOperationStorage getInstance() {
        if (instance == null) {
            instance = new JdbcOperationStorage();
        }
        return instance;
    }

    @Override
    public void save(Operation operation) {
        Connection postgresConnection = ConnectionJDBC.getPostgresConnection();
        String table = "operation_" + String.valueOf(operation.getType()).toLowerCase();
        try {
            PreparedStatement preparedStatement = postgresConnection.prepareStatement("insert into " + table + WRITE_OPERATION);
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setString(2, String.valueOf(operation.getType()));
            preparedStatement.setDouble(3, operation.getNum2());
            preparedStatement.setDouble(4, operation.getResult());
            preparedStatement.setInt(5, operation.getUserId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findByUserId(int userId) {
        Connection postgresConnection = ConnectionJDBC.getPostgresConnection();
        List<Operation> operationList = new ArrayList<>();

        for (String table : tables) {
            try {
                PreparedStatement preparedStatement = postgresConnection.prepareStatement("select * from " + table + SELECT_USER_OPERATIONS);
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    double num1 = resultSet.getDouble("num1");
                    double num2 = resultSet.getDouble("num2");
                    OperationType type = OperationType.valueOf(resultSet.getString("type"));
                    double result = resultSet.getDouble("result");
                    Operation operation = new Operation(id, num1, num2, type, result, userId);
                    operationList.add(operation);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        Collections.sort(operationList);
        return operationList;
    }
}
