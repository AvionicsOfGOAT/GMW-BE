package goat.domain.data.dto.res;

import goat.domain.data.domain.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataResponse {
    private String name;
    private String timestamp;
    private String data;

    @Builder
    public DataResponse(Data dataSource) {
        name = dataSource.getName();
        timestamp = dataSource.getTimestamp();
        data = dataSource.getData();
    }
}
