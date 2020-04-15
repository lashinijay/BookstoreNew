import com.google.gson.{Gson, GsonBuilder}

object Services {

  def viewList(term: String): String = {
    val gson = new GsonBuilder().setPrettyPrinting.create
    val res = BooksDAO.viewlist(term)
    val response = gson.toJson(res)
    response
  }

  def search(title: String): String = {
    val gson = new GsonBuilder().setPrettyPrinting.create
    val res = BooksDAO.bookdetails(title)
    val response = gson.toJson(res)
    println("book")
    response
  }

  def add(sb: String): String = {
    val gson = new GsonBuilder().setPrettyPrinting.create
    val gson1 = new Gson
    val res = BooksDAO.addbook(gson1.fromJson(sb, classOf[Book]))
    val response = gson.toJson(res)
    response
  }

}
