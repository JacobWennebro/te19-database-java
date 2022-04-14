public class Controller {

    public static void main(String[] args) {
        EnvVar env = new EnvVar("env");
        DatabaseConnector db = new DatabaseConnector(env);

        System.out.println(db.getDatabaseContent());

    }

}
