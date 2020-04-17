import scala.collection.mutable.ListBuffer

object Controller {

  def controller(bs:ListBuffer[String])={
    val method = bs(0)

    if (method.equals("GET")){
      val term = bs(1)
      val name = bs(2)
      if (term.equals("isbn")) Services.search(name)
      else Services.viewList(name)}
    else if (method.equals("POST")) Services.add(bs(1))
    else "Invalid Request"
  }
}
