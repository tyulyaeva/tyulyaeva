package models.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateUserModels {
    String name, job, year;
}
