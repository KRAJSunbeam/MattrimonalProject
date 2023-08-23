package com.app.service;

import javax.validation.Valid;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.entities.AstroProfile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface AstroProfileService {
		
	
	
	 public AstroProfile createAstroProfile(@Valid @RequestBody AstroProfile astroProfile);
	 public ResponseEntity<?> deleteAstroProfile(@PathVariable Long id);
	 public AstroProfile fetchAstroProfileById(@PathVariable Long id) ;
	public AstroProfile updateAstroProfile(Long id, @Valid AstroProfile astroProfileRequest);
}

