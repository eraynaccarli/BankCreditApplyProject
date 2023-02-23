package com.eray.BankCrediProject.service;
import com.eray.BankCrediProject.model.CreditResult;
import com.eray.BankCrediProject.model.User;
import com.eray.BankCrediProject.repository.UserRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;


    @Test
    @DisplayName("Should save the movie object to database")
    public void addUser(){
        User user = new User();
        user.setId(12345);
        user.setName("Kemal");
        user.setSurname("Sunal");
        user.setBirthDate("11-08-2000");
        user.setPhoneNumber("8521251251");
        user.setTc(1221242121);
        user.setSalary(5000);
        user.setCreditScore(1600);
        user.setCreditResult(new CreditResult(1,"ONAY",1600,user));

        when(userRepository.save(any(User.class))).thenReturn(user);
        User newUser = userService.addUser(user);
        assertNotNull(newUser);
        assertThat(newUser.getName()).isEqualTo("Kemal");
    }


    @Test
    @DisplayName("Should return list of users with size 2")
    public void listUsers(){
        User user = new User();
        user.setId(12345);
        user.setName("Kemal");
        user.setSurname("Sunal");
        user.setBirthDate("11-08-2000");
        user.setPhoneNumber("8521251251");
        user.setTc(1221242121);
        user.setSalary(5000);
        user.setCreditScore(1600);
        user.setCreditResult(new CreditResult(1,"ONAY",1600,user));

        User user2 = new User(123455,1221242122,"Ali","Sunal",5000,"11-08-2000","8521251251",1600,new CreditResult(1,"ONAY",1600,user));
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);

        when(userRepository.findAll()).thenReturn(list);

        List<User> users = userService.listUser();
        assertEquals(2,users.size());
        assertNotNull(users);


    }

    @Test
    @DisplayName("Should return one user by id")
    public void getOneUserById(){
        User user = new User();
        user.setId(12345);
        user.setName("Kemal");
        user.setSurname("Sunal");
        user.setBirthDate("11-08-2000");
        user.setPhoneNumber("8521251251");
        user.setTc(1221242121);
        user.setSalary(5000);
        user.setCreditScore(1600);
        user.setCreditResult(new CreditResult(1,"ONAY",1600,user));

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        Optional<User> existingUser = userService.getOneUser(12345);
        assertNotNull(existingUser);
        assertThat(existingUser.get().getId()).isEqualTo(12345);
    }

    @Test
    @DisplayName("Should update the user into the database")
    public void updateUser(){
        User user = new User();
        user.setId(12345);
        user.setName("Kemal");
        user.setSurname("Sunal");
        user.setBirthDate("11-08-2000");
        user.setPhoneNumber("8521251251");
        user.setTc(1221242121);
        user.setSalary(5000);
        user.setCreditScore(1600);
        user.setCreditResult(new CreditResult(1,"ONAY",1600,user));

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);
        user.setName("Leman");

        User updatedUser = userService.updateUser(12345,user);

        assertNotNull(updatedUser);
        assertEquals("Leman",updatedUser.getName());

    }
}