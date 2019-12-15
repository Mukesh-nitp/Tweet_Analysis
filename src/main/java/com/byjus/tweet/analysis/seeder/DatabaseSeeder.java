package com.byjus.tweet.analysis.seeder;

import com.byjus.tweet.analysis.io.entity.UserEntity;
import com.byjus.tweet.analysis.io.repository.UserRepository;
import com.byjus.tweet.analysis.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Utils utils;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
    }

    private void seedUsersTable() {
        String sql = "SELECT email FROM users U WHERE U.email = 'test@test.com' LIMIT 1";
        List<UserEntity> u = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if(u == null || u.size() <= 0) {
            UserEntity user = new UserEntity();

            user.setFirstname("Byjus");
            user.setLastname("admin");
            user.setEmail("test@test.com");
            String publicUserId = utils.generateUserId(30);
            user.setUserId(publicUserId);
            user.setEncryptedPassword(bCryptPasswordEncoder.encode("test@123"));

            userRepository.save(user);
        }
    }
}
