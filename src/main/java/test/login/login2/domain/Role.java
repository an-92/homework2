package test.login.login2.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String value;

}
