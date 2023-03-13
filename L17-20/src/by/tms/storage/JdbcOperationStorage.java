package by.tms.storage;

import by.tms.entity.Operation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOperationStorage implements OperationStorage {

    private final Connection connection;

    public JdbcOperationStorage() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "7777minsk");
            connection.createStatement().execute(
            "CREATE TABLE IF NOT EXISTS operation (\n" +
                    "    id     serial PRIMARY KEY,\n" +
                    "    num1   NUMERIC,\n" +
                    "    num2   NUMERIC,\n" +
                    "    type   TEXT,\n" +
                    "    result NUMERIC\n" +
                    ");"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Operation operation) throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into operation(num1, num2, type, result) values (?, ?, ?, ?)");
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setDouble(2, operation.getNum2());
            preparedStatement.setString(3, operation.getType());
            preparedStatement.setDouble(4, operation.getResult());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findAll() throws Exception {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from operation");
            List<Operation> operationList = new ArrayList<>();
            while (resultSet.next()) {
                double id = resultSet.getDouble(1);
                double num1 = resultSet.getDouble(2);
                double num2 = resultSet.getDouble(3);
                String type = resultSet.getString(4);
                double result = resultSet.getDouble(5);
                Operation operation = new Operation(num1, num2, type, result);
                operationList.add(operation);
            }
            return operationList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
