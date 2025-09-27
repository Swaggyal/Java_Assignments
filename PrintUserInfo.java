class User 
{
    int id;
    Profile profile;
    Settings settings;
}

class Profile 
{
    String username;
    String email;
}

class Settings 
{
    String theme;
    boolean notifications;
}

public class PrintUserInfo 
{
    public static void printDeets(User user) 
    {
        System.out.println("Username: " + user.profile.username);
        System.out.println("Email: " + user.profile.email);
        System.out.println("Theme: " + user.settings.theme);
    }

    public static void main(String[] args) 
    {
        Profile p = new Profile();
        p.username = "Sixtus Cobbina";
        p.email = "Six@gmail.com";

        Settings s = new Settings();
        s.theme = "dark";
        s.notifications = true;

        User u = new User();
        u.id = 1;
        u.profile = p;
        u.settings = s;

        printDeets(u);
    }
}

