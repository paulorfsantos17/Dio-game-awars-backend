package dio.me.diogameawards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import dio.me.diogameawards.service.exception.BusinessException;
import dio.me.diogameawards.service.exception.NoContentException;

@RequestMapping("/api")
public abstract class BaseRestController {

  @ExceptionHandler(NoContentException.class)
  public ResponseEntity<Void> handleNoContent(NoContentException e) {
    return ResponseEntity.noContent().build();
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ApiErrorDTO> handleBusinessException(BusinessException e) {
    return ResponseEntity.badRequest().body(new ApiErrorDTO(e.getMessage()));
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<ApiErrorDTO> handleUnexpetedException(BusinessException e) {
    return ResponseEntity.internalServerError().body(new ApiErrorDTO("Ocorreu um erro inesperado!"));
  }

  
}
