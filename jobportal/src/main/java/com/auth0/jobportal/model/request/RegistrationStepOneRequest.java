package com.auth0.jobportal.model.request;

import static com.auth0.jobportal.constants.ApplicationConstants.ERR_MSG_INVALID_PHONE_NUMBER;
import static com.auth0.jobportal.constants.ApplicationConstants.PHONE_NUMBER_VALIDATION_REGEX;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegistrationStepOneRequest {

  @Pattern(message = ERR_MSG_INVALID_PHONE_NUMBER, regexp = PHONE_NUMBER_VALIDATION_REGEX)
  private String mobileNumber;

  @NotBlank(message = "password should not be null or blank")
  private String password;

  @NotBlank(message = "firstName should not be null or blank")
  private String firstName;

  @NotBlank(message = "lastName should not be null or blank")
  private String lastName;

}
