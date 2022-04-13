package ac.kr.kw.judge.user.repository;

import ac.kr.kw.judge.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsUserByUsername(String username);

    List<User> findUsersByUsernameIn(List<String> userNames);
}
