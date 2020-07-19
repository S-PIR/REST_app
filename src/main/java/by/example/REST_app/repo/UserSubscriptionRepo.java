package by.example.REST_app.repo;

import by.example.REST_app.domain.User;
import by.example.REST_app.domain.UserSubscription;
import by.example.REST_app.domain.UserSubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);
}
