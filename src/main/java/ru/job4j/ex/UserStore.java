package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                return users[i];
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if ((user.isValid()) && user.getUsername().length() > 3) {
            return true;
        }
        throw new UserInvalidException("User not valid");
    }

    public static void main(String[] args) throws UserNotFoundException, UserInvalidException {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Asd", true),
                new User("Qwer", false)
        };
        try {
            for (int i = 0; i < users.length; i++) {
                findUser(users, users[i].getUsername());
                if (validate(users[i])) {
                    System.out.println(users[i].getUsername() + " This user has an access");
                }
            }
        } catch (UserInvalidException uie) {
            uie.printStackTrace();
        } catch (UserNotFoundException unfe) {
            unfe.printStackTrace();
        }
    }
}
