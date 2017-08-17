package ru.bk.rom4ik2103;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.bk.rom4ik2103.services.UserService;
import ru.bk.rom4ik2103.usersPuck.CustomUser;
import ru.bk.rom4ik2103.usersPuck.UserRole;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public CommandLineRunner demo (final UserService userService){
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception { //sha512
                userService.addUser(new CustomUser("axilon", "40a14501c3a671b08f9de4817261180099ef156a", UserRole.ADMIN));
                //password: Rr21031994
                userService.addUser(new CustomUser("user", "12dea96fec20593566ab75692c9949596833adc9", UserRole.USER));
                //password: user
            }
        };
    }
}
