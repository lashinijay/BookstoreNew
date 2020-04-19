import scala.collection.mutable.ListBuffer

object Controller {

  def controller(bs:ListBuffer[String])={
    val method = bs(0)
    if (method.equals("GET")){
      val term = bs(1)
      val name = bs(2)
      if (term.equals("isbn")) {
        val res = Services.search(name)
        if (res.isEmpty) "No entry was found"
        else  Parser.toJson(res)}
      else{
        val res = Services.viewList(name)
        if (res.isEmpty) "No entry was found"
        else  Parser.toJson(res)
      }}
    else if (method.equals("POST")) {
      val book = Parser.fromJson(bs(1))
      val res = Services.add(book)
      Parser.toJson(res)
    }
    else "Invalid Request"
  }
}
