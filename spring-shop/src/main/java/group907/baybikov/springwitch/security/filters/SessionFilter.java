package group907.baybikov.springwitch.security.filters;

import group907.baybikov.springwitch.dto.UserDto;
import group907.baybikov.springwitch.security.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class SessionFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (authentication != null && session.getAttribute("user") == null) {
            if (authentication.getPrincipal() instanceof UserDetailsImpl) {
                UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
                session.setAttribute("user", userDetails.getUser());
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
