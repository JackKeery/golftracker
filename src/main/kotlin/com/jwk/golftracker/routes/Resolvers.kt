package com.jwk.golftracker.routes

import com.jwk.golftracker.repo.RepositoryProvider.scoreRepository
import com.jwk.golftracker.routes.Errors.invalidUserId
import com.jwk.golftracker.routes.Errors.textError
import com.jwk.golftracker.routes.Errors.userNotFound
import com.jwk.golftracker.routes.ParamKeys.COUNT
import com.jwk.golftracker.routes.ParamKeys.NAME
import com.jwk.golftracker.routes.ParamKeys.SCORE
import com.jwk.golftracker.routes.ParamKeys.USER_ID
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

internal typealias Context = PipelineContext<Unit, ApplicationCall>
internal typealias RequestResolver = suspend Context.() -> Unit

internal object Resolvers {

    private val repo = scoreRepository

    val getUser: RequestResolver = {
        call.parameters[USER_ID]?.toLongOrNull()?.let { id ->
            repo.getUser(id)?.let {
                call.respond(OK, it)
            } ?: userNotFound(id)
        } ?: invalidUserId()
    }

    val newUser: RequestResolver = {
        call.parameters[NAME]?.let { newUserName ->
            call.respond(OK, repo.addUser(newUserName))
        }
    }

    val updateUser: RequestResolver = {
        call.parameters[USER_ID]?.toLongOrNull()?.let { id ->
            if (!repo.hasUser(id)) {
                userNotFound(id)
                return@let
            }

            val name = call.request.queryParameters[NAME]
            val score = call.request.queryParameters[SCORE]
            if (
                // Score is present, but not a valid long
                score != null && score.toLongOrNull() == null
                // Or, neither name nor score is present
                || name == null && score == null
            ) {
                textError("At least one of query parameters $NAME and $SCORE must be provided. $SCORE must be a valid long")
                return@let
            }

            name?.let { it ->
                repo.setName(id, it)
            }
            score?.toLongOrNull()?.let { it ->
                repo.setScore(id, it)
            }
            repo.getUser(id)?.let {
                call.respond(OK, it)
            }
        } ?: invalidUserId()
    }

    val postUserScore: RequestResolver = {
        call.parameters[USER_ID]?.toLongOrNull()?.let { userId ->
            call.parameters[SCORE]?.toLongOrNull()?.let { score ->
                if (repo.hasUser(userId)) {
                    repo.newScore(userId, score)
                    call.respond(OK, requireNotNull(repo.getUser(userId)))
                } else {
                    userNotFound(userId)
                }
            } ?: textError("Must include query parameter $SCORE with valid long value")
        } ?: invalidUserId()
    }

    val getTopScorers: RequestResolver = {
        val topScorers = call.parameters[COUNT]?.toIntOrNull()?.let {
            repo.getTopScores(it)
        } ?: repo.getTopScores()
        call.respond(OK, topScorers)
    }

}