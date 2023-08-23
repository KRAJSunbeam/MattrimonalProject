package com.app.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.custexception.ResourceNotFoundException;
import com.app.dao.AstroProfileDao;
import com.app.dao.UserDao;
import com.app.entities.AstroProfile;
import com.app.entities.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class AstroProfileServiceImpl implements AstroProfileService {

	@Autowired
	private AstroProfileDao astroDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	    public AstroProfile createAstroProfile(@Valid @RequestBody AstroProfile astroProfile) {
	        return astroDao.save(astroProfile);
	    }
	@Override
	    public AstroProfile updateAstroProfile(@PathVariable Long id,
	                                   @Valid @RequestBody AstroProfile astroProfileRequest) {
	        return astroDao.findById(id)
	                .map(astroProfile -> {
	                	astroProfile.setId(id);
	               
	                	astroProfile.setReligion(astroProfileRequest.getReligion());
	                	astroProfile.setCaste(astroProfileRequest.getCaste());
	                	astroProfile.setSubCaste(astroProfileRequest.getSubCaste());
	                	astroProfile.setRaasi(astroProfileRequest.getRaasi());
	                	astroProfile.setRaasi(astroProfileRequest.getCharan());
	                	astroProfile.setRaasi(astroProfileRequest.getNakshatra());
	                	astroProfile.setRaasi(astroProfileRequest.getGan());
	                	astroProfile.setRaasi(astroProfileRequest.getNadi());
	                	astroProfile.setMangal(astroProfileRequest.isMangal());
	                	astroProfile.setManglik(astroProfileRequest.isManglik());
	                	if(userDao.existsById(id)) {
	                		Optional<User> user = userDao.findById(id);
	                		if(user.isPresent()) {
	                			astroProfile.setUser(user.get());
	                		}
	                	}
	                	return astroDao.save(astroProfile);
	                }).orElseThrow(() -> new ResourceNotFoundException("AstroProfile not found with"));
	    }
	@Override
	    public ResponseEntity<?> deleteAstroProfile(@PathVariable Long id) {
	        return astroDao.findById(id)
	                .map(astroProfile -> {
	                    astroDao.delete(astroProfile);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("AstroProfile not found with"));
	    }
	@Override
		public AstroProfile fetchAstroProfileById(@PathVariable Long id) {
			return astroDao.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("AstroProfile not found with "));
		}
	
}
