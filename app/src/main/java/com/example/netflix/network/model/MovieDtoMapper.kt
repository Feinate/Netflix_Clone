package com.example.netflix.network.model

import com.example.netflix.domain.model.Movie
import com.example.netflix.domain.util.DomainMapper

class MovieDtoMapper : DomainMapper<MovieDto, Movie> {
    override fun mapFromDomainModel(domainModel: Movie): MovieDto {
        return MovieDto(
            poster_path = domainModel.poster_path,
            overview = domainModel.overview,
            released_date = domainModel.released_date,
            id = domainModel.id,
            original_title = domainModel.original_title,
            vote_count = domainModel.vote_count,
            vote_average = domainModel.vote_average
        )
    }

    override fun mapToDomainModel(model: MovieDto): Movie {
        return Movie(
            poster_path = model.poster_path,
            overview = model.overview,
            released_date = model.released_date,
            id = model.id,
            original_title = model.original_title,
            vote_count = model.vote_count,
            vote_average = model.vote_average
        )
    }

    fun fromDomainList(initial: List<Movie>): List<MovieDto> {
        return initial.map { mapFromDomainModel(it) }
    }

    fun toDomainList(initial: List<MovieDto>): List<Movie> {
        return initial.map { mapToDomainModel(it) }
    }
}