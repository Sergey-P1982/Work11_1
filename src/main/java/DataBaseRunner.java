import java.sql.*;

public class DataBaseRunner {
    private MyConnector connector = new MyConnector();

    public void run() {
        try {

            connector.stmt.addBatch("INSERT INTO tasks VALUES(9, 'Send a letter2', 1003)");
            connector.stmt.addBatch("INSERT INTO tasks VALUES(10, 'Send a letter3', 1003)");
            connector.stmt.addBatch("INSERT INTO tasks VALUES(11, 'Send a letter4', 1003)");
            int[] i = connector.stmt.executeBatch();
            ResultSet myRs = connector.stmt.executeQuery("Select * from workers");
            while (myRs.next()) {
                System.out.println("Workers: " + myRs.getString("first_name") + " "
                        + myRs.getString("last_name"));
            }
            ResultSet myRs2 = connector.stmt.executeQuery("Select * from tasks");
            while (myRs2.next()) {
                System.out.println("Tasks: " + myRs2.getString("task_descript"));
            }
            ResultSet myRs3 = connector.stmt.executeQuery("Select * from workers WHERE depNumb=20");
            while (myRs3.next()) {
                System.out.println("Workers of the dept. 20: " + myRs3.getString("first_name") + " "
                        + myRs3.getString("last_name"));
            }

            boolean addTaskResult = connector.stmt.execute("INSERT INTO tasks (taskNumb, task_descript, empNumber)" +
                    "VALUES(12, 'Send a letter2', 1003)");

            ResultSet myRs4 = connector.stmt.executeQuery("Select * from tasks WHERE empNumber=1003");
            while (myRs4.next()) {
                System.out.println("Tasks for workers 1003: " + myRs4.getString("task_descript"));
            }
            connector.dbCon.close();
            connector.closeStatement(connector.stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}

