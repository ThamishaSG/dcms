package com.agent.dcms;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Exception that can be thrown containing a user readable error message. This message will be
 * exposed to the DCMS.
 */
public class UserReadableErrorResponse extends RuntimeException {
  private static final Pattern CODE = Pattern.compile("^([a-z]+/)?[a-z-]+$");

  public final HttpStatus status;
  public final String message;
  public final String type;
  public final Map<String, Object> data = new HashMap<>();

  /** When you want to return a little more detail to the client to make debugging easier. */
  public static UserReadableErrorResponse badRequest(@NonNull String message) {
    return new UserReadableErrorResponse(HttpStatus.BAD_REQUEST, "bad-request", message);
  }

  /** Used when authentication fails because of invalid credentials. */
  public static UserReadableErrorResponse invalidCredentials() {
    return new UserReadableErrorResponse(HttpStatus.UNAUTHORIZED, "invalid-credentials", null);
  }

  /** Used when user try to access a resource that is forbidden for the user. */
  public static UserReadableErrorResponse accessForbidden(@NonNull String message) {
    return new UserReadableErrorResponse(HttpStatus.FORBIDDEN, "access-forbidden", message);
  }

  /**
   * Exception that is displayed to the client.
   *
   * @param status Status code to use for the response
   * @param type Error code that can be used by the client to display a translated message
   * @param message Message that is usable for debugging
   */
  private UserReadableErrorResponse(
      @NonNull HttpStatus status, @Nullable String type, @Nullable String message) {
    super(type + ": " + message);
    if (type != null && !CODE.matcher(type).matches()) {
      throw new RuntimeException("'type' can only contain lower case letters and a '-'");
    }
    this.status = status;
    this.type = type;
    this.message = message;
  }

  public UserReadableErrorResponse with(String key, Object value) {
    data.put(key, value);
    return this;
  }
}
