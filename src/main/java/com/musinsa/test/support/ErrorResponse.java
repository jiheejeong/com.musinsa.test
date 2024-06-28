package com.musinsa.test.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
  private int status;                 // 에러 상태 코드
  private String resultMsg;           // 에러 메시지
  private List<FieldError> errors;    // 상세 에러 메시지

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class FieldError {
    private String field;
    private String message;
  }
}
