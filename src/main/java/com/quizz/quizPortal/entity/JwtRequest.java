package com.quizz.quizPortal.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    String username;
    String password;

}
