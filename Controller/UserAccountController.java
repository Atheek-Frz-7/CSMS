package com.csms.computer_store.Controller;

import com.csms.computer_store.Entity.UserAccount;
import com.csms.computer_store.Service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/it/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserAccount> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/active")
    public List<UserAccount> getActiveUsers() {
        return userService.getActiveUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccount> updateUser(@PathVariable Long id, @RequestBody UserAccount user) {
        user.setUserId(id);
        Optional<UserAccount> updated = userService.updateUser(user);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        @RequestParam("role") String role) {
        boolean authenticated = userService.authenticate(username, password, role);
        if (authenticated) {
            return ResponseEntity.ok("Login successful! Role: " + role);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials or role.");
        }
    }
}
