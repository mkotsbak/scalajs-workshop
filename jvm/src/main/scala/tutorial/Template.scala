package tutorial

import scalatags.Text.TypedTag
import scalatags.Text.all._
import scalatags.Text.tags2.title

/**
  * This uses scalatags on the serverside, which as we can see
  *  renders as `String`, because we import from `scalatags.Text`.
  */
object Template {
  def scriptTag(s: String): TypedTag[String] =
    script(`type` := "text/javascript", src := s)

  val asScalaTags: TypedTag[String] =
    html(
      head(
        title("Example Scala.js application"),
        meta(
          httpEquiv := "Content-Type",
          content   := "text/html; charset=UTF-8"
        ),
        Seq(
          "/scala-js-workshop-jsdeps.js",
          "/scala-js-workshop-fastopt.js"
        ) map scriptTag,
        link(
          rel  := "stylesheet",
          tpe  := "text/css",
          href := "META-INF/resources/webjars/bootstrap/3.3.5/css/bootstrap.min.css"
        )
      ),
      body(margin := 0),
      Seq(
        "/scala-js-workshop-launcher.js",
        "//localhost:12345/workbench.js"
      ) map scriptTag
    )

  val asText: String =
    "<!DOCTYPE html>" + asScalaTags
}
