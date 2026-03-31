import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static ArrayList<User> userlist = new ArrayList<>();
    static HashMap<Integer, User> usermap = new HashMap<>();

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        while(true)
        {
            System.out.println("1. Add Users");
            System.out.println("2. View Users");
            System.out.println("3. Update Users");
            System.out.println("4. Delete Users");
            System.out.println("5. Exit");

            int choice = scan.nextInt();

            switch(choice){
                case 1:
                    addUser(scan);
                    break;
                case 2:
                    viewUsers();
                    break;
                case 3:
                    updateUser(scan);
                    break;
                case 4:
                    deleteUser(scan);
                    break;
                case 5:
                    return;
            }

        }

    }

    public static void addUser(Scanner scan)
    {
        System.out.println("Enter user id : ");
        int idscan = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter user name : ");
        String name = scan.nextLine();

        System.out.println("Enter user email : ");
        String email = scan.nextLine();

        User user = new User(idscan, name, email);

        userlist.add(user);
        usermap.put(idscan,user);

        System.out.println("User added");
    }

    public static void viewUsers()
    {
        for (User user : userlist)
        {
            System.out.println(user.getId()+" "+user.getName()+" "+user.getEmail());
        }
    }

    public static void updateUser(Scanner scan)
    {
        System.out.println("Enter user id to be updated : ");
        int id = scan.nextInt();

        if(usermap.containsKey(id))
        {
            User user = usermap.get(id);

            System.out.println("Enter new name : ");
            user.setName(scan.nextLine());

            System.out.println("Enter new email : ");
            user.setEmail(scan.nextLine());

            System.out.println("User udpated successfully!");
        }
        else
        {
            System.out.println("User not found!");
        }
    }

    public static void deleteUser(Scanner scan)
    {
        System.out.println("Enter the user id to be deleted : ");
        int id = scan.nextInt();

        if(usermap.containsKey(id))
        {
            User user = usermap.get(id);

            userlist.remove(user);
            usermap.remove(id);

            System.out.println("User deleted!");
        }
        else
        {
            System.out.println("User not found");
        }
    }

}
