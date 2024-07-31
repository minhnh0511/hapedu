package com.minhnh.hapedu.domain.service;

import com.minhnh.hapedu.domain.adapter.UserAdapter;
import com.minhnh.hapedu.domain.model.User;
import com.minhnh.hapedu.shared.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserAdapter userAdapter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userAdapter.findByUsername(username);
        if(Objects.isNull(user))
            throw new UsernameNotFoundException("Cannot found user with username " + username);
        return new CustomUserDetails(user);
    }

}
