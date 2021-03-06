package controllers

import javax.inject._
import play.api._
import play.api.mvc._


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def contacts() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.contacts())
  }

  def helloRedirect() = Action {
    Redirect("/contacts")
  }

  private val productMap = Map(1 -> "Keyboard", 2 -> "Mouse", 3 -> "Monitor")

  def listProducts() = Action {
    Ok(views.html.products(productMap.values.toSeq))
  }

  def product(prodType: String, prodNum: Int) = Action {
    Ok(s"Product type is : $prodType, product number is $prodNum")
  }
}