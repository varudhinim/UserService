package com.auth.userservice.Repository;

import com.auth.userservice.Models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token,String> {
    Token save(Token token);
}
