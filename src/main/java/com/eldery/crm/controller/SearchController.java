package com.eldery.crm.controller;


import com.eldery.crm.controller.CompanyController;
import com.eldery.crm.controller.PersonController;
import com.eldery.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/search")
@RequiredArgsConstructor
public class SearchController {
    private final CompanyController companyController;
    private final PersonController personController;
    private final UserController userController;

    @PostMapping("")
    public ResponseEntity<List<Map<String, String>>> search(@RequestBody Map<String, String> request) {
        if (request.containsKey("company")) {
            return companyController.findCompanyByParams(request);
        } else if (request.containsKey("person")) {
            return personController.findPersonByParams(request);
        } else if (request.containsKey("responsible")) {
            return userController.findUserByParams(request);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }
}
