import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {
    }

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();
    }

    @Override
    public String toString() {
        return "EmployeePayrollService{" +
                "employeePayrollList=" + employeePayrollList +
                '}';
    }

    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter the employee id : ");
        int id = consoleInputReader.nextInt();

        System.out.println("Enter the Employee name : ");
        String name = consoleInputReader.next();

        System.out.println("Enter the Employee salary : ");
        Double salary = consoleInputReader.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    private void writeEmployeePayrollData() {
        System.out.println("Writing Employee Payroll Data to console. " + employeePayrollList);
    }
}

