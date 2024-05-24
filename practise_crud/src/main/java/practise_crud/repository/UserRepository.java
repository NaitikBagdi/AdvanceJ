package practise_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import practise_crud.model.User;

@Repository("customerRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT COUNT(c) > 0 FROM User c WHERE c.email = :email AND c.id <> :userId")
    boolean existsByEmail(@Param("email") String email, @Param("userId") Long userId);
	
	@Query("SELECT COUNT(c) > 0 FROM User c WHERE c.mobile = :mobile AND c.id <> :userId")
    boolean existsByMobileNumber(@Param("mobile") String mobileNumber, @Param("userId") Long userId);
}
