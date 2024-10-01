import java.util.ArrayList;
import java.util.List;

// Employee interface
interface Employee {
    void showDetails();
}

// IndividualWorker class
class IndividualWorker implements Employee {
    private String name;
    private String position;

    public IndividualWorker(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Individual Worker: " + name + ", Position: " + position);
    }
}

// Manager class
class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> teamMembers;

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
        this.teamMembers = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        teamMembers.add(employee);
    }

    public void removeEmployee(Employee employee) {
        teamMembers.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + ", Position: " + position);
        System.out.println("Team Members:");
        for (Employee employee : teamMembers) {
            employee.showDetails();
        }
    }
}

// Main class to demonstrate the system
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create individual workers
        Employee worker1 = new IndividualWorker("Alice", "Developer");
        Employee worker2 = new IndividualWorker("Bob", "Designer");

        // Create a manager and add workers to their team
        Manager manager1 = new Manager("Charlie", "Team Lead");
        manager1.addEmployee(worker1);
        manager1.addEmployee(worker2);

        // Create another individual worker
        Employee worker3 = new IndividualWorker("David", "Tester");

        // Create another manager and add a worker to their team
        Manager manager2 = new Manager("Eve", "Project Manager");
        manager2.addEmployee(worker3);
        manager2.addEmployee(manager1); // Adding a manager to another manager's team

        // Show details
        System.out.println("Company Structure:");
        manager2.showDetails();
    }
}

