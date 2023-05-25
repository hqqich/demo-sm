package com.tsinglink

import com.tsinglink.controller.ApiSignHandlerImpl
import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.TimeoutHandler


class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {


    val router = Router.router(vertx)

    val server = vertx.createHttpServer()
    // 解析启
    router.route().handler(BodyHandler.create())
    // 超时时间
    router.route().handler(TimeoutHandler.create(5000))


    router.route("/api/*").handler(ApiSignHandlerImpl())

    router.route("/test").handler(ApiSignHandlerImpl()).handler { ctx: RoutingContext ->
      val response = ctx.response()
      response.putHeader("content-type", "application/json")
      response.end("{\"idCard\":\"341223199902050118\",\"activiId\":\"1\"}")
    }

    server
      .requestHandler(router)
      .listen(8888)
      .onSuccess { server ->
        println("HTTP server started on port " + server.actualPort())
      }

  }

  override fun stop(stopPromise: Promise<Void>?) {
    super.stop(stopPromise)
  }

}
