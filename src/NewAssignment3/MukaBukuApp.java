package NewAssignment3;

import java.util.Scanner;

public class MukaBukuApp {
    public static void main(String[] args) {
        MukaBuku network = new MukaBuku();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== LAMAN MUKA BUKU ======");
            System.out.println("========= by HAZUAN =========");
            System.out.println("\n" +
                    "+--------+------------------+\n" +
                    "| Option |     Function     |\n" +
                    "+--------+------------------+\n" +
                    "|      1 | Create Profile   |\n" +
                    "|      2 | Delete Profile   |\n" +
                    "|      3 | Search Profile   |\n" +
                    "|      4 | Modify Profile   |\n" +
                    "|      5 | Add Friend       |\n" +
                    "|      6 | Display Profiles |\n" +
                    "|      7 | Exit             |\n" +
                    "+--------+------------------+\n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter image path: ");
                    String image = scanner.nextLine();
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    network.addProfile(name, image, status);
                    break;

                case 2:
                    System.out.print("Enter name of profile to delete: ");
                    name = scanner.nextLine();
                    network.removeProfile(name);
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();
                    Profile profile = network.findProfile(name);
                    if (profile != null) {
                        System.out.println(profile);
                        System.out.println(profile.listFriends());
                    } else {
                        System.out.println("Profile not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter name of profile to modify: ");
                    name = scanner.nextLine();
                    profile = network.findProfile(name);
                    if (profile != null) {
                        System.out.print("Enter new image path (leave blank to keep current): ");
                        image = scanner.nextLine();
                        if (!image.isEmpty()) profile.image = image;

                        System.out.print("Enter new status (leave blank to keep current): ");
                        status = scanner.nextLine();
                        if (!status.isEmpty()) profile.status = status;
                    } else {
                        System.out.println("Profile not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter your name: ");
                    String yourName = scanner.nextLine();
                    Profile yourProfile = network.findProfile(yourName);
                    if (yourProfile != null) {
                        System.out.print("Enter friend's name: ");
                        String friendName = scanner.nextLine();
                        Profile friendProfile = network.findProfile(friendName);
                        if (friendProfile != null) {
                            yourProfile.addFriend(friendProfile);
                        } else {
                            System.out.println("Friend's profile not found.");
                        }
                    } else {
                        System.out.println("Your profile not found.");
                    }
                    break;

                case 6:
                    network.displayProfiles();
                    break;

                case 7:
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}