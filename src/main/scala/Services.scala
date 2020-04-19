import java.util

import scala.jdk.CollectionConverters._

object Services {

  def viewList(term: String): util.List[Book] = BookList.list.filter(book => book.author == term || book.title == term).asJava

  def search(isbn: String): util.List[Book] = BookList.list.filter(book => book.isbn == isbn).asJava

  def add(book: Book): util.List[Book] =  (BookList.list += book).asJava

}
