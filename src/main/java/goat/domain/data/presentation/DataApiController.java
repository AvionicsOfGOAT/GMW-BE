package goat.domain.data.presentation;

import goat.domain.data.application.DataService;
import goat.domain.data.dto.req.AddDataRequest;
import goat.domain.data.dto.res.DataResponse;
import goat.domain.data.presentation.constant.ResponseMessage;
import goat.global.config.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DataApiController {

    private final DataService dataService;

    @PostMapping
    public ResponseDto<DataResponse> save(@RequestBody AddDataRequest request) {
        DataResponse response = dataService.save(request);
        return ResponseDto.of(OK.value(), ResponseMessage.SUCCESS_CREATE.getMessage(), response);
    }

    @GetMapping("/{name}")
    public ResponseDto<DataResponse> getLast(@PathVariable String name) {
        DataResponse response = dataService.getLast(name);
        return ResponseDto.of(OK.value(), ResponseMessage.SUCCESS_READ.getMessage(), response);
    }
}
