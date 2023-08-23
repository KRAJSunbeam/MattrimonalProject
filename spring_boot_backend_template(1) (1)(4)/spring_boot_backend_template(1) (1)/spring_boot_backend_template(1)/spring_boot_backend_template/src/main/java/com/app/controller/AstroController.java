package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.AstroProfile;
import com.app.service.AstroProfileService;

@RestController
@RequestMapping("/Astro")
@CrossOrigin(origins = "http://localhost:3000")
public class AstroController {
	
	  private final AstroProfileService astroProfileService;

	    @Autowired
	    public AstroController(AstroProfileService astroProfileService) {
	        this.astroProfileService = astroProfileService;
	    }

	    @PostMapping
	    public AstroProfile createAstroProfile(@Validated
	    		@RequestBody AstroProfile astroProfile) {
	        return astroProfileService.createAstroProfile(astroProfile);
	    }

	    @PutMapping("/{id}")
	    public AstroProfile updateAstroProfile(@PathVariable Long id, @Validated @RequestBody AstroProfile astroProfileRequest) {
	        return astroProfileService.updateAstroProfile(id, astroProfileRequest);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteAstroProfile(@PathVariable Long id) {
	        return astroProfileService.deleteAstroProfile(id);
	    }

	    @GetMapping("/{id}")
	    public AstroProfile fetchAstroProfileById(@PathVariable Long id) {
	        return astroProfileService.fetchAstroProfileById(id);
	    }
	
}
