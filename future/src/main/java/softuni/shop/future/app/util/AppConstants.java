package softuni.shop.future.app.util;

public interface AppConstants {
    String USERNAME = "username";
    String USER_UPPERCASE = "User";
    String EMAIL = "email";

    String USER_LOWERCASE = "user";
    String ADMIN = "admin";

    String DEFAULT_PAGE_NUMBER = "0";
    String DEFAULT_PAGE_SIZE = "3"; //"30";
    String PAGE = "page";
    String SIZE = "size";
    int MAX_PAGE_SIZE = 50;
    String CREATED_AT = "createdAt";
    String UPDATED_AT = "updatedAt";
    String SPACE = " ";

    //    AUTH
    String IS_AUTHENTICATED = "isAuthenticated()";
    String IS_ADMIN = "hasRole('ROLE_ADMIN')";

    //    URLS
//    String API_URL = "/api";
    String HOME_URL = "/";
    String CREATE_URL = "/create";
    String USERS_URL = "/users";
    String ADMIN_URL = "/admin";
    String AUTH_ALL_URL = "/auth/**";
    String AUTH_URL = "/auth";
    String ALL_URL = "/**";
    String SIGNIN_URL = "/signin";
    String SIGNUP_URL = "/signup";


    String USERS_USERNAME_URL = "/users/{username}";
    String API_POLLS_URL = "/api/polls";
    String API_TAGS_URL = "/api/tags";


    String USER_ME_URL = "/user/me";
    String USERS_DELETE_ID_URL = "/users/delete/{id}";

    //    MESSAGES
    String RESPONDING_WITH_UNAUTHORIZED_ERROR_MESSAGE = "Responding with unauthorized error. Message - {}";
    String SORRY_YOU_RE_NOT_AUTHORIZED_TO_ACCESS_THIS_RESOURCE_MESSAGE = "Sorry, You're not authorized to access this resource.";
    String INVALID_CREDENTIALS_MESSAGE = "Invalid credentials.";
    String COULD_NOT_SET_USER_AUTHENTICATION_IN_SECURITY_CONTEXT_MESSAGE = "Could not set user authentication in security context";
    String AUTHORIZATION = "Authorization";
    String BEARER_ = "Bearer ";

    String POLL_CREATED_SUCCESSFULLY_MESSAGE = "Poll Created Successfully";
    String USER_REGISTERED_SUCCESSFULLY_MESSAGE = "%s registered successfully.";
    String USER_SUCCESSFULLY_BUYING_PRODUCTS_MESSAGE = "You successfully buy products.";
    String SUCCESSFULLY_ADD_PRODUCT = "Successfully added product.";
    String SUCCESSFULLY_EDITED_PRODUCT = "Successfully edited product.";
    String EMAIL_ADDRESS_ALREADY_IN_USE_MESSAGE = "Email Address already in use!";
    String PASSWORDS_MISMATCH_MESSAGE = "Passwords do not match!";
    String USERNAME_IS_ALREADY_TAKEN_MESSAGE = "Username is already taken!";
    String USER_ROLE_NOT_SET_MESSAGE = "User Role not set.";

    //    PreAuthorize params
    String HAS_ROLE_USER = "hasRole('USER_UPPERCASE')";
    String HAS_ROLE_ADMIN = "hasRole('ADMIN')";
    String HAS_ANY_ROLE_AUTH = "hasAnyRole('USER_UPPERCASE', 'ADMIN')";

    //    JWT
    String APP_JWT_SECRET = "${app.jwtSecret}";
    String APP_JWT_EXPIRATION_IN_MS = "${app.jwtExpirationInMs}";
    String INVALID_JWT_SIGNATURE = "Invalid JWT signature";
    String INVALID_JWT_TOKEN = "Invalid JWT token";
    String EXPIRED_JWT_TOKEN = "Expired JWT token";
    String UNSUPPORTED_JWT_TOKEN = "Unsupported JWT token";
    String JWT_CLAIMS_STRING_IS_EMPTY = "JWT claims string is empty.";

    //    CONSTANTS
    int ROLE_NAME_LENGH_VALUE = 20;
    String USERS = "users";
    String ROLES = "roles";
    int NAME_MAX_VALUE = 40;
    int USER_NAME_MAX_VALUE = 15;
    int EMAIL_MAX_VALUE = 40;
    //    int PASSWORD_MAX_VALUE = 100;
    String USER_ROLES = "user_roles";
    String USER_ID = "user_id";
    String ROLE_ID = "role_id";
    String USER_NOT_FOUND_WITH_USERNAME_OR_EMAIL_MESSAGE = "User not found with username or email : ";
    String BANNED_USER_MESSAGE = "User was banned from admin.";
    String ID = "id";
    int PASSWORD_MAX_VALUE = 20;
    int PASSWORD_MIN_VALUE = 6;



    int TEXT_MAX_VALUE = 40;

    String LOGGER = "logger";

    int NAME_MIN_VALUE = 4;
    int USER_NAME_MIN_VALUE = 3;
    String UUID_GENERATOR = "org.hibernate.id.UUIDGenerator";
    String UUID = "UUID";


}
