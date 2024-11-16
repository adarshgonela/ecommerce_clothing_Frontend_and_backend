//package com.ai.adarsh.AI_service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/address")
//public class AddressController {
//
//	@Autowired
//	private AddRepo addrepo;
//
//	@GetMapping(value = "/ms1")
//	public String ms1() {
//		return "hii i am ms2 ";
//	}
//
//
//	@GetMapping("/address")
//	public List<Address> getAddress() {
//		return addrepo.findAll();
//	}
//	@Autowired
//    Environment environment;
//
//    @GetMapping("/data")
//    public String getBookData() {
//       return "data of BOOK-SERVICE, Running on port: "
//         +environment.getProperty("local.server.port");
//    }
//
//    @GetMapping("/addall")
//    public List<Address> getAddressall() {
//    	return addrepo.findAll();
//    }
//
//
//    @GetMapping("/{id}")
//    public Optional<Address> getAddressById(@PathVariable int id) {
//    	 Optional<Address> address = addrepo.findById(id);
//       return address;
//    }
//
//
//}
