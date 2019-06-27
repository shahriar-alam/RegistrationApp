package com.shahriar.regapp

import org.grails.web.util.WebUtils

class AppUtil {

    static SaveResponse(Boolean isSuccess, def model) {
        return [isSuccess: isSuccess, model: model]
    }
    static getApSession() {
        return WebUtils.retrieveGrailsWebRequest().session
    }
    static infoMessage (String message, Boolean status = true) {
        return [info:message, success:status]
    }
}
