import java.util

import com.google.gson.GsonBuilder

import scala.collection.mutable.ListBuffer

object Parser {

  def parser(method:String,uri:String,body:String)={
    var buf = ListBuffer(method)
    if ("GET" == method) {
      val term = uri.split("=")(0)
      val name = uri.split("=")(1)
      buf += term
      buf += name
    }
    else if ("POST"==method){
      buf += body
    }
    else buf
  }

  val gson = new GsonBuilder().setPrettyPrinting().create

  def toJson(res:util.List[Book]): String = {
    gson.toJson(res)
  }

  def fromJson(sb:String) = {
    gson.fromJson(sb,classOf[Book])
  }

}
