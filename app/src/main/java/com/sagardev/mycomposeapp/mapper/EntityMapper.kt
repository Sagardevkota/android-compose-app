package com.sagardev.mycomposeapp.mapper

interface EntityMapper<Entity,DTO> {
    fun mapFromEntity(Entity:Entity):DTO
    fun mapToEntity(Dto:DTO):Entity
}