package demo.utils;

public final class Constants {
    private Constants(){}

    public final static String PRICE_ERR = "Wrong price format";
    public final static String ID_ERR_MSG = "Wrong id.";
    public final static String DATA_ABSENT_MSG = "\n>> No data!";
    public final static String DATA_INSERT_MSG = "\n>> Created.";
    public final static String DATA_UPDATE_MSG = "\n>> Updated.";
    public final static String DATA_DELETE_MSG = "\n>> Deleted.";
    public final static String APP_CLOSE_MSG = "\n>> App closed.";
    public final static String INPUT_REQ_MSG = "Input required.";
    public final static String INCORRECT_VALUE_MSG = ">> Incorrect value! Try again...";
    public final static String SMTH_WRONG_MSG = "\n>> Something wrong.";
    public static final String URL = "jdbc:mysql://localhost:3306/demo_db?";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_USER = "dev";
    public static final String DB_PASS = PassReader.readPass();
}
