package util;

import inheritanceAndPolymorphism.entitiesAbstracts.AccountAbstract;
import enumsAndComposition.EntitiesPost.Comment;
import enumsAndComposition.EntitiesPost.Post;
import enumsAndComposition.entitiesEnumsOrder.OrderStatus;
import enumsAndComposition.entitiesOrder.Client;
import enumsAndComposition.entitiesOrder.OrderItem;
import enumsAndComposition.entitiesOrder.Product;
import enumsAndComposition.entitiesWorker.Department;
import enumsAndComposition.entitiesWorker.HourContract;
import enumsAndComposition.entitiesWorker.Worker;
import enumsAndComposition.entitiesOrder.Order;
import enumsAndComposition.entitiesEnumsWorker.WorkerLevel;
import inheritanceAndPolymorphism.entitiesAbstracts.BusinessAccountAbstract;
import inheritanceAndPolymorphism.entitiesAbstracts.SavingAccountAbstract;
import inheritanceAndPolymorphism.entitiesAccount.Account;
import inheritanceAndPolymorphism.entitiesAccount.BusinessAccount;
import inheritanceAndPolymorphism.entitiesAccount.SavingsAccount;
import inheritanceAndPolymorphism.entitiesEmployee.Employee;
import inheritanceAndPolymorphism.entitiesEmployee.OutsourcedEmployee;
import inheritanceAndPolymorphism.entitiesShapes.Circle;
import inheritanceAndPolymorphism.entitiesShapes.Color;
import inheritanceAndPolymorphism.entitiesShapes.Rectangle;
import inheritanceAndPolymorphism.entitiesShapes.Shape;
import inheritanceAndPolymorphism.entitiesTax.LegalPerson;
import inheritanceAndPolymorphism.entitiesTax.PhysicalPerson;
import inheritanceAndPolymorphism.entitiesTax.Tax;

import java.awt.image.AreaAveragingScaleFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class All {


    public static void composition() throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name:");
        String workerName = sc.nextLine();
        System.out.print("Level:");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary:");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n ; i++) {

            System.out.print("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour,hours);
            worker.addContract(contract);

        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }

    public static void post () throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow that's awesome");
        Post p1 = new Post(
                sdf.parse("21/06/2018 13:05:44"),
                "Travelling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        p1.addComments(c1);
        p1.addComments(c2);

        Comment c3 = new Comment("Good night");
        Comment c4 = new Comment("May the Force be with you");
        Post p2 = new Post(
                sdf.parse("28/07/2018 23:14:19"),
                "Good night guys",
                "See you tomorrow",
                5);

        p2.addComments(c3);
        p2.addComments(c4);

        System.out.println(p1);
        System.out.println(p2);

    }

    public static void enumerationProgram () throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (dd/MM/yyyy): ");
        Date birthdate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthdate);


        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order ? ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem it = new OrderItem(productQuantity, productPrice, product);
            order.addItem(it);
        }

        System.out.println();
        System.out.print(order);



        sc.close();
    }

    public static void accountCasting() {

        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.00);

        // UPCASTING

        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.00);
        Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);

        // DOWNCASTING

        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

        //BusinessAccount acc5 = (BusinessAccount) acc3;

        if(acc3 instanceof BusinessAccount){
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }
        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

    }

    public static void accountOverlap() {



        Account acc1 = new Account(1001, "Alex", 1000.0);
        acc1.withdraw(200.0);
        System.out.println(acc1.getBalance());

        Account acc2 = new SavingsAccount(1002, "Bob", 1000.0, 0.01);
        acc2.withdraw(200.0);
        System.out.println(acc2.getBalance());

        Account acc3 = new BusinessAccount(1003, "Maria", 1000.00, 500.0);
        acc3.withdraw(200.0);
        System.out.println(acc3.getBalance());
        
    }

    public static void employeePayment() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();


        System.out.print("Enter the number of employee: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("Employee# " + i + " data:");
            System.out.print("Outsourced(y/n)?");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (ch == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                list.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("PAYMENT: ");
        for(Employee emp : list){
            System.out.println(emp.getName() + " - $" + String.format("%.2f",emp.payment()));
        }

        sc.close();

    }

    public static void abstractClasses() {

        List<AccountAbstract> list = new ArrayList<>();

        list.add(new SavingAccountAbstract(1000, "Maria", 500.00, 0.01));
        list.add(new BusinessAccountAbstract(1001, "Bob", 1000.00, 400.00));
        list.add(new SavingAccountAbstract(1002, "Alex", 300.00, 0.01));
        list.add(new SavingAccountAbstract(1003, "Anna", 500.00, 500.00));

        double sum = 0.0;
        for (AccountAbstract abs : list) {
            sum += abs.getBalance();
        }
        System.out.println("Total balance: %.2f\n");

        for(AccountAbstract abs : list) {
            abs.deposit(10.0);
        }
        for(AccountAbstract abs : list) {
            System.out.println(abs.getBalance());
        }
    }

    public static void abstractMethods() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Shape> list = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n ; i++) {

            System.out.println("Shape #" + i + " data: ");
            System.out.print("Rectangle os Circle (r/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());

            if(ch == 'r') {
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();

                list.add(new Rectangle(color, width, height));
            } else {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                list.add(new Circle(color, radius));
            }

            System.out.println("SHAPE AREAS: ");
            for(Shape shape : list) {
                System.out.println(String.format("%.2f", shape.area()));
            }

        }


        sc.close();

    }

    public static void abstractTax() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);

        List<Tax> list = new ArrayList<>();

        System.out.print("Enter the number of contributors: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i ++) {

            sc.nextLine();
            System.out.print("Physical person or Legal person ? (p/l)");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double income = sc.nextDouble();

            if (ch == 'p') {

                System.out.print("Health expenditure:");
                double healthExpenses = sc.nextDouble();

                list.add(new PhysicalPerson(name, income, healthExpenses));
            } else if (ch == 'l') {

                System.out.print("Number of employees: ");
                Integer employee = sc.nextInt();

                list.add(new LegalPerson(name, income, employee));
            }

        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        for (Tax tax : list) {

            System.out.println(tax.toString());
        }

        System.out.println();
        double sum = 0;
        for(Tax tax : list) {
            sum += tax.totalTax();
        }
        System.out.println(String.format("%.2f", sum));



    }



}
