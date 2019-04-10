object Lists {

  def getLastElement(list: List[Int]): Int = {
    list.last
  }

  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  def isPalindrome(list: List[Int]): Boolean = {
    if (list.isEmpty)
      return false
    val reversedList = reverse(list)
    val validation = list.zip(reversedList).map({
      case (item, reversedItem) => item == reversedItem
    })
    !validation.contains(false)
  }

  def compress(list: List[String]): List[String]  = {
    list.distinct
  }

}
