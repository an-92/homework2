package test.login.login2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.login.login2.domain.entity.UserEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private String email;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .email(email)
                .password(password)
                .build();
    }

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
