package com.company.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.company.model.Skill;
import com.company.model.User;
import com.company.repository.SkillRepository;
import com.company.repository.UserRepository;

@Controller
public class SkillController {

	@Autowired
	private SkillRepository skillRepo;

	@Autowired
	private UserRepository userRepo;

	//==================================
	//----------------------------------
	public String getskillname(int id) {

		Skill s = skillRepo.getById(id);

		String sname = s.getSkillName();

		return sname;

	}

	public String getuserunsur(int id) {
		
		User u = userRepo.getById(id);

		String uname = u.getName();
		String usurname = u.getSurname();

		String unsur = uname + " " + usurname;
		
		return unsur;

	}
	
	public String getuseremail(int id) {
		User u = userRepo.getById(id);
		
		String s = u.getEmail();
		
		return "Email: "+s.toLowerCase();
	}
	
	public String getuserphone(int id) {
		
		User u = userRepo.getById(id);
		
		String s = u.getPhone();
		
		return "Phone: "+s;
		
	}
	
	public String getusertitle(int id) {
		User u = userRepo.getById(id);
		
		String s = u.getTitle();
		
		return s;
	}
	
	public String getuserloc(int id) {
		User u = userRepo.getById(id);
		
		String s = u.getLocation();
		
		return s;
	}
	
	public String getuserlink(int id) {
		User u = userRepo.getById(id);
		
		String s = u.getLinkedin();
		
		return s;
	}
    //----------------------------------------
	//========================================
	
	@GetMapping("/")
	public String res(Model model) {

		for (int i = 1; i <= 8; i++) {

			String skname = getskillname(i);

			model.addAttribute("s" + i + "name", skname);

		}

		model.addAttribute("unsur", getuserunsur(1));
		model.addAttribute("uemail", getuseremail(1));
		model.addAttribute("uphone", getuserphone(1));
		model.addAttribute("utitle", getusertitle(1));
		model.addAttribute("ulocation", getuserloc(1));
		model.addAttribute("ulinkedin", getuserlink(1));

		return "res";
	}

}
