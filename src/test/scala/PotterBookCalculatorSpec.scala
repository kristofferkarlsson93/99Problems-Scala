import org.scalatest.{Matchers, WordSpec}

class PotterBookCalculatorSpec extends WordSpec with Matchers {

  "The calculators base cases" should {
    "return 8 if 1 book is bought" in {
      val calculator = new PotterBookCalculator
      calculator.calculate(Seq(PotterBook("Philosophers stone"))) shouldEqual 8
    }
    "return the price with 5% discount if 2 unique books are bought" in {
      val calculator = new PotterBookCalculator
      val books = Seq(PotterBook("Philosophers stone"), PotterBook("Chamber of secrets"))
      val result = calculator.calculate(books)
      result shouldEqual 15.2
    }
    "return the price with 10% discount if 3 unique books are bought" in {
      val calculator = new PotterBookCalculator
      val books = Seq(PotterBook("Philosophers stone"), PotterBook("Chamber of secrets"), PotterBook("Prisoner of azkaban"))
      val result = calculator.calculate(books)
      result shouldEqual 21.6
    }
    "return the price with 20% discount if 4 unique books are bought" in {
      val calculator = new PotterBookCalculator
      val books = Seq(PotterBook("Philosophers stone"), PotterBook("Chamber of secrets"), PotterBook("Prisoner of azkaban"), PotterBook("The goblet of fire"))
      val result = calculator.calculate(books)
      result shouldEqual 25.6
    }
    "return the price with 25% discount if 5 unique books are bought" in {
      val calculator = new PotterBookCalculator
      val books = Seq(
        PotterBook("Philosophers stone"),
        PotterBook("Chamber of secrets"),
        PotterBook("Prisoner of azkaban"),
        PotterBook("The goblet of fire"),
        PotterBook("The order of the phenix")
      )
      val result = calculator.calculate(books)
      result shouldEqual 30.00
    }
  }

  "The calculators more advanced cases" should {
    "return no discount when buying 2 of the same book" in {
      val calculator = new PotterBookCalculator
      val books = Seq(PotterBook("Philosophers stone"), PotterBook("Philosophers stone"))
      val result = calculator.calculate(books)
      result shouldEqual 15.2
    }
  }

}
