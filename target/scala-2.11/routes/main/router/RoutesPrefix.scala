
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/synerzip/Projects/ExamSystem/conf/routes
// @DATE:Mon Mar 07 17:25:57 IST 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
