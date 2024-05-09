import java.util.Scanner;
public class TextAdventureGame {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Welcome to the Text Adventure Game!");
System.out.println("You wake up in a mysterious room. What do you 
do?");
System.out.println("1. Look around");
System.out.println("2. Go back to sleep");
int choice = getUserChoice(scanner, 1, 2);
if (choice == 1) {
System.out.println("You look around and find a key. What do you 
do?");
System.out.println("1. Pick up the key");
System.out.println("2. Ignore the key");
choice = getUserChoice(scanner, 1, 2);
if (choice == 1) {
System.out.println("You picked up the key. You notice a locked 
door. What do you do?");
System.out.println("1. Try the key on the door");
System.out.println("2. Look for another way out");
choice = getUserChoice(scanner, 1, 2);
if (choice == 1) {
System.out.println("The key fits! You escape the room and 
win the game.");
} else {
System.out.println("You search for another way out but 
find none. You are trapped forever.");
}
} else {
System.out.println("You ignore the key and sit down. Nothing 
happens.");
}
} else {
System.out.println("You go back to sleep and dream of better days. 
The end.");
}
scanner.close();
}
private static int getUserChoice(Scanner scanner, int minChoice, int
maxChoice) {
int choice;
do {
System.out.print("Enter your choice: ");
while (!scanner.hasNextInt()) {
System.out.println("Invalid input. Please enter a number.");
scanner.next();
}
choice = scanner.nextInt();
if (choice < minChoice || choice > maxChoice) {
System.out.println("Invalid input. Please enter a valid 
choice.");
}
} while (choice < minChoice || choice > maxChoice);
return choice;
}