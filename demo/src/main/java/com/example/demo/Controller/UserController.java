// src/main/java/com/example/demo/controller/UserController.java
package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

import java.util.List;  // Correct import for List
import java.util.Optional;  // Correct import for Optional

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Show user form (Create)
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    // Submit user form (Create)
    @PostMapping("/submit")
    public String submitForm(@ModelAttribute User user) {
        userRepository.save(user);  // Save the user to the database
        return "redirect:/users";  // Redirect to the user list page
    }

    // Show all users (Read)
    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = userRepository.findAll();  // Fetch all users from the database
        model.addAttribute("users", users);
        return "userList";  // Show the users in the "userList.html" template
    }

//fgfdfd
    // Show user edit form (Update)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "form";  // Show the same form with the user data pre-filled
        }
        return "redirect:/users";  // If user not found, redirect to user list
    }

    // Update user (Update)
    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userRepository.save(user);  // Update the user data in the database
        return "redirect:/users";  // Redirect to the user list page after update
    }

    // Delete user (Delete)
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);  // Delete the user from the database
        return "redirect:/users";  // Redirect to the user list page
    }
}



// @Controller
// public class UserController {

//     private final UserRepository userRepository;

//     public UserController(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @GetMapping("/form")
//     public String showForm(Model model) {
//         model.addAttribute("user", new User());
//         return "form";
//     }

//     @PostMapping("/submit")
//     public String submitForm(@ModelAttribute User user) {
//         userRepository.save(user);
//         return "redirect:/userDetails"; // after submission, redirect to details page
//     }

//     @GetMapping("/userDetails")
//     public String showUserDetails(Model model) {
//         User user = userRepository.findAll().stream().findFirst().orElse(null); // Get the first user
//         model.addAttribute("user", user);
//         return "userDetails"; // display details on the new page
//     }
// }



// @Controller
// public class UserController {

//     private final UserRepository userRepository;

//     public UserController(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @GetMapping("/form")
//     public String showForm(Model model) {
//         model.addAttribute("user", new User());
//         return "form";
//     }

//     @PostMapping("/submit")
//     public String submitForm(@ModelAttribute User user) {
//         userRepository.save(user);
//         return "redirect:/users"; // redirect to show all users
//     }

//     @GetMapping("/users")
//     public String showAllUsers(Model model) {
//         model.addAttribute("users", userRepository.findAll());
//         return "users";
//     }
// }

// public class UserController {

//     private final UserRepository userRepository;

//     public UserController(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @GetMapping("/form")
//     public String showForm(Model model) {
//         model.addAttribute("user", new User());
//         // model.addAttribute("users", userRepository.findAll());

//         System.out.println(userRepository.findAll());
//         return "form";
//         // return "redirect:/form";

//     }
//     @GetMapping("/users")
// public String showAllUsers(Model model) {
//     model.addAttribute("users", userRepository.findAll());
//     return "users"; // this matches users.html
// }


//     // @PostMapping("/submit")
//     // public String submitForm(@ModelAttribute User user) {
//     //     System.out.println("User Submited the data"+user.getEmail());
//     //     userRepository.save(user);

//     //     return "redirect:/form";
        
//     // }
//     @PostMapping("/submit")
//     public String submitForm(@ModelAttribute User user) {
//     userRepository.save(user);
//     return "redirect:/users"; // show all users after save
// }


// }




