package com.drona.dronaapp.service

import spock.lang.Specification

class UserServiceTest extends Specification {
    def "FindAllUsers"() {
    }

    def "AddUser"() {
    }

    def "FindByUserName"() {
    }

    def "VerifyLogin"(String userName, String password, Boolean verifyLogin) {
        given: ""
        UserService userService = new UserService();

        expect:
        userService.verifyLogin(userName, password) == verifyLogin

        where:
        userName         || password   || verifyLogin
        "midhun.mithran" || "Wipro123" || true
        "midhun.mithran" || "Wipro@123"
        "test"           || "test"

    }

    def "DeleteUser"() {
    }
}
