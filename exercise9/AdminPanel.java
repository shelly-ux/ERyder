import java.util.Scanner;

public class AdminPanel {
    private UserService userService;
    private BikeService bikeService;
    private RentalService rentalService;
    private Scanner scanner;

    public AdminPanel(UserService us, BikeService bs, RentalService rs) {
        this.userService = us;
        this.bikeService = bs;
        this.rentalService = rs;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n=== ERyder System ===");
        System.out.println("1. 注册用户");
        System.out.println("2. 查询可用单车");
        System.out.println("3. 租赁单车");
        System.out.println("4. 归还单车");
        System.out.println("5. 退出");
    }

    public void startSystem() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("输入用户名: ");
                    String uid = scanner.nextLine();
                    System.out.print("输入密码: ");
                    String pwd = scanner.nextLine();
                    if (userService.addUser(uid, pwd)) System.out.println("注册成功！");
                    else System.out.println("用户名已存在！");
                    break;
                case 2:
                    System.out.println("可用单车: " + bikeService.findAvailableBikes());
                    break;
                case 3:
                    System.out.print("输入用户名: ");
                    String u = scanner.nextLine();
                    System.out.print("输入单车ID: ");
                    String b = scanner.nextLine();
                    if (rentalService.startRental(u, b)) System.out.println("租赁成功！");
                    else System.out.println("单车不可用！");
                    break;
                case 4:
                    System.out.print("输入单车ID: ");
                    String bid = scanner.nextLine();
                    if (rentalService.endRental(bid)) System.out.println("归还成功！");
                    else System.out.println("归还失败！");
                    break;
                case 5:
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("无效输入！");
            }
        }
    }

    public static void main(String[] args) {

        BikeDatabase bikeDb = new BikeDatabase();
        ActiveRental activeRental = new ActiveRental();
        RegisteredUsers registeredUsers = new RegisteredUsers();


        UserService userService = new UserService(registeredUsers);
        BikeService bikeService = new BikeService(bikeDb);
        RentalService rentalService = new RentalService(activeRental, bikeService);


        AdminPanel panel = new AdminPanel(userService, bikeService, rentalService);
        panel.startSystem();
    }
}