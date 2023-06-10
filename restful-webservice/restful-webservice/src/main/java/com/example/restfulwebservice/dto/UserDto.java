package com.example.restfulwebservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(
        description = "UserDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private Long id;

    //user firstname should bot be null or empty
    @Schema(
            description = "User First Name"
    )
    @NotEmpty(message = "User firstName should bot be null or empty")
    private String firstName;
    //user lastname should bot be null or empty
    @Schema(
            description = "User Last Name"
    )
    @NotEmpty(message = "User lastName should bot be null or empty")
    private String lastName;
    //emaile should not be null or empty
    //email should  be valid
    @Schema(
            description = "User Email Address"
    )
    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "email address should be valid")
    private String email;
}
