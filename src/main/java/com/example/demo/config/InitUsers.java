package com.example.demo.config;

import com.example.demo.model.Authority;
import com.example.demo.model.User;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class InitUsers implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        loadSecurityData();
    }


    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private void loadSecurityData() {

        Authority admin = authorityRepository.save(Authority.builder().role("ROLE_ADMIN").build());
        Authority user = authorityRepository.save(Authority.builder().role("ROLE_USER").build());
        Authority customer = authorityRepository.save(Authority.builder().role("CUSTOMER").build());

        userRepository.save(User.builder().username("Tobias").password(passwordEncoder.encode("hejhej"))
                .authority(admin)
                .build());

        userRepository.save(User.builder().username("Rasmus").password(passwordEncoder.encode("hejhej"))
                .authority(user)
                .build());

        userRepository.save(User.builder().username("Vibe").password(passwordEncoder.encode("hejhej"))
                .authority(customer)
                .build());

    }
}
