import com.google.gson.GsonBuilder

object Services {

  val gson = new GsonBuilder().setPrettyPrinting.create

  def viewList(term: String): String = {
    val res = BooksDAO.viewlist(term)
    val response = gson.toJson(res)
    response
  }

  def search(title: String): String = {
    val res = BooksDAO.bookdetails(title)
    val response = gson.toJson(res)
    println("book")
    response
  }

  def add(sb: String): String = {
    val res = BooksDAO.addbook(gson.fromJson(sb, classOf[Book]))
    val response = gson.toJson(res)
    response
  }

}
