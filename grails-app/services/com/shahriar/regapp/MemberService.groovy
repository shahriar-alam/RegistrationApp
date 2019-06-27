package com.shahriar.regapp

import grails.web.servlet.mvc.GrailsParameterMap

class MemberService {

    def save(GrailsParameterMap params) {
        Member member = new Member(params)
        def response = AppUtil.SaveResponse(false,member)
        if(member.validate()){
            member.save(flush: true)
            if(!member.hasErrors()){
                response.isSuccess = true
            }
        }
        return response
    }

    def update(Member member, GrailsParameterMap params){
        member.properties = params
        def response = AppUtil.SaveResponse(false,member)
        if(!member.validate()){
            member.save(flush: true)
            if(!member.hasErrors()){
                response.isSuccess = true
            }
        }
        return response
    }

    def getById(Serializable id){
        return Member.get(id)
    }

    def list(GrailsParameterMap params){
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<Member> members = Member.createCriteria().list(params){
            if(params?.colName && params?.colValue){
                like(params.colName, "%" + params.colValue + "%")
            }
            if(!params.sort()){
                order("id","desc")
            }
        }
    }

    def delete(Member member){
        try{
            member.delete(flush:true)
        }
        catch (Exception e){
            println(e.getMessage())
            return false
        }
        return true
    }

}
