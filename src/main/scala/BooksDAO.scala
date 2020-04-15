import java.util
import collection.JavaConverters._

object BooksDAO {
  def addbook(book: Book): String = {
    var ls = BookList.ls
    (ls += book)
    "book was successfully added"
  }

  def bookdetails(t: String): Book = {
    var ls = BookList.ls
    (ls.filter(Book=> Book.isbn ==t)(0))
  }

  def viewlist(t: String): util.List[Book] ={
    var ls = BookList.ls
    ls.filter( Book => (Book.author == t || Book.title == t)).asJava
  }
}
