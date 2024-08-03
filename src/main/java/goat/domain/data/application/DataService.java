package goat.domain.data.application;

import goat.domain.data.domain.Data;
import goat.domain.data.dto.req.AddDataRequest;
import goat.domain.data.dto.res.DataResponse;
import goat.domain.data.exception.DataNotFoundException;
import goat.domain.data.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DataService {
    private final DataRepository dataRepository;

    public DataResponse save(AddDataRequest request) {
        Data data = Data.builder()
                .name(request.getName())
                .timestamp(request.getTimestamp())
                .data(request.getData())
                .build();
        Data savedData = dataRepository.save(data);
        return new DataResponse(savedData);
    }

    public DataResponse getLast(String name) {
        System.out.println(name);
        if (!dataRepository.existsByName(name)) {
            throw new DataNotFoundException();
        }
        Data data = dataRepository.findTopByNameOrderByIdDesc(name).get();
        return new DataResponse(data);
    }
}