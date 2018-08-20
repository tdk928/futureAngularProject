package softuni.shop.future.app.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static softuni.shop.future.app.util.AppConstants.INVALID_CREDENTIALS_MESSAGE;
import static softuni.shop.future.app.util.AppConstants.RESPONDING_WITH_UNAUTHORIZED_ERROR_MESSAGE;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        logger.error(RESPONDING_WITH_UNAUTHORIZED_ERROR_MESSAGE, e.getMessage());

        httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, INVALID_CREDENTIALS_MESSAGE);

    }
}
