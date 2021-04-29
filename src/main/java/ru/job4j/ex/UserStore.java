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

//    public static boolean validate(User user) throws UserInvalidException {
//        char[] chars = user.getUsername().toCharArray();
//     //   if (chars.length <= 3) {
//        // дописать!!!!!!!!!!!!!!!!!!!!!
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        User[] users = {
//                new User("Petr Arsentev", true)
//        };
////        User user = findUser(users, "Petr Arsentev");
////        if (validate(user)) {
////            System.out.println("This user has an access");
////        }
//    }
}
