package com.example.netflix.domain.util

interface DomainMapper <T, DomainModel> {

    fun mapFromDomainModel  (domainModel: DomainModel): T

    fun mapToDomainModel(model: T): DomainModel

}
