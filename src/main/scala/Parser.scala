import java.util

import com.google.gson.GsonBuilder

import scala.collection.mutable

object Parser {

  val gson = new GsonBuilder().setPrettyPrinting().create

  def toJson(res:util.List[Book]): String = gson.toJson(res)

  def fromJson(sb:String) = gson.fromJson(sb,classOf[Book])

  def parseAddRequest(body:String)= fromJson(body)

  def parseSearchRequest(uri:String)={
    var buf = new mutable.ListBuffer[String]
    val term = uri.split("=")(0)
    val name = uri.split("=")(1)
    buf += term
    buf += name }
}
