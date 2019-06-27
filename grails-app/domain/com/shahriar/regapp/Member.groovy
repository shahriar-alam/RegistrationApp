package com.shahriar.regapp

class Member {

    Integer id
    String firstName
    String lastName
    String email
    String password
    Date birthDate
    String memberType = GlobalConfig.USER_TYPE.REGULAR_MEMBER
    String identityHash
    Date identityHashLastUpdate
    Boolean isActive = true

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(email: true, nullable: false, blank: false, unique: true)
        password(blank: false)
        lastName(nullable: true)
        identityHash(nullable: true)
        identityHashLastUpdate(nullable: true)
    }

    def beforeInsert() {
        this.password = this.password.encodeAsMD5()
    }

    def beforeUpdate() {
        this.password = this.password.encodeAsMD5()
    }
}
