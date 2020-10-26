package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import storage.UserRepo;

import java.util.Set;

@RestController
public class UsersController {


    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
        try {
            UserRepo.getInstance().setUser(userName);
        } catch (Exception e) {
            return  ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll() {
        return UserRepo.getInstance().getUsers();
    }

}
