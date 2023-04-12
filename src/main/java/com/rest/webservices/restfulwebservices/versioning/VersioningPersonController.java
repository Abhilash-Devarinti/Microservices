package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfperson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v3/person")
    public PersonV2 getSecondVersionOfPerson(){
        Name name = new Name("Abhilash", "Devarinti");
        return new PersonV2(name);
    }

//    Request Parameter
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonByParam () {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonByParam(){
        Name name = new Name("Abhilash", "Devarinti");
        return new PersonV2(name);
    }


//    Request header
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonByRequestHeader () {
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonByRequestHeader () {
        Name name = new Name("Abhilash", "Devarinti");
        return new PersonV2(name);
    }

//    Media Type heading -- accept headers
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
        public PersonV1 getFirstVersionOfPersonByMedia () {
            return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonByMedia () {
        Name name = new Name("Abhilash", "Devarinti");
        return new PersonV2(name);
    }

}

/*
Factors Consider
    URI pollution
    Misuse of HTTP header
    caching
    can we execute the request on the browser
    api documentation -- easy for Uri mapping tough for headers and media type
 */
