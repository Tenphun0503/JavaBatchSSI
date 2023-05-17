package hw1.topic4.p1;

public interface DatabaseConnection {
    String getConnection();
}

class OracleConnection implements DatabaseConnection{
    @Override
    public String getConnection() {
        // simulate Oracle connection initialization
        return "OracleConnection";
    }
}
class MySqlConnection implements DatabaseConnection{
    @Override
    public String getConnection() {
        // simulate MySql connection initialization
        return "MySqlConnection";
    }
}
class SqlServerConnection implements DatabaseConnection{
    @Override
    public String getConnection() {
        // simulate SqlServer connection initialization
        return "SqlServerConnection";
    }
}
