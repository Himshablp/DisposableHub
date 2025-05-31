package com.nexxen.identityService.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtResponse {
    private String jwtToken;
    private String username;
}
