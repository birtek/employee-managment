package pl.szydlowski.springbootcrudapi.generatedatatodb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class GenerateSQL {

    private Random random = new Random();
    private StringBuilder sb = new StringBuilder();

    public void GenerateDataToDatabase() throws IOException {
        long begin = System.nanoTime();
        GenerateEmployeeData();
        GenerateTaskData();
        GenerateEmployeeTaskData();
        long end = System.nanoTime();
        System.out.println("Time takes: " + ((end - begin) / 1_000_000_000.0) + "  s");
    }

    private void GenerateEmployeeData() throws IOException {
        clearStringBuffer(sb);
        for (int i = 1; i <= 100; i++) {
            String insert = "INSERT INTO `employee_db`.`tbl_employee` " +
                    "(`id_employee`, `name`, `last_name`, `gender`, `department`, `dob`, `phone_number`)" +
                    " VALUES ('" + i + "', 'name" + i + "', 'lastname" + i + "', 'OTHER', 'department" + i
                    + "', '" + LocalDate.now() + "', '" + generateRandomPhoneNumber() + "');" + System.lineSeparator();
            sb.append(insert);
        }
        createSqlFile(sb, "C:\\data\\employees.sql");
    }

    private void GenerateTaskData() throws IOException {
        clearStringBuffer(sb);
        for (int i = 1; i <= 10; i++) {
            String insert = "INSERT INTO `employee_db`.`tbl_task`"
                    + "(`id_task`, `description`, `begin`, `end`, `status`, `name_task`) " +
                    "VALUES ('" + i + "', 'to do sth" + i + "', '" + LocalDate.of(2011, 11, 17) + "', '" + LocalDate.now() + "', 'false', 'task" + i + "');" + System.lineSeparator();
            sb.append(insert);
        }
        createSqlFile(sb, "C:\\data\\task.sql");
    }

    private void GenerateEmployeeTaskData() throws IOException {
        clearStringBuffer(sb);
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                String insert = "INSERT INTO `employee_db`.`tbl_employee_task`" +
                        "(`id_employee`, `id_task`) VALUES ('" + i + "', '" + j + "');" + System.lineSeparator();
                sb.append(insert);
            }
        }
        createSqlFile(sb, "C:\\data\\employee_task.sql");
    }

    private void createSqlFile(StringBuilder sb, String s) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(s));
        writer.write(sb.toString());

        writer.close();
    }

    private String generateRandomPhoneNumber() {
        StringBuilder sb = new StringBuilder();
        int number;

        for (int i = 1; i <= 9; i++) {
            number = random.nextInt(9);
            while (i == 1 && number == 0) {
                clearStringBuffer(sb);
                number = random.nextInt(9);
            }
            sb.append(number);
        }
        return sb.toString();
    }

    private void clearStringBuffer(StringBuilder sb) {
        sb.delete(0, sb.length());
    }
}
