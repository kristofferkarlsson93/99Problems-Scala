import org.scalatest.{Matchers, WordSpec}

class ListsSpec extends WordSpec with Matchers {

  "getLastElement" should {
    "return the last element" in {
      val list = List(1, 2, 3)
      val result = Lists.getLastElement(list)
      result shouldEqual 3
    }
  }

  "reverse" should {
    "return the list reversed" in {
      val list = List(1, 2, 3)
      val result = Lists.reverse(list)
      result shouldEqual List(3, 2, 1)
    }
  }

  "isPalindrome" should {
    "return true when given 121" in {
      val list = List(1, 2, 1)
      val result = Lists.isPalindrome(list)
      result shouldEqual true
    }
    "should return false when given 112" in {
      val list = List(1, 1, 2)
      val result = Lists.isPalindrome(list)
      result shouldEqual false
    }
    "should return false when given empty list" in {
      val list = List.empty
      val result = Lists.isPalindrome(list)
      result shouldEqual false
    }
  }
}
