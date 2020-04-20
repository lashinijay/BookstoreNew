import java.util

object Controller {

  def controller(method:String, uri:String, body:String)={
    val msg = "Invalid Request"
    if (method.equals("GET")) {
      val buf = Parser.parseSearchRequest(uri)
      val term = buf(0)
      val value = buf(1)
      if (term.equals("isbn")) {
        val res = Services.searchByIsbn(value)
        checkList(res)}
      else if(term.equals("author")||term.equals("title")){
        val res = Services.searchByName(value)
        checkList(res)}
      else msg}
    else if (method.equals("POST")){
      val book = Parser.parseAddRequest(body)
      Services.add(book)
      "Successfully Added"}
    else msg }

  def checkList(res:util.List[Book]) = {
    if (res.isEmpty) "No entry was found"
    else  Parser.toJson(res)}
}
