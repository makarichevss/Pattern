package HW7.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel
public class JwtRequest {
    @ApiModelProperty(notes = "Username", required = true, position = 1, example = "alan1")
    private String username;
    @ApiModelProperty(notes = "Password", required = true, position = 2, example = "123")
    private String password;

}
