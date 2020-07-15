package by.example.REST_app.service;

import by.example.REST_app.domain.User;
import by.example.REST_app.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileService {
    private final UserDetailsRepo userDetailsRepo;

    @Autowired
    public ProfileService(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }


    public User changeSubscription(User channel, User subscriber) {
        Set<User> subscribers = channel.getSubscribers();
        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        } else {
            subscribers.add(subscriber);
        }
        return userDetailsRepo.save(channel);

    }
}
