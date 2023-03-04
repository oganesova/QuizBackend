package com.quizz.quizPortal.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {
    private String authority;
    @Override
    public String getAuthority() {
        return this.authority;
    }

}
