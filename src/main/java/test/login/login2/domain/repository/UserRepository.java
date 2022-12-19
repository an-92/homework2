package test.login.login2.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.login.login2.domain.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String userEmail);
}
