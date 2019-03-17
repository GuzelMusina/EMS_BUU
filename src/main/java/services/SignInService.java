package services;

import models.User;

public interface SignInService {

    User login(String login, String password);

}
