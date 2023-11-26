import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JavaJDBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int count = 0;
        try {
            while(flag) {


                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind", "root", "1234"
                );
                Statement statement = connection.createStatement();
                System.out.println("Ingrese la operacion a realizar:");
                String consulta = sc.nextLine();
                ResultSet resultSet = statement.executeQuery(consulta);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "
                            + resultSet.getInt(3) + " " + resultSet.getInt(4) + " "
                            + resultSet.getString(5) + " " + resultSet.getInt(6));

//                    count = count + 1;
//                    System.out.println(resultSet.getInt(count) + " ");
                }
                connection.close();
                System.out.println("Seguir?");
                String option = sc.nextLine();

                if (option.equals("No") || option.equals("no")  || option.equals("NO")  ){
                    flag = false;

                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
