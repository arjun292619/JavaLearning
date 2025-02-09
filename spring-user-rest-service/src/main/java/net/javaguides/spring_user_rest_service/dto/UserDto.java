package net.javaguides.spring_user_rest_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "User Dto Model Information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Schema(hidden = true)
    private Long userId;
    @NotEmpty(message = "first name should not be blank or empty")
    @Schema(description = "User First Name")
    private String fname;
    @NotEmpty(message = "last name should not be blank or empty")
    @Schema(description = "User Last Name")
    private String lname;
    @Schema(description = "User Email Address")
    @Email(message = "email address should be a valid")
    private String email;
}
