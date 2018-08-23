package app.model;

import app.security.UserPrincipal;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

class AuditorAwareImpl implements AuditorAware<Integer> {

    @Autowired
    UserService userService;

    @Override
    public Optional<Integer> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
            return Optional.empty();
        }

        UserPrincipal loginedUser = (UserPrincipal) authentication.getPrincipal();

        return Optional.ofNullable(loginedUser.getId());

    }
}