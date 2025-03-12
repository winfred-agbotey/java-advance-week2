//package com.mawulidev.userservice.seeders;
//
//import com.mawulidev.userservice.models.Role;
//import com.mawulidev.userservice.models.User;
//import com.mawulidev.userservice.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class SeedDataServiceImpl implements SeedDataService {
//    private final UserRepository userRepository;
////    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public void seedDatabase() {
//        Optional<User> existingUser = userRepository.findUsersByEmail("mawulidev@gmail.com");
//        if (existingUser.isEmpty()) {
//            User user = User.builder()
//                    .username("mawulidev")
//                    .email("mawulidev@gmail.com")
//                    .password("mawulidev")
//                    .role(Role.USER)
//                    .build();
//
//            userRepository.save(user);
//        }
//    }
//}
