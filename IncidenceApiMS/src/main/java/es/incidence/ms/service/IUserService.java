package es.incidence.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import es.incidence.ms.domain.entities.users.User;
import es.incidence.ms.utils.dtos.AdminUserDTO;
import es.incidence.ms.utils.dtos.UserDTO;

public interface IUserService {

	void updateUser(String firstName, String lastName, String email, String langKey, String imageUrl);
	
	Page<AdminUserDTO> getAllManagedUsers(Pageable pageable);
	
    Page<UserDTO> getAllPublicUsers(Pageable pageable);

    Optional<User> getUserWithAuthoritiesByLogin(String login);
    
    List<String> getAuthorities();
    
    AdminUserDTO getUserFromAuthentication(AbstractAuthenticationToken authToken);
	
}
