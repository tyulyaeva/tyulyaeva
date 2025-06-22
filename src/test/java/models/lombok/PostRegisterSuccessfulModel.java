package models.lombok;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostRegisterSuccessfulModel {
    String email, password;
}
