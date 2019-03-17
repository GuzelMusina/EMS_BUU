package app;

import models.User;
import services.SignInServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Login: ");
        SignInServiceImpl signInService = new SignInServiceImpl();
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        String password = scanner.next();
        String action;
        Integer id;
        //User status
        User user = signInService.login(login,password);
        if(user.getStatus()){
            System.out.println("Choose your action: ");
            action = scanner.next();
            switch (action) {
                case "read":
                    //read
                    break;
                case "write":
                    //write
                    break;
                default:
                    //wrong
            }
        }
        else{
            System.out.println("Write id: ");
            id = scanner.nextInt();
            //show information
        }
    }
}

