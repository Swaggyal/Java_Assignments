import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class DungeonOfSyntax {
    //Global variables
        static Scanner sc = new Scanner(System.in);
        static Random rand = new Random();
        static String playerName;
        static int health = 100;
        static int gold = 50;
        static ArrayList<String> inventory = new ArrayList<>();
        static ArrayList<String> activeEffects = new ArrayList<>();

        public static void main(String[] args){
        
        System.out.print("Enter your name: ");
        playerName = sc.nextLine();

        inventory.add("sword");

        System.out.println("Welcome " +playerName+ " to Dungeon Of Syntax!!");
        System.out.println("You begin with 100 health, 50 gold, and a sword.\n");


        //While loop
        while(health > 0){
            int event = rand.nextInt(3); // 0=monster, 1=chest, 2=nothing

            if(event == 0)
            {
                battleMonster();
            }
            else if(event == 1){
                openChest();
            }
            else {
            System.out.println("Room is empty");
            }
        // Display current status
            displayStatus();

            System.out.print("\n[continue] [use item] [quit]");
            String choice = sc.nextLine().toLowerCase();

            if(choice.equals("use item")){
                useItem();
            }
            else if(choice.equals("quit")){
                System.out.println("You leave the dungeon with your loot..");
                break;
            }
    } 
    if (health <= 0) {
    System.out.println("GAME OVER! You died in the dungeon...");
}

System.out.println("Final Gold: " + gold);
System.out.println("Final Inventory: " + inventory);     
}

//Method To Battle Monsters
static void battleMonster(){
    String[] monsters = {"Orge", "Gremlin", "Goblin", "Slug"};
    String monster = monsters[rand.nextInt(monsters.length)];

    int monsterHealth = 20 + rand.nextInt(21); //20 to 40
    System.out.println("A wild " + monster + " appears! (HP: " + monsterHealth + ")");

    while(monsterHealth > 0 && health > 0){
        System.out.print("\nchoose [attack] [run]");
        String action = sc.nextLine().toLowerCase();

        if(action.equals("attack")){
            int damage = 5 + rand.nextInt(16);  //5 to 15
            if(activeEffects.contains("amulet")){
                damage += 5;
                activeEffects.remove("amulet");
                System.out.print("Your amulet is glowing!");

            }
            monsterHealth -= damage;
            System.out.println("You hit the " + monster + " and caused " + damage + " damage!");

            if(monsterHealth > 0){
                int monsterDamage = 5 + rand.nextInt(13);  //5 to 12
                if(activeEffects.contains("shield")){
                    monsterDamage /= 2;
                    activeEffects.remove("shield");
                }

                health -= monsterDamage;
                System.out.println("The " + monster + " hits you for " + monsterDamage + " damage!");

            }

        }else if(action.equals("run")){
            System.out.println("You fled from the " + monster + "!");
            return;
        }
    }
    if(health <= 0){
        System.out.println("Game over...Monster defeated you!");
        return;
    }else{
        int reward = 10 + rand.nextInt(31);  //10 to 31
        gold += reward;
        System.out.println("Victoryyy...You defeated the monster!");
    }
}

// --- Open Chest Method ---
static void openChest() {
        String[] items = {"potion", "shield", "amulet"};
        String prize = items[rand.nextInt(items.length)];

        inventory.add(prize);
        System.out.println("You found a chest containing: " + prize + "!");
    }

// --- Method to Use Item ---
static void useItem() {
    if (inventory.isEmpty()) {
        System.out.println("Your inventory is empty!");
        return;
    }

    System.out.println("Inventory: " + inventory);
    System.out.print("Choose an item to use: ");
    String item = sc.nextLine().toLowerCase();

    if (!inventory.contains(item)) {
        System.out.println("You do not have that item!");
        return;
    }

    switch (item) {
        case "potion":
            health += 20;
            inventory.remove("potion");
            System.out.println("You used a potion and restored 20 HP!");
            break;
        case "shield":
            activeEffects.add("shield");
            inventory.remove("shield");
            System.out.println("You equipped a shield for the next attack!");
            break;
        case "amulet":
            activeEffects.add("amulet");
            inventory.remove("amulet");
            System.out.println("You equipped an amulet! Next attack is stronger!");
            break;
        default:
            System.out.println("That item cannot be used.");
    }
}

// --- Show Player Status ---
static void displayStatus(){
    System.out.println("\n----- STATUS -----");
    System.out.println("Health: " + health);
    System.out.println("Gold: " + gold);
    System.out.println("Inventory: " + inventory);
    System.out.println("Active Effects: " + activeEffects);
}



}
