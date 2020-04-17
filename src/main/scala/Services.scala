import scala.jdk.CollectionConverters._

object Services {

  def viewList(term: String): String = {
    val res = BookList.ls.filter(book => book.author == term || book.title == term).asJava
    if (res.isEmpty) "No entry was found"
    else  Parser.toJson(res)
  }

  def search(isbn: String): String = {
    val res = BookList.ls.filter(book => book.isbn == isbn).asJava
    if (res.isEmpty) "No entry was found"
    else  Parser.toJson(res)
  }

  def add(sb: String): String = {
    val book = Parser.fromJson(sb)
    val res = (BookList.ls += book).asJava
    Parser.toJson(res)
  }

}
