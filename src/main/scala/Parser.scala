import java.util

object Parser {

  def parser(method: String , uri :String, body :String):String={
    var response = ""
    if ("GET" == method){
      val name = uri.split("=")(1)
      if (uri.split("=")(0) == "isbn") Services.search(name)
      else Services.viewList(name)
    }
    else if ("POST"==method)
        Services.add(body)
    else{"Null"}
  }

}
