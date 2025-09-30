package com.csms.computer_store.Repository;

import com.csms.computer_store.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    // Find by email (for login or validation)
    Optional<UserAccount> findByEmail(String email);

    // Find by username
    Optional<UserAccount> findByUsername(String username);

    // Find all active users
    List<UserAccount> findByActive(boolean active);

    // Find by role (e.g., SALE_MANAGER, CUSTOMER)
    List<UserAccount> findByRole(String role);
}
