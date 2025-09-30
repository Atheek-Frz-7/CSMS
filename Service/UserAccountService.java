package com.csms.computer_store.Service;

import com.csms.computer_store.Entity.UserAccount;
import com.csms.computer_store.Repository.UserAccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    private final UserAccountRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserAccountService(UserAccountRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ Create user with password hashing
    @Transactional
    public UserAccount createUser(UserAccount user) {
        // Hash password before saving
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userRepo.save(user);
    }

    public Optional<UserAccount> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    public List<UserAccount> getActiveUsers() {
        return userRepo.findByActive(true);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Transactional
    public Optional<UserAccount> updateUser(UserAccount user) {
        if (!userRepo.existsById(user.getUserId())) {
            return Optional.empty();
        }
        // re-hash password if updated
        if (user.getPasswordHash() != null) {
            user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        }
        return Optional.of(userRepo.save(user));
    }

    // ✅ Secure authentication
    public boolean authenticate(String usernameOrEmail, String rawPassword, String role) {
        Optional<UserAccount> userOpt = userRepo.findByUsername(usernameOrEmail);
        if (userOpt.isEmpty()) {
            userOpt = userRepo.findByEmail(usernameOrEmail);
        }
        if (userOpt.isPresent()) {
            UserAccount user = userOpt.get();

            // Match role
            if (role != null && !role.equalsIgnoreCase(user.getRole())) {
                return false;
            }

            // Compare raw password with hashed password
            return passwordEncoder.matches(rawPassword, user.getPasswordHash());
        }
        return false;
    }
}
