package goat.domain.data.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddDataRequest {
    private String name;
    private String timestamp;
    private String data;
}
