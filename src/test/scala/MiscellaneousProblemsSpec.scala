import org.scalatest.{Matchers, WordSpec}

class MiscellaneousProblemsSpec extends WordSpec with Matchers {

  "fullWords" should {
    "when given a one digit numer should return the name of that number as a string" in {
      MiscellaneousProblems.fullWords(1) shouldEqual "one"
      MiscellaneousProblems.fullWords(2) shouldEqual "two"
      MiscellaneousProblems.fullWords(3) shouldEqual "three"
      MiscellaneousProblems.fullWords(4) shouldEqual "four"
      MiscellaneousProblems.fullWords(5) shouldEqual "five"
      MiscellaneousProblems.fullWords(6) shouldEqual "six"
      MiscellaneousProblems.fullWords(7) shouldEqual "seven"
      MiscellaneousProblems.fullWords(8) shouldEqual "eight"
      MiscellaneousProblems.fullWords(9) shouldEqual "nine"
    }
    "when given a 2 digit number should return the name of the separet digits seperated with '-'" in {
      MiscellaneousProblems.fullWords(11) shouldEqual "one-one"
      MiscellaneousProblems.fullWords(23) shouldEqual "two-three"
      MiscellaneousProblems.fullWords(35) shouldEqual "three-five"
    }
    "when given a 3 digit number should return the name of the separet digits seperated with '-'" in {
      MiscellaneousProblems.fullWords(123) shouldEqual "one-two-three"
      MiscellaneousProblems.fullWords(345) shouldEqual "three-four-five"
      MiscellaneousProblems.fullWords(679) shouldEqual "six-seven-nine"
    }
  }
}
