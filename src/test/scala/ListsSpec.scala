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

  "compress" should {
    "when given a list of 3 elements where 2 is the same should return a list of 2" in {
      val list = List("a", "b", "b")
      val result = Lists.compress(list)
      result shouldEqual List("a", "b")
    }
    "when given a list of 4 element where 2 is same but does not come in order should preserve order" in {
      val list = List("c", "a", "c", "a")
      val result = Lists.compress(list)
      result shouldEqual List("c", "a")
    }
  }
}
