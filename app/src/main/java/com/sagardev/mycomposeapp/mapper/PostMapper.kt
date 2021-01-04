package com.sagardev.mycomposeapp.mapper

import com.sagardev.mycomposeapp.model.Post
import com.sagardev.mycomposeapp.model.PostDTO

class PostMapper:EntityMapper<Post,PostDTO>{
    override fun mapFromEntity(Entity: Post): PostDTO {
        return PostDTO()
    }

    override fun mapToEntity(Dto: PostDTO): Post {
        return Post(Dto.userId,
                Dto.id,
                Dto.title,
                Dto.body
        )
    }

    fun toEntityList(posts:List<PostDTO>):List<Post>{
       return posts.map { postDTO -> mapToEntity(postDTO) }
    }

}